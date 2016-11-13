# Berlin Clock
Implementation of the Berlin Clock exercise

## Requirements

It requires:
- Maven version >= 3
- JDK8

## Running the application

 1. Clone the repository 
  ```
  git clone https://github.com/javiergarciacotado/berlin-clock
  cd berlin-clock-master
  ```  
 2. Run maven phases
  ```
  mvn clean verify site --> Should run unit and integration tests and generates reporting documentation 
  mvn package --> Should generate a JAR with dependencies
  ```
 3. Run the application
  ```
  java -jar target/berlin-clock-1.0-SNAPSHOT-jar-with-dependencies.jar
  ```
  or
  ```
  mvn exec:java
  ```

## Documentation

At `target/site/index.html` there is the Javadoc documentation, failsafe and surefire reports