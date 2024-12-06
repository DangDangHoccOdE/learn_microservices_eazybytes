# Bắt đầu từ một base image có sẵn Java runtime
FROM openjdk:23-jdk-slim

# Cung cấp thông tin người duy trì
LABEL "org.opencontainers.image.authors"="eazybytes.com"

# Sao chép file JAR từ thư mục target của bạn vào container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Chạy ứng dụng Java khi container khởi động
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
