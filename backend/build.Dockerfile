# Build step
FROM maven:3.6.0-jdk-11-slim AS build
COPY ./pokemon/src /home/app/src
COPY ./pokemon/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package  stage
FROM openjdk:11-jre-slim
WORKDIR /app
COPY ./scripts/start.sh . 
RUN chmod -R 777 start.sh
RUN groupadd -g 1000java; useradd -g java -u 1000 java -d /app

COPY  --from=build /home/app/target/pokemon-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
# ENTRYPOINT ["java","-jar","/usr/local/lib/pokemon.jar"]
