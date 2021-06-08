# Clean City

## Contents

1. [Short description](#short-description)
1. [Video](#video)
1. [The architecture](#the-architecture)
1. [Getting started](#getting-started)
1. [Contributing](#contributing)
1. [Acknowledgments](#acknowledgments)

## Short description

<<Write short desc>>

### Demo Page 

Url: http://localhost:9080/fetch/demo?pin=12345

Check demo page to render image from database.


### Fetch All Report By Pin

http://localhost:9080/fetch

### Reporting Page
http://localhost:9080/reportBoard


### Database

Need a table for userdetails.

```
CREATE TABLE `user_details` (
  `userid` varchar(150)   NOT NULL ,
  `password` varchar(150) NOT NULL,
  `name` varchar(150)   DEFAULT NULL,
  `city` varchar(150)	   DEFAULT NULL,
  `email` varchar(150)	DEFAULT NULL,
  `phone` varchar(150)	DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ;

+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| userid   | varchar(150) | NO   | PRI | NULL    |       |
| password | varchar(150) | NO   |     | NULL    |       |
| name     | varchar(150) | YES  |     | NULL    |       |
| city     | varchar(150) | YES  |     | NULL    |       |
| email    | varchar(150) | YES  |     | NULL    |       |
| phone    | varchar(150) | YES  |     | NULL    |       |
+----------+--------------+------+-----+---------+-------+


INSERT INTO user_details VALUES("admin","admin","admin",NULL,NULL,NULL);

```

```
CREATE TABLE `cleancity_records` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'P',
  `name` varchar(150) NOT NULL,
  `address` varchar(150) NOT NULL,
  `pin` varchar(150) NOT NULL,
  `phone_number` varchar(150) NOT NULL,
  `photo` longblob,
  `longitude` varchar(45) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
   ComplaintSubmissionDate DATE NOT NULL,
  PRIMARY KEY (`id`)
) ;

```
```
+-------------------------+------------------+------+-----+---------+----------------+
| Field                   | Type             | Null | Key | Default | Extra          |
+-------------------------+------------------+------+-----+---------+----------------+
| id                      | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| type                    | varchar(45)      | YES  |     | NULL    |                |
| status                  | varchar(45)      | YES  |     | P       |                |
| name                    | varchar(150)     | NO   |     | NULL    |                |
| address                 | varchar(150)     | NO   |     | NULL    |                |
| pin                     | varchar(150)     | NO   |     | NULL    |                |
| phone_number            | varchar(150)     | NO   |     | NULL    |                |
| photo                   | longblob         | YES  |     | NULL    |                |
| longitude               | varchar(45)      | YES  |     | NULL    |                |
| latitude                | varchar(45)      | YES  |     | NULL    |                |
| ComplaintSubmissionDate | date             | NO   |     | NULL    |                |
+-------------------------+------------------+------+-----+---------+----------------+

```
### Authentication
```
user: admin
password: admin

```
```
# Please check CleanCitConfig class for Authentication configurations.
.authorizeRequests()
	        .antMatchers("/user/**").permitAll()  //Put all url patterns here which does not require authentication.
	        .antMatchers("/admin/**").hasRole("ADMIN")  // Url patterns for Authentication.
	        .anyRequest().authenticated().and().formLogin().
	        defaultSuccessUrl("/admin/reportBoard", true)
	        .permitAll()
	        .and().logout()
	        .permitAll();
          
          ```
