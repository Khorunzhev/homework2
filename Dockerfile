FROM maven:3.5.4-jdk-11
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
ADD ./pom.xml $PROJECT_DIR
RUN mvn dependency:resolve
ADD ./src/ $PROJECT_DIR/src
RUN mvn install

FROM openjdk:11-jdk
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/otus* $PROJECT_DIR/
EXPOSE 8080

CMD ["java", "-jar", "/opt/project/otus.homework2-1.0.jar"]

# docker run -p 127.0.0.1:80:8080/tcp docker.io/khorunzhev/java-app:latest