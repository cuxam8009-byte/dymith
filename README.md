# Dymith Browser

Trình duyệt Android nhẹ, lõi viết bằng Rust, giao diện mobile Dymith tối giản, thanh tìm kiếm nổi ở cạnh dưới.
Repo đang ở **Phase 0**: dựng đường ống build và đo đạc trên máy thật.

## Cấu trúc

| Thư mục | Nội dung |
|---|---|
| `core/` | Lõi Rust: phân giải ô địa chỉ, chặn quảng cáo mẫu, cầu JNI sang Kotlin |
| `app/` | Vỏ Android (Kotlin, View thuần): WebView + thanh công cụ kính + chẩn đoán |
| `ci/build.sh` | Toàn bộ quy trình build: Rust, kiểm tra căn 16 KB, Gradle, Release |
| `docs/PHASE0.md` | Danh sách bài thử cho Phase 0 |

## Cập nhật mã

Upload một file `.zip` vào thư mục gốc của repo. Workflow `Dymith build` sẽ tự giải nén,
commit, dựng APK và đăng lên mục Releases (tag `nightly`).

## Kiến trúc

Lõi Rust nói chuyện với vỏ Kotlin qua JNI. Engine web đứng sau một giao diện trừu tượng:
v1 dùng WebView hệ thống, Servo và GeckoView là các hướng thử nghiệm ở Phase 3.


## Giao diện trang khởi động (bản cập nhật)
- Dashboard mobile Dymith với header thương hiệu, lối tắt, thẻ tiện ích và danh sách khám phá.
- Thanh tìm kiếm/địa chỉ nằm cố định ở cạnh dưới trong vỏ Android; không còn thanh điều hướng Trang chủ/Khám phá/Tab/Tải xuống/Cá nhân.
- Trang khởi động dùng HTML/CSS cục bộ, không tải thư viện hoặc ảnh từ mạng để giữ thời gian hiển thị và dung lượng thấp.
- Lõi Rust được giữ nguyên trong lần cập nhật giao diện này.
