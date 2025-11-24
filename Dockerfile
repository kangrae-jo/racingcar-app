FROM eclipse-temurin:21-jre

WORKDIR /app

# 빌드 결과 JAR 복사 (경로/이름은 네 프로젝트에 맞게 수정)
COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
