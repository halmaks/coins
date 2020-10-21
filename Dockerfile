FROM tomcat:8.5.31-jre8
RUN rm -rvf /usr/local/tomcat/webapps/ROOT
ADD  /target/coins-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/ROOT.jar
CMD ["catalina.sh", "run"]
EXPOSE 8080
