FROM maven:3-openjdk-11

COPY . .
RUN mvn install

CMD ["java", "-war", "./target/jdr-app-0.0.1-SNAPSHOT.war"]