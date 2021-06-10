# Clean City

## Contents

1. [Short description](#short-description)
1. [Video](#video)
1. [The architecture](#the-architecture)
1. [Getting started](#getting-started)
1. [Authors](#Authors)
1. [Acknowledgments](#acknowledgments)

## Short description

This application clubs together resources to help you and your team use technology to solve pollution related issues around the globe that is affecting the climate adversely. In this application users can report garbage collection issues in their locality. Users can upload photographs of garbage deposits and register a complaint with address details of the dumping site. The complaints will be reviewed by the admin and appropriate action will be taken. Users will be provided with an incident number with the help of which they can check the status of their complaint.

**What's the problem?**

The waste humans generate has been detrimental to our environment for quite some time now. Humans are generating too much trash and cannot deal with it in a sustainable way. Waste that is not biodegradable and cannot properly be recycled is filling our oceans and landfills. Let’s take plastic waste as an example. A Central Pollution Control Board (CPCB) report (2018-19) puts the total annual plastic waste generation in India at a humungous 3.3 million metric tonnes per year. A global material balance study on plastics points out that 79 per cent of the total plastics produced in the world enters our environment as waste. Only 9 per cent of the total plastic waste in the world is recycled. All together, the amount of waste generated affects the environment in multiple ways: its contribution to the worsening climate crisis, its negative impact on wildlife and the natural environment, and its detriment to our very own public health.

**How can technology help?**

Technology can help in many ways. For example, technology can be used to monitor whether companies are following environmental regulations. Geo-Spatial Measurement of Air Pollution systems draw in air around gas and oil facilities to test the amount of pollutants present. Thermal conversion is another new technology that can be used to convert waste into specialty products. This process takes some cues from natural geothermal processes that use heat and pressure to turn useless materials into useful products. It could be used to turn waste into chemicals, fertilizes, oils, and other things that could give your waste another life.
	
**The idea**

To reduce garbage deposits at various sites and ensure sanitation problems are being identified and addressed upon. With the help of citizen participation and civic engagement we can reduce garbage deposits which in turn will help to achieve a clean and healthy environment.
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

