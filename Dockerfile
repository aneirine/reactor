FROM openjdk:8-jdk-alpine
ADD target/reactor-0.0.1-SNAPSHOT.jar reactor-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar /reactor-0.0.1-SNAPSHOT.jar"]