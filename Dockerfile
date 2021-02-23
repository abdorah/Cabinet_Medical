FROM tomcat:8.5.63-jdk11

COPY ./target /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]
