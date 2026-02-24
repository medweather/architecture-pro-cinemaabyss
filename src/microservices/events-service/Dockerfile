FROM gradle:9.1.0-jdk25-alpine AS build

WORKDIR /app

COPY . .
RUN gradle clean bootJar

FROM openjdk:25-ea-jdk-slim

ENV TZ=Europe/Moscow
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime  \
    && echo $TZ > /etc/timezone \
    && apt-get update \
    && apt-get install -y curl jq

WORKDIR /app

COPY --from=build /app/build/libs/*.jar events.jar

ENTRYPOINT exec java -jar /app/events.jar