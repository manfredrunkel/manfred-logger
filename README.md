# manfred-logger

This document describes Architecture and Design from manfred-logger component.

**Architecture and Design**

Requirements:
º Logger component should be used on any Java project.
º Logger server can receives messages from specific applications.
º Logger service must be as a cloud application.

**Scenarios:**
1) Logger component should send Log information through Internet to remote server. It should work even when remote server is offline, persisting messages locally and sending when server is up again. Message should be sent asynchronously.
2) Logger server must receive messages from any logger application. An e-commerce application will send other messages as well and should be treated differently. This way the logger server must handle all logs that is received not interfering on each other.
3)Application that uses logger component should not be interfered (pausing, waiting some execution, etc). It should execute normally even when some error happens on logger component.

**Restrictions:**
Logger component must be created with Java.
Logger messages must be sent over network.

**Components**

manfred-logger: component that contains logic to be used to log
information. 
manfred-business: contains business object logic. Business roles are inside this component, using BPO and DAO architecture. 
manfred-framework: offers useful methods for all projects. 
message-receiver: component that receives messages on server.
manfred-producer: component that sends messages on client.

Deployment diagram contains components that are useful for using manfred-logger component. Every component will be detailed below:

Application: Application that uses manfred-logger plugin.
Manfred-logger: library that contains logic to log messages on remote server.
Broker (ActiveMQ): on both nodes (application-server) it's the broker that sends log and receives acknowledge. It contains the logic that control this flow.
TCP (Log VO Object): Communication between Application and Server is TCP based, and contains the Object LogVO with relative log information.
Server: server where resides application that receives all log messages.
Application Queue: Queue that receives messages that is application based.
E-commerce Queue: Queue that receives messages related to e-commerce queue.
Cassandra Database: Database that stores log data.

**Sequence Diagram**

As it's message based, a sequence diagram will be shown below to show how logs are sent over network and processed. See next page.

**Improvements on next releases**

1) Send messages over HTTPS, using certificates.

2) Create license for applications that can use this logger (using a common key between client and server).

3) Create a Service that can receive requests from browser client using Json. This way, it can be added on Javascript with Ajax do send website information (as E-commerce example).

4) Create documentation on Log component for clients that are going to use.

**How to use manfred-logger (client).**

1) To use, if it's a based maven project add this dependency:

       <dependency>
            	<groupId>com.manfred.logger</groupId>
            	<artifactId>manfred-logger</artifactId>
            	<version>1.0-SNAPSHOT</version>
       </dependency>

Otherwise, add manfred-logger.jar on project dependency.

2) Create a logger.properties file on application, on src/main/resources defining:

Application name that uses this logger

    applicationName=Application.

If it's a remote log, please define URL to Server Log.
Example: IP:PORT, (192.168.0.1:6161)

    loggerURL=localhost:61616
    
**Deploy Instructions for Windows/Linux**

To deploy server that receives messages, please check:

1) If Java 7 JRE is installed.
2) If database started correctly.
3) Check for a port that is not used or filtered by a firewall to receive log messages.

To Start:

Open command-line program.

1) Access folder where receiver.jar is located.
2) Access folder apps\apache-cassandra-2.1.8\bin
3) Type "cassandra" and press enter.
4) Wait until database starts.

Open command-line program

1) Access folder where receiver.jar is located.
2) Type "java -jar -Dport=8585 receiver.jar ".
3) If it's necessary, please change -Dport to another port that is not in use.
