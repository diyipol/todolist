FROM openjdk:12-alpine

COPY target/todolist-0.0.1-SNAPSHOT.jar ./todolist.jar
EXPOSE 8080
CMD java -jar todolist.jar

