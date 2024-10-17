FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG app_path="product-app/target/product-app-1.0.jar"
ARG app_target="/app/product-app-1.0.jar"
COPY ${app_path} ${app_target}

RUN mkdir -p /usr/local/newrelic
ADD ./newrelic/newrelic-java/newrelic.jar /usr/local/newrelic/newrelic.jar
ADD ./newrelic/newrelic-java/newrelic.yml /usr/local/newrelic/newrelic.yml

EXPOSE 8080
ENTRYPOINT ["java","-javaagent:/usr/local/newrelic/newrelic.jar", "-jar", "product-app-1.0.jar"]
