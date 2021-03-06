# toolBox

Java utilities project. Basic core functionalities.

## Getting Started

Almost all classes are within a Java feature or section and has it's own main class. These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

Up to now is only tested with intelliJ 18 Community.

For database section you need docker and docker-compose installed. If you haven't installed yet I recommend:

[Digital Ocean Community Docker Installation Tutorial](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-16-04#step-1-%E2%80%94-installing-docker)

[Digital Ocean Community DockerCompose Installation Tutorial](https://www.digitalocean.com/community/tutorials/how-to-install-docker-compose-on-ubuntu-16-04)

### DataBase Section

In order to avoid the database instalation a docker with a PostgreSQL and PgAdmin has been attached.

Up postgreSQL:

```bash
$ cd /pathToolBoxProject
$ docker-compose up postgresql
```
Up pgAdmin:
```bash
$ cd /pathToolBoxProject
$ docker-compose up pgAdmin
```
Access postgreSQL via plsql:
```
$ docker exe -it toolbox_postgresql_1 -U postgres
postgres=# \dt
```
Access postgreSQL via [pgAdmin4](http://localhost:5050/browser/):

<img src="posgresqlDns.png" width="357" height="267">

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Oracle Java](https://www.java.com/es/) - Programming language used
* [Gradle](https://gradle.org/) - Build Tool
* [PostgreSQL](https://www.postgresql.org/) -  Open source object-relational database

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

This version covers JDK.8 features.

## Authors

* **JonLv** -  [JonLvBlog](https://github.com/PurpleBooth)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [Java Programming Masterclass by Tim Buchalka](https://www.udemy.com/java-the-complete-java-developer-course/)

