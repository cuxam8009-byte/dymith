package dev.dymith.browser

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.RenderEffect
import android.graphics.RenderNode
import android.graphics.Shader
import android.view.View
import android.view.ViewTreeObserver

/**
 * Lớp nền "kính" thử nghiệm (Android 12+): mỗi khung hình ghi lại nội dung của [source]
 * (WebView) vào một RenderNode, làm mờ bằng RenderEffect rồi vẽ ngay phía sau thanh công cụ.
 *
 * Đây là thử nghiệm quan trọng nhất của Phase 0: WebView có đi vào đường chụp này được không.
 * Mọi lỗi đều được bắt lại; khi lỗi, lớp tự tắt và thanh công cụ rơi về kính nhuộm màu.
 */
class GlassBackdrop(context: Context) : View(context) {

    var source: View? = null

    @Volatile
    var lastError: String? = null
        private set

    var recordedFrames: Long = 0L
        private set

    private val node = RenderNode("dymith-glass-backdrop")
    private val myLoc = IntArray(2)
    private val srcLoc = IntArray(2)
    private var pad = 0
    private var blurPx = 0f
    private var effectDirty = true
    private var failed = false
    private var observer: ViewTreeObserver? = null

    private val preDraw = ViewTreeObserver.OnPreDrawListener {
        record()
        true
    }

    fun setBlurRadiusPx(px: Float) {
        if (px != blurPx) {
            blurPx = px
            pad = (px * 2f).toInt() + 1
            effectDirty = true
        }
    }

    val isFailed: Boolean
        get() = failed

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val o = viewTreeObserver
        observer = o
        o.addOnPreDrawListener(preDraw)
    }

    override fun onDetachedFromWindow() {
        val o = observer
        if (o != null && o.isAlive) o.removeOnPreDrawListener(preDraw)
        observer = null
        super.onDetachedFromWindow()
    }

    private fun applyEffect() {
        val blur = RenderEffect.createBlurEffect(blurPx, blurPx, Shader.TileMode.CLAMP)
        val saturation = ColorMatrix()
        saturation.setSaturation(1.7f)
        val boost = RenderEffect.createColorFilterEffect(ColorMatrixColorFilter(saturation))
        node.setRenderEffect(RenderEffect.createChainEffect(boost, blur))
    }

    private fun record() {
        val src = source ?: return
        if (failed || !isShown) return
        val w = width
        val h = height
        if (w <= 0 || h <= 0 || src.width <= 0 || src.height <= 0) return
        try {
            if (effectDirty) {
                applyEffect()
                effectDirty = false
            }
            getLocationInWindow(myLoc)
            src.getLocationInWindow(srcLoc)
            node.setPosition(-pad, -pad, w + pad, h + pad)
            node.setClipToBounds(true)
            val canvas = node.beginRecording(w + 2 * pad, h + 2 * pad)
            try {
                canvas.translate(
                    (pad + srcLoc[0] - myLoc[0]).toFloat(),
                    (pad + srcLoc[1] - myLoc[1]).toFloat()
                )
                src.draw(canvas)
            } finally {
                node.endRecording()
            }
            recordedFrames++
        } catch (t: Throwable) {
            failed = true
            lastError = t.javaClass.simpleName + ": " + (t.message ?: "")
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (failed || source == null) return
        if (canvas.isHardwareAccelerated) {
            canvas.drawRenderNode(node)
        }
    }
}
