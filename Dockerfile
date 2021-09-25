FROM tomcat:8.5.63-jdk11 AS webapp

WORKDIR /Cabiner_Medical

COPY . .

RUN apt-get update && \
    apt install maven -y && \
    java -version && \
    mvn -version

RUN mvn package

RUN cp -rf ./target/Cabinet_Medical-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps

FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=Strong@Independent1Password
ENV MYSQL_DATABASE=bd_cabinetmedicale

ADD ./resources/dataBases.sql /docker-entrypoint-initdb.d

WORKDIR /usr/local/tomcat

COPY --from=webapp /usr/local/tomcat /usr/local/tomcat

WORKDIR /usr/local/tomcat/webapps

ENV CATALINA_BASE=/usr/local/tomcat
ENV CATALINA_HOME=/usr/local/tomcat
ENV CATALINA_TMPDIR=usr/local/tomcat/temp
ENV JRE_HOME=/usr
ENV CLASSPATH=/usr/local/tomcat/bin/bootstrap.jar:/usr/local/tomcat/bin/tomcat-juli.jar

RUN apt-get update && \
    apt-get install openjdk-11-jdk -y && \
    apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f && \
    java -version

ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk

RUN export JAVA_HOME && \
    export CATALINA_BASE && \
    export CATALINA_HOME && \
    export CATALINA_TMPDIR && \
    export JRE_HOME && \
    export CLASSPATH

# WORKDIR /var/run

# RUN cp mysqld/ mysqld.bc -rf
# RUN chown mysql:mysql mysqld.bc/

EXPOSE 8080

WORKDIR /usr/local/tomcat/bin
RUN chmod +x catalina.sh

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
