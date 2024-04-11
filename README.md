# BookMyShow
For Book-My-Show
Setting up Apache Kafka on your local machine involves several steps. Here's a basic guide:

1. **Prerequisites**:
    - Java Development Kit (JDK) installed on your machine. Kafka requires Java to run.
    - Apache ZooKeeper. Kafka uses ZooKeeper for distributed coordination.

2. **Download Kafka**:
    - Visit the Apache Kafka website and download the latest version of Kafka: [Apache Kafka Downloads](https://kafka.apache.org/downloads).
    - Choose the binary version and download the tar.gz file.

3. **Extract Kafka**:
    - Once downloaded, extract the Kafka tar.gz file to a directory of your choice.

4. **Start ZooKeeper**:
    - Kafka relies on ZooKeeper, so you need to start it first.
    - Navigate to the Kafka directory in your terminal.
    - Run the following command to start ZooKeeper:
      ```
      bin/zookeeper-server-start.sh config/zookeeper.properties
      ```

5. **Start Kafka Server**:
    - Open another terminal window.
    - Navigate to the Kafka directory again.
    - Run the following command to start the Kafka server:
      ```
      bin/kafka-server-start.sh config/server.properties
      ```

6. **Create a Topic**:
    - With Kafka running, you can create a topic.
    - Open a new terminal window.
    - Navigate to the Kafka directory.
    - Run the following command to create a topic named "test" with default settings:
      ```
      bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
      ```

7. **Produce and Consume Messages**:
    - Once the topic is created, you can start producing and consuming messages.
    - To produce messages, run:
      ```
      bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
      ```
    - To consume messages, run:
      ```
      bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
      ```

That's it! You now have Kafka running on your local machine. You can produce and consume messages on the "test" topic. You can explore further configurations and features as you become more familiar with Kafka.

To publish messages to an Apache Kafka topic from a Spring Boot application, you can use the `spring-kafka` library, which provides easy integration with Kafka. Here's a basic guide to get you started:

1. **Add Dependencies**:
   Add the `spring-kafka` dependency to your `pom.xml` or `build.gradle` file:

   For Maven:
   ```xml
   <dependency>
       <groupId>org.springframework.kafka</groupId>
       <artifactId>spring-kafka</artifactId>
   </dependency>
   ```

   For Gradle:
   ```gradle
   implementation 'org.springframework.kafka:spring-kafka'
   ```

2. **Configure Kafka Properties**:
   Configure Kafka connection properties in your `application.properties` file:

   ```properties
   spring.kafka.bootstrap-servers=localhost:9092
   ```

3. **Create a Kafka Producer**:
   Create a Kafka producer class to send messages to a Kafka topic:

   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.kafka.core.KafkaTemplate;
   import org.springframework.stereotype.Service;

   @Service
   public class KafkaProducerService {

       @Autowired
       private KafkaTemplate<String, String> kafkaTemplate;

       public void sendMessage(String topic, String message) {
           kafkaTemplate.send(topic, message);
       }
   }
   ```

4. **Publish Messages from your Spring Boot Application**:
   Use the Kafka producer service to publish messages from your Spring Boot application:

   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.CommandLineRunner;
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;

   @SpringBootApplication
   public class KafkaProducerApplication implements CommandLineRunner {

       @Autowired
       private KafkaProducerService producerService;

       public static void main(String[] args) {
           SpringApplication.run(KafkaProducerApplication.class, args);
       }

       @Override
       public void run(String... args) throws Exception {
           // Publish a sample message to a Kafka topic
           producerService.sendMessage("test-topic", "Hello, Kafka!");
       }
   }
   ```

5. **Run the Application**:
   Run your Spring Boot application, and it will publish a message to the specified Kafka topic.

Make sure you have Kafka running locally and that the topic "test-topic" exists. Adjust the topic name and message content as needed for your use case.