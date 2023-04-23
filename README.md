# Jem



## Introduction
JEM platform offer a solution for managing the Junior Entreprise's tasks, automate procedures within the association and calculate the performance indicators.

## Features

The functionality of the system will be divided by the type of access of each actor.

**Admin's** main features are :
- Authenticate: In order to access the application's features, the admin must authenticate himself by entering his email and password.
- Create an account: the admin must confirm the users's account creation and specify their status .
- the admin has the same features as any managers .

**Project manager's** main features are :
- Authenticate: In order to access the application's features the project manager must authenticate by entering their email and password.
- Display the KPIs : the project manager can display the process performance indicators.
- Assign Members : the project manager can assign members to each project.
- Display the different phases of a project: the project manager can display the different phases of a project.
- Display the list of projects: the project manager can display the list of projects.

**Human resources and training manager's** main features are :
- Authenticate: In order to access the application's features the human resources and training manager must authenticate by entering their email and password.
- Add/Delete a status to the association : the human resources and training manager can add/delete a status to the association.
- Display the KPIs : the human resources and training manager can display the process performance indicators.
- Display a list : the human resources and training manager can display the executive board, the alumnis, the recruited member and the senior members's list.
- Display a trainings list : the human resources and training manager can display the trainings's list.
- Display a trainers list : the human resources and training manager can display the trainers's list.

**Marketing manager's** main features are :
- Authenticate: In order to access the application's features the marketing manager must authenticate by entering their email and password.
- CRUD The list of Tunisian Junior Entreprises and their contacts: the marketing manager can create , update and delete the list of Tunisian Junior Entreprises and their contacts.
- CRUD the online marketing calender : the marketing manager can create , update and delete the online marketing calender.

**Vice President's** main features are :
- Authenticate: In order to access the application's features the vice president must authenticate by entering their email and password.
- Display a list: the vice president can display a liste of the contacted and prospected partners.
- Display the KPIs : the vice president can display the process performance indicators.

**Commercial developpment manager's** main features are :
- Authenticate: In order to access the application's features the commercial developpement manager must authenticate by entering their email and password.
- Display a list: the commercial developpement manager can display a list of prospects.
- Display the KPIs : the commercial developpement manager can display the process performance indicators.
- Add/Delete a prospect: the commercial developpement manager Add/Delete a prospect

**Secretary's** main features are :
- Authenticate: In order to access the application's features the secretary must authenticate by entering their email and password.
- Assign tasks: the secretary can assign tasks to the executive board .
- CRUD a meeting: the secretary can ADD/Delete/Update a meeting for the executive board
- Display the KPIs :the secretary can display the process performance indicators.

**Member's** main features are :
- Authenticate: In order to access the application's features the mamber must authenticate by entering their email and password.
- Access to the project: the member has the access to the project he is working for.
- ADD/Delete prospect: the member can ADD/Delete prospect.
- Access the calender : the member has the access to the calender.
- Access the merit point grid :the member has the access to the merit point grid.

## Professional supervisor
[Relead](https://relead.tn/) **X** [JEENISO](https://jeeniso.com/)

-Relead is an innovative communication channel that allows advertisers to reach their customers in a targeted and geolocated way through advertisements over Wi-Fi.

-The Junior Enterprise ENISo, JEENISo, is a non-profit student consulting office, with an educational, economic and social vocation founded in 2011 and located at the National School of Engineers of Sousse.

## Development Environment

Following libraries were used during the development of this starter kit :

Spring Boot : Server side framework
Postgres : SQL database managment system
Hibernate: Data Base framework
Swagger : API documentation
JWT : Authentication mechanism for REST APIs

## installation 
Create the postgres Database using 
``` 
sudo -u postgres psql
postgres=# CREATE DATABASE [Database Name];
``` 
and run the serve.

For more details about database connexion, you can check this [Article](https://chartio.com/resources/tutorials/how-to-set-the-default-user-password-in-postgresql/) .
Create a user manually from Database using Dbeaver or any other database administration system.

Its as important to document(as is the development) and make your APIs available in a readable manner for frontend teams or external consumers. The tool for API documentation used in this starter kit is Swagger 2

