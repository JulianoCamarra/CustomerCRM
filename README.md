<!--
*** Thanks for checking out this README Template. If you have a suggestion that would
*** make this better please fork the repo and create a pull request or simple open
*** an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
-->




<!-- PROJECT LOGO -->



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project
 <img src="https://i.ibb.co/d474zZr/customercrm-screenshot.png">
CustomerCRM is a CRUD application that allows users to manage their customers, products, as well as orders, over a simple Bootstrap GUI design. 

### Built With
* [Bootstrap](https://getbootstrap.com)
* [Java](https://www.java.com/en/download/)
* [MySql](https://www.mysql.com)
* [Spring Framework](https://start.spring.io/)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy of Weather Finder up and running follow these simple example steps.

1) Open your terminal

2) Go to the directory where you want your copy of this repository to be copied to

3) Type ```git clone https://github.com/JulianoCamarra/CustomerCRM.git``` and it will copy

### Prerequisites

* JDK 1.8 or higher
* Apache Tomcat Server 9 (if running locally)
* MySQL JDBC Driver



### Installation

#### Create a new database
1. Setup a new database schema with whatever name you choose

2. create these five tables in your
 ```customer```,
 ``` product```, 
 ```customer_order```,
 ```users```, 
 and ```authorities```
 
3. create a view named ```totalpricepercustomer```
 
 NOTE: use ```users``` credentials to log into application
 
 NOTE: entries into ```authorities``` must begin with "ROLE_{your_role}"
 
 #### Setup database configuration properties
 
 3. Go to the ```application.properties``` file, located under ```src/main/resources```
 4. type in the username of your database connection in ```spring.datasource.username={your_database_connection_username}```
 5. type in the password of your database connection in ```spring.datasource.password={your_database_connection_password}
 6. for ```spring.datasource.driverClassName```, you can specify the driver name of your database, or simply delete the configuration,
 as Spring Boot can determine the driver used for you.
 7.type in the url of your datasource in ```spring.datasource.url={your_database_connection_url}```. 
 
     Remember, the pattern of a datasource
 url is ```jdbc:{your_sql_dialect}://{host_name}:{port_number}/{your_database_name}```


<!-- USAGE EXAMPLES -->
## Usage

This application provides your basic CRUD features

1)Add a customer, product, or order

2)Retrieve a customer, product, or order

3)Update a customer, product, or order

4)Delete a customer, product, or order


It is also currently possible to retrieve every order made by a customer


<!-- CONTRIBUTING -->
## Contributing

Any contributions made to this project would be **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch
3. Commit your Changes
4. Push to the Branch
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [Othneildrew -for the readme template](https://github.com/othneildrew/Best-README-Template)
* [Stackoverflow- for answering any of my questions](https://stackoverflow.com/) 


<!-- MARKDOWN LINKS & IMAGES -->
[build-shield]: https://img.shields.io/badge/build-passing-brightgreen.svg?style=flat-square
[contributors-shield]: https://img.shields.io/badge/contributors-1-orange.svg?style=flat-square
[license-shield]: https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square
[license-url]: https://choosealicense.com/licenses/mit
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: https://raw.githubusercontent.com/othneildrew/Best-README-Template/master/screenshot.png
