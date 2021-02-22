FROM tomcat:8.0.41-jre8

COPY ./target /usr/local/tomcat/webapps/webapp

CMD ["catalina.sh", "run"]
