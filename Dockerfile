FROM openjdk:8-alpine

WORKDIR /app

COPY . /app

RUN apk add maven

ENTRYPOINT ["mvn", "test", "-Dtest=Runner"]

