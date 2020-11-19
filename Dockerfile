FROM openjdk:8-jre
WORKDIR /
#add required jars
ADD coins-0.0.1-SNAPSHOT.jar coins-0.0.1-SNAPSHOT.jar

#expose port
EXPOSE 8080
#cmd to execute
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/coins-0.0.1-SNAPSHOT.jar"]
