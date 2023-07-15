FROM openjdk:8
ADD target/ICINBank-0.0.1-SNAPSHOT.jar ICINBank.jar
ENTRYPOINT ["java", "-jar", "/ICINBank.jar"]
