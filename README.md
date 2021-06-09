# Clean City

## Contents

1. [Short description](#short-description)
1. [Video](#video)
1. [The architecture](#the-architecture)
1. [Getting started](#getting-started)
1. [Authors](#Authors)
1. [Acknowledgments](#acknowledgments)

## Short description

<<Write short desc>>
	
## Video

[![Watch the video](https://github.com/infyboys2020/CleanCityApp/blob/main/CleanCity_thumbnail.jpeg)](https://www.youtube.com/watch?v=tEvMhoRC7dY)

## The architecture

![Clean City architecture diagram](/arch_diagram_final.png)

### Demo Page 

Url: http://localhost:9080/fetch/demo?pin=12345

Check demo page to render image from database.


### Fetch All Report By Pin

http://localhost:9080/fetch

### Reporting Page
http://localhost:9080/reportBoard


### Authentication
```
user: admin
password: admin

```
## Getting started

These instructions will get you a copy of the project up and running on your local machine for development purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software

* [install java](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
* [install maven](https://maven.apache.org/install.html)

### Installing

A step by step series of examples that tell you how to get a development env running

Go to the root of the downloaded project in CLI

```bash
>>cd <Root>\CleanCityApp
>>mvn spring-boot:run
```

That's it.

Your code is up and running at localhost:8080/reportBoard

### Built with

* [Maven](https://maven.apache.org/) - Dependency management
* [Java Springboot](https://www.java.com/en/) - Code logic
* [IBM DB2](https://cloud.ibm.com/catalog?search=db2) - The database used
* [Tomcat](https://tomcat.apache.org/) - Web server

#### Mapping APIs

* [HERE Technologies API](https://developer.here.com)

#### Chart UIs

* [Any Chart](https://www.anychart.com/)

## Authors

* **Mayuri Ghosh**
* **Bhruguraj Sahoo**
* **Rajan Kumar**
* **Rajesh Nayak** - [rajanhhh](https://github.com/rajanhhh)
* **Ansuman Nayak**

