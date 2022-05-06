FROM openjdk:11-jre-slim

WORKDIR /app

EXPOSE 8080

COPY ./scripts/start.sh . 

RUN chmod -R 777 /app \
    && groupadd -g 1000 java \
    && useradd -g java -u 1000 java -d /app


COPY ./pokemon/target/pokemon-*.jar app.jar

USER java
