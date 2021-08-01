# Clean City

## Contents

1. [Short description](#short-description)
1. [Video](#video)
1. [The architecture](#the-architecture)
1. [Long Description](#long-description)
1. [Getting started](#getting-started)
1. [Authors](#Authors)
1. [Acknowledgments](#acknowledgments)

## Short description

This application clubs together resources to help you and your team use technology to solve pollution related issues around the globe that is affecting the climate adversely. In this application users can report garbage collection issues in their locality. Users can upload photographs of garbage deposits and register a complaint with address details of the dumping site. The complaints will be reviewed by the admin and appropriate action will be taken. Users will be provided with an incident number with the help of which they can check the status of their complaint.

**What's the problem?**

The waste humans generate has been detrimental to our environment for quite some time now. Humans are generating too much trash and cannot deal with it in a sustainable way. Waste that is not biodegradable and cannot properly be recycled is filling our oceans and landfills. The amount of waste generated affects the environment in multiple ways: its contribution to the worsening climate crisis, its negative impact on wildlife and the natural environment, and its detriment to our very own public health.

**How can technology help?**

Technology can help in many ways. For example, technology can be used to monitor whether companies are following environmental regulations. Geo-Spatial Measurement of Air Pollution systems draw in air around gas and oil facilities to test the amount of pollutants present. Thermal conversion is another new technology that can be used to convert waste into specialty products. This process takes some cues from natural geothermal processes that use heat and pressure to turn useless materials into useful products. It could be used to turn waste into chemicals, fertilizes, oils, and other things that could give your waste another life.
	
**The idea**

To reduce garbage deposits at various sites and ensure sanitation problems are being identified and addressed upon. With the help of citizen participation and civic engagement we can reduce garbage deposits which in turn will help to achieve a clean and healthy environment.
## Video

[![Watch the video](https://github.com/infyboys2020/CleanCityApp/blob/main/CleanCity_thumbnail.jpeg)](https://www.youtube.com/watch?v=tEvMhoRC7dY)

## The architecture

![Clean City architecture diagram](/arch_diagram_final.png)

1. User opens his mobile/computer and logs into the CleanCity application.
2. User enters the complain details, uploads the image to report the incident.
3. The Here  Map API loads the map, which helps the user select his particular address on the map.
4. After successful registration of complaint, the complaint details are stored in the IBM DB2 server and a confirmation email is sent to the user with a ticket number. The user can come back later and use this ticket number to know the status of the comlaint.
5. Admin logs into the system with valid credentials.
6. Admin filters the complaints on the basis of pin code, logged date etc. After assigning the work to appropriate team, he marks the ticket as 'Acknowledged'. After completion of the work, he marks ticket as 'Completed'.
7. The portal shows all the complaints from the DB to the admin as per the filter criteria.
8. The Map API shows the particular place of the incident on the map, which makes it easier to find the place.

## Long description

* [More detail is available here](/DESCRIPTION.md)

## Test the application on cloud

* **[Link to log a complaint](http://cleancitynewapplication-env-1.eba-83vtwsaz.us-east-2.elasticbeanstalk.com/user/ticketBoard)**
* **[Link to login as admin and acknowledge tickets](http://cleancitynewapplication-env-1.eba-83vtwsaz.us-east-2.elasticbeanstalk.com/admin/fetch)**
### Authenitication credentials to test
```
username: test
password: test
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

Your code is up and running at localhost:8080/home

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

* **Mayuri Ghosh** - mayuri021996@gmail.com
* **Bhruguraj Sahoo** - bhrugurajsahoo@gmail.com
* **Rajan Kumar** - rajanbabaguru@rediffmail.com
* **Rajesh Nayak** - rajeshkumarnayak1994@gmail.com
* **Ansuman Nayak** - ansumannayak1994@gmail.com

