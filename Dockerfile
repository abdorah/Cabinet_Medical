FROM tomcat:latest

COPY ./target /usr/local/tomcat/webapps/webapp

CMD ["catalina.sh", "run"]
