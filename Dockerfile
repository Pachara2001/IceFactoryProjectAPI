FROM openjdk:8-jdk-slim
COPY target/IceFactory-0.0.1-SNAPSHOT.jar IceFactoryAPI.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/IceFactoryAPI.jar"]