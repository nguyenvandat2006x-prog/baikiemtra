# Đạt Estate

Ứng dụng web quản lý giao dịch bất động sản của **Nguyễn Văn Đạt**, phát triển bằng Java 17, Spring Boot, Thymeleaf và Spring Data JPA.

## Chạy ứng dụng đã đóng gói

Yêu cầu: JDK 17 trở lên.

```bash
java -jar target/dat-estate-1.0.0.jar
```

Mở [http://localhost:8081](http://localhost:8081). Ứng dụng sử dụng H2 in-memory và tự tạo dữ liệu mẫu khi khởi động; không cần cài MySQL.

Từ trang chi tiết, chọn **Sửa giao dịch** để cập nhật khách hàng, loại dịch vụ, ngày, đơn giá hoặc diện tích. Mã giao dịch được giữ cố định. Quy tắc ngày tương lai áp dụng khi tạo giao dịch mới; sửa hồ sơ cũ vẫn cho phép giữ ngày đã lưu.

## Build từ mã nguồn

Yêu cầu thêm Maven 3.6 trở lên.

```bash
mvn clean package
mvn spring-boot:run
```

Console H2 có tại [http://localhost:8081/h2-console](http://localhost:8081/h2-console) với JDBC URL `jdbc:h2:mem:datestate`, username `sa` và mật khẩu để trống.
