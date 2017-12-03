# Hacking The Fire - Backend Application

## Membros - Time 9

>
Eduardo Costa Paiva - Frontend
>
Gabriel Augusto Marson - Mobile iOS Native
>
Mateus Henrique Alves da Cruz - Backend (git owner)
>
Thiago Fuzaro - Frontend

## Technologies Used

>
Backend - Spring and Mongo
>
Frontend - VueJS and Bootstrap
>
Mobile - Swift

## Quick Start For Backend Application

> 1.Install [MongoDB](https://www.mongodb.com/download-center), [Java](https://www.java.com/pt_BR/download/) and [Maven](https://maven.apache.org/download.cgi)
>
> 2.Clone this repository using ` git clone https://github.com/emiteze/xy-inc.git `
>
> 3.On the root of the project, run:
>
> ``` mkdir data && mkdir data/db (this create the project database path used by mongo to store data) ```
>
> ``` mongod --dbpath=data/db (this will initiate a mongodb server at localhost:27017) ```
>
> ``` mvn dependency:resolve (this will handle the dependencies of the project) ```
>
> ``` mvn clean install (this will build the project) ```
>
> ``` mvn spring-boot:run (this will start the webservice at localhost:8080) ```
>
> 4.Open in your browser the URL ` http://localhost:8080/swagger-ui.html ` to test the webservice or use any HttpClient that you want.
