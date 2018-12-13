# springboot-rabbitmq
Building a simple application Spring Boot that send message to RabbitMQ. This application will run inside a Docker container. 

# Software used 
 - Eclipse with JDK 8
 - Maven 
 - RabbitMQ
 - Docker Toolbox
 
# Building Step 

At first, we run rabbitMQ inside Docker using the file docker-compose.yml

        version: '3'
        services:

          rabbitmq:
            container_name: rabbitmq
            image: 'rabbitmq:management'
            ports:
              - "5672:5672"
              - "15672:15672"

To run the RabbitMQ, we used : 

        $ docker-compose run 
        
Then, we will containerize the Spring Boot application using Dockerfile. This file will be generated using Maven.
For that, we add the configuration required in pom.xml file and run the command line : 

        $ mvn package 
        $ mvn docker:build

The images is created, so we can run the Spring Boot application using the command line : 

        $ docker run -p 8080:8080 -t springboot-docker 
        
In navigator, we use this link to test the application : 

        http://localhost:8080/customer?cName=test3&cId=003

If Docker is installed in local, we use localhost. For Docker Toolbox, we use the address of vitrualMachine where Docker is installed.  

To check the message received in queue, we use this link : http://localhost:15672/ 
