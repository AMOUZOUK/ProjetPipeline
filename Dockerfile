FROM openjdk:17-jdk

WORKDIR /app

COPY target/studentTest-0.0.1-SNAPSHOT.jar /app/student.jar

EXPOSE 8080

CMD ["java", "-jar", "student.jar"]