<<<<<<< HEAD
FROM openjdk:8-jre
WORKDIR /
#add required jars
ADD coins-0.0.1-SNAPSHOT.jar coins-0.0.1-SNAPSHOT.jar

#expose port
EXPOSE 8080
#cmd to execute
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/coins-0.0.1-SNAPSHOT.jar"]
=======
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/coins-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080

>>>>>>> 053e611319fffd372c10de8f069b65f8f2db40ad
