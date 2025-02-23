# Use an official Tomcat 8 image
FROM tomcat:8.5-jdk11

# Set environment variables for MySQL
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=bd_cabinetmedicale
ENV MYSQL_USER=myuser
ENV MYSQL_PASSWORD=Strong@Independent1Password

# Expose ports
EXPOSE 8080 3306

# Copy WAR file into Tomcat webapps directory
COPY target/Cabinet_Medical-0.0.1-SNAPSHOT /usr/local/tomcat/webapps/

# Start script to run both MySQL and Tomcat
CMD ["sh", "-c", "service mysql start && catalina.sh run"]
