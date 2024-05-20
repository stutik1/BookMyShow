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
      bin/kafka-topics.sh --create --topic guru  --bootstrap-server localhost:9092
      ```

7. **Produce and Consume Messages**:
    - Once the topic is created, you can start producing and consuming messages.
    - To produce messages, run:
      ```
      bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
      ```
    - To consume messages, run:
      ```
      bin/kafka-console-consumer.sh --topic guru --from-beginning --bootstrap-server localhost:9092
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

4. **Create a Kafka Consumer**:
   Create a Kafka consumer class to send messages to a Kafka topic:

   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.kafka.core.KafkaTemplate;
   import org.springframework.stereotype.Service;

   @Service
   public class KafkaConsumerService {
   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;
   public List<String> messageList=new ArrayList<>();

   @KafkaListener(topics = "guru", groupId = "test-consumer-group")
   public void consumeMessage(String message) {
      // Process the received message here
      messageList.add(message);
      System.out.println("Received message: " + message);
    }
   }
   ```
   
5. **Publish Messages from your Spring Boot Application**:
   Use the Kafka producer service to publish messages from your Spring Boot application:

   ```java
   package com.stuti.controller;
   import com.stuti.model.Location;
   import com.stuti.service.KafkaConsumerService;
   import com.stuti.service.KafkaProducerService;
   import com.stuti.service.LocationService;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.http.HttpStatus;
   import org.springframework.http.ResponseEntity;
   import org.springframework.web.bind.annotation.*;
   
   import java.util.ArrayList;
   import java.util.List;
   
   @RestController
   @RequestMapping("/bms/location")
   public class LocationController {
   
      private final LocationService locationService;
      private final KafkaProducerService kafkaProducerService;
      private final KafkaConsumerService kafkaConsumerService;
   
      @Autowired
      public LocationController(LocationService locationService, KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService) {
         this.locationService = locationService;
         this.kafkaProducerService = kafkaProducerService;
         this.kafkaConsumerService = kafkaConsumerService;
      }
   
      @PostMapping("/create")
      public ResponseEntity<Location> createLocation(@RequestBody Location location){
         locationService.createLocation(location);
         kafkaProducerService.sendMessage("guru",location.getCity());
         return ResponseEntity.status(HttpStatus.CREATED).build();
      }
   
      @GetMapping("/getAll")
      public ResponseEntity<Location> getAllLocations(){
         List<Location> location = locationService.getLocations() ;
         List<Object> allCity = new ArrayList<>();
         allCity.addAll(location);
         allCity.addAll(kafkaConsumerService.messageList);
         return (ResponseEntity) ResponseEntity.ok(allCity);
      }
   
      @GetMapping("/{id}")
      public ResponseEntity<Location> getLocationById(@PathVariable Long id ){
         Location location = locationService.getLocationById(id);
         return ResponseEntity.ok().body(location);
      }
   }
   ```
6. **Run the Application**:
   Run your Spring Boot application, and it will publish a message to the specified Kafka topic.

Make sure you have Kafka running locally and that the topic "test-topic" exists. Adjust the topic name and message content as needed for your use case.