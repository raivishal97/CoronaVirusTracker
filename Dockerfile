FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

# Inform Docker that the container is listening on the specified port at runtime.
EXPOSE 5000

ENTRYPOINT ["java","-jar","/app.jar"]

##Command to create image
#docker build -t coronavirus-project-image .

##Command to run the image
#docker run -p 8080:5000 --name coronavirus-container coronavirus-project-image

##Visit the  following link
#http://localhost:8080/