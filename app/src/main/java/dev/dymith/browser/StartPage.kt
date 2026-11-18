package dev.dymith.browser

/** Trang khởi động Dymith: dashboard mobile nhẹ, không phụ thuộc tài nguyên mạng. */
object StartPage {
    const val URL = "https://start.dymith.invalid/"

    val HTML: String = """
<!doctype html>
<html lang="vi">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<meta name="color-scheme" content="light">
<meta name="theme-color" content="#f6f7ff">
<title>Dymith</title>
<style>
:root {
  color-scheme: light;
  --ink:#17264b; --muted:#7180a5; --purple:#6656df; --purple-soft:#eeedff;
  --line:rgba(102,86,223,.10); --card:rgba(255,255,255,.88);
  --shadow:0 8px 24px rgba(57,72,139,.075);
}
* { box-sizing:border-box; -webkit-tap-highlight-color:transparent; }
html { min-height:100%; background:#f5f7ff; }
body {
  margin:0; min-height:100vh; padding:calc(env(safe-area-inset-top) + 14px) 18px 126px;
  color:var(--ink); font:15px/1.45 -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Noto Sans",sans-serif;
  background:
    radial-gradient(105% 30% at 50% 0%, rgba(190,207,255,.72), transparent 72%),
    linear-gradient(180deg,#eaf0ff 0%,#f6f7ff 38%,#f7f8fc 100%);
}
button,a { font:inherit; }
a { color:inherit; text-decoration:none; }
.topline { display:flex; align-items:center; justify-content:space-between; min-height:46px; }
.iconbtn { width:40px;height:40px;border:1px solid rgba(255,255,255,.8);border-radius:14px;background:rgba(255,255,255,.62);color:#334574;display:grid;place-items:center;font-size:21px; }
.brand { display:flex;align-items:center;gap:9px;font-weight:750;font-size:23px;letter-spacing:-.7px; }
.brandmark { width:34px;height:34px;border-radius:12px;display:grid;place-items:center;color:#fff;font-weight:800;font-size:21px;background:linear-gradient(145deg,#8275f4,#5143c9);box-shadow:0 5px 12px #6d60dc40; }
.top-actions { display:flex;gap:8px; }
.hero { position:relative; overflow:hidden; margin:10px -18px 0; padding:25px 24px 28px; min-height:198px; }
.hero:before { content:"";position:absolute;inset:0;pointer-events:none;
  background:
  radial-gradient(55% 70% at 90% 5%,rgba(255,255,255,.8),transparent 72%),
  radial-gradient(70% 60% at 12% 80%,rgba(255,255,255,.68),transparent 70%),
  linear-gradient(155deg,transparent 52%,rgba(126,158,226,.16) 53%,transparent 73%); }
.hero:after { content:"";position:absolute;left:-5%;right:-5%;bottom:0;height:78px;opacity:.72;
  background:linear-gradient(145deg,transparent 12%,#b8c9ef 12.5%,#dce5fb 37%,transparent 37.5%),
             linear-gradient(25deg,transparent 26%,#c6d5f3 26.5%,#e9efff 58%,transparent 58.5%);
  clip-path:polygon(0 70%,14% 28%,26% 57%,43% 13%,58% 55%,74% 22%,88% 60%,100% 35%,100% 100%,0 100%); }
.hero-copy { position:relative;z-index:1; }
.eyebrow { color:#6476a7;font-size:12px;font-weight:650;letter-spacing:1.2px;text-transform:uppercase; }
h1 { margin:9px 0 6px;font-size:30px;line-height:1.15;letter-spacing:-1px;font-weight:760; }
.hero p { margin:0;color:#617294;font-size:14px;max-width:270px; }
.hero-mark { position:absolute;right:28px;top:18px;font-size:68px;font-weight:800;line-height:1;color:rgba(101,86,223,.15);transform:rotate(-9deg); }
.section-head { display:flex;align-items:center;justify-content:space-between;margin:15px 2px 11px; }
h2 { margin:0;font-size:15px;font-weight:750;letter-spacing:-.2px; }
.more { color:var(--purple);font-size:12px;font-weight:650; }
.shortcuts { display:grid;grid-template-columns:repeat(5,minmax(0,1fr));gap:9px; }
.shortcut { min-width:0;text-align:center; }
.shortcut .tile { height:57px;width:100%;max-width:62px;margin:auto;border:1px solid rgba(255,255,255,.95);border-radius:19px;background:var(--card);box-shadow:var(--shadow);display:grid;place-items:center;font-size:25px;font-weight:750; }
.shortcut span { display:block;margin-top:7px;font-size:11px;font-weight:600;white-space:nowrap;overflow:hidden;text-overflow:ellipsis; }
.google {color:#4285f4}.youtube {color:#f02d2d}.facebook {color:#2876e8}.tiktok {color:#111}.add {color:var(--purple);background:#f0efff!important;font-size:29px!important;font-weight:400!important}
.widgets { display:grid;grid-template-columns:1fr 1fr;gap:11px;margin-top:22px; }
.widget { min-width:0;border:1px solid rgba(255,255,255,.95);border-radius:21px;background:var(--card);box-shadow:var(--shadow);padding:14px; }
.weather { background:linear-gradient(145deg,#e7edff,#f5f6ff); }
.widget-label { color:#7180a5;font-size:11px;font-weight:650; }
.weather-main { display:flex;align-items:center;gap:9px;margin-top:8px; }
.weather-icon {font-size:33px;line-height:1}
.temp {font-size:25px;font-weight:760;letter-spacing:-1px}
.weather small {display:block;color:#7785a6;font-size:11px;margin-top:2px}
.tools { display:grid;grid-template-columns:1fr 1fr;gap:10px 4px; }
.tool { text-align:center;font-size:11px;color:#52628c;font-weight:600; }
.tool i { display:grid;place-items:center;width:38px;height:38px;margin:0 auto 5px;border-radius:14px;background:#f0efff;color:#6455d8;font-style:normal;font-size:20px; }
.news { margin-top:21px; }
.news-list { display:grid;gap:0;overflow:hidden;border:1px solid rgba(255,255,255,.95);border-radius:21px;background:var(--card);box-shadow:var(--shadow);padding:2px 14px; }
.news-item { display:grid;grid-template-columns:104px minmax(0,1fr);gap:12px;padding:12px 0;border-bottom:1px solid var(--line); }
.news-item:last-child {border-bottom:0}
.thumb {height:78px;border-radius:13px;display:grid;place-items:center;font-size:27px;background:linear-gradient(135deg,#dce7ff,#b6c8ee);overflow:hidden}
.thumb.city {background:linear-gradient(140deg,#f4c7bd,#7c8db9)}
.thumb.tech {background:linear-gradient(140deg,#dce8da,#a8bde7)}
.thumb.travel {background:linear-gradient(140deg,#b6e1e4,#5c9eb5)}
.thumb.sport {background:linear-gradient(140deg,#f1d0c5,#9c6577)}
.tag {display:inline-block;padding:3px 7px;border-radius:8px;background:#f0efff;color:#6656d8;font-size:10px;font-weight:700}
.news-title {display:-webkit-box;-webkit-line-clamp:2;-webkit-box-orient:vertical;overflow:hidden;margin:5px 0 5px;font-size:12px;line-height:1.4;font-weight:650}
.meta {color:#8a96b2;font-size:10px}
.footer-note {text-align:center;color:#a0a9bf;font-size:10px;margin:16px 0 0}

body.night { --ink:#edf0ff; --muted:#aab5d5; --card:rgba(35,43,73,.94); --line:rgba(190,190,255,.12); --shadow:0 8px 24px rgba(0,0,0,.18); background:linear-gradient(180deg,#202b4d,#151c34 45%,#11182d); }
body.night .hero:before, body.night .hero:after {opacity:.14}
body.night .hero p, body.night .eyebrow, body.night .widget-label, body.night .weather small, body.night .meta {color:#aab5d5}
body.night .widget.weather {background:linear-gradient(145deg,#303b65,#242e50)}
body.night .iconbtn {background:#2b365b;color:#edf0ff;border-color:#46527a}
body.night .news-list, body.night .widget {border-color:#46527a}
body.night .tag, body.night .tool i {background:#3a3c70;color:#d9d5ff}
body.night .thumb {filter:brightness(.78)}

@media (max-width:360px) {
 body {padding-left:14px;padding-right:14px}
 .hero {margin-left:-14px;margin-right:-14px;padding-left:20px}
 .shortcuts {gap:5px}.shortcut .tile{height:52px;max-width:56px}
 .news-item {grid-template-columns:88px minmax(0,1fr);gap:9px}
 .thumb {height:70px}
}
</style>
</head>
<body>
<header class="topline">
  <button class="iconbtn" aria-label="Mở menu" onclick="document.getElementById('menu').style.display='grid'">☰</button>
  <div class="brand"><span class="brandmark">D</span><span>Dymith</span></div>
  <div class="top-actions">
    <button class="iconbtn" aria-label="Giao diện" onclick="document.body.classList.toggle('night')">◐</button>
    <button class="iconbtn" aria-label="Tài khoản">♙</button>
  </div>
</header>
<section class="hero">
  <div class="hero-mark">D</div>
  <div class="hero-copy">
    <div class="eyebrow">Your everyday browser</div>
    <h1>Chào mừng trở lại.</h1>
    <p>Một không gian gọn gàng để khám phá thế giới web theo cách của bạn.</p>
  </div>
</section>

<div class="section-head"><h2>Truy cập nhanh</h2><a class="more" href="https://www.google.com">Tùy chỉnh</a></div>
<section class="shortcuts">
  <a class="shortcut" href="https://www.google.com"><div class="tile google">G</div><span>Google</span></a>
  <a class="shortcut" href="https://m.youtube.com"><div class="tile youtube">▶</div><span>YouTube</span></a>
  <a class="shortcut" href="https://www.facebook.com"><div class="tile facebook">f</div><span>Facebook</span></a>
  <a class="shortcut" href="https://www.tiktok.com"><div class="tile tiktok">♪</div><span>TikTok</span></a>
  <a class="shortcut" href="https://www.google.com"><div class="tile add">＋</div><span>Thêm</span></a>
</section>

<section class="widgets">
  <div class="widget weather">
    <div class="widget-label">⌖ Hà Nội</div>
    <div class="weather-main"><span class="weather-icon">⛅</span><div><div class="temp">28°</div><small>Có mây · 24°–31°</small></div></div>
  </div>
  <div class="widget">
    <div class="tools">
      <a class="tool" href="#"><i>◷</i>Lịch sử</a>
      <a class="tool" href="#"><i>⇩</i>Tải xuống</a>
      <a class="tool" href="#"><i>♧</i>Dấu trang</a>
      <a class="tool" href="#"><i>⚙</i>Cài đặt</a>
    </div>
  </div>
</section>

<section class="news">
  <div class="section-head"><h2>Khám phá hôm nay</h2><a class="more" href="https://news.google.com">Xem thêm ›</a></div>
  <div class="news-list">
    <a class="news-item" href="https://news.google.com">
      <div class="thumb city">🌆</div><div><span class="tag">Thời sự</span><div class="news-title">Những câu chuyện đáng chú ý trong ngày</div><div class="meta">Tin mới · 5 phút đọc</div></div>
    </a>
    <a class="news-item" href="https://news.google.com">
      <div class="thumb tech">💻</div><div><span class="tag">Công nghệ</span><div class="news-title">Xu hướng công nghệ và thiết bị nổi bật</div><div class="meta">Công nghệ · 4 phút đọc</div></div>
    </a>
    <a class="news-item" href="https://news.google.com">
      <div class="thumb travel">🏞️</div><div><span class="tag">Du lịch</span><div class="news-title">Những điểm đến đẹp cho hành trình tiếp theo</div><div class="meta">Khám phá · 6 phút đọc</div></div>
    </a>
    <a class="news-item" href="https://news.google.com">
      <div class="thumb sport">⚽</div><div><span class="tag">Thể thao</span><div class="news-title">Tin thể thao và những diễn biến mới nhất</div><div class="meta">Thể thao · 3 phút đọc</div></div>
    </a>
  </div>
</section>
<p class="footer-note">Dymith · Khám phá theo cách của bạn</p>

<div id="menu" style="display:none;position:fixed;inset:0;z-index:5;background:#18264b55;place-items:center;padding:24px" onclick="this.style.display='none'">
  <div style="background:white;border-radius:20px;padding:20px;width:100%;max-width:320px;box-shadow:0 16px 50px #1d2b5530">
    <b style="font-size:17px">Dymith</b><p style="color:#7180a5;font-size:13px;margin:6px 0 14px">Không gian duyệt web của bạn</p>
    <div style="display:grid;gap:12px;color:#26365d;font-size:14px"><span>⌂　Trang khởi động</span><span>☆　Dấu trang</span><span>◷　Lịch sử</span><span>⚙　Cài đặt</span></div>
  </div>
</div>
</body>
</html>
""".trimIndent()
}
