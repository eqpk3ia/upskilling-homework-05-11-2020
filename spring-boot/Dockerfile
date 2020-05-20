FROM java:8
COPY . /var/www/java
WORKDIR /var/www/java
ADD ./target/spring-boot-0.0.1-SNAPSHOT.jar spring-boot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar spring-boot-0.0.1-SNAPSHOT.jar
