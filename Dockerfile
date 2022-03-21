FROM openjdk:11
MAINTAINER com.jurema
COPY target/jurema-state-population-api-0.0.1-SNAPSHOT.jar jurema-state-population-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/jurema-state-population-api-0.0.1-SNAPSHOT.jar"]
