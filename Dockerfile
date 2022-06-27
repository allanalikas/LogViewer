FROM maven:3.8.2-jdk-11
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests -q
CMD mvn spring-boot:run