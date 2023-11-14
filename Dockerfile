FROM openjdk:8-jre-alpine
RUN mkdir /app
WORKDIR /app
COPY source dest