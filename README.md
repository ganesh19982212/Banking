# Banking System (Java Web Application)


A  web-based Banking System for Staff and Customer using **Java Servlets, Java Server Pages (JSPs)**.

## Technologies Used

* **Frontend:** HTML, CSS, JavaScript, , Java Server Pages (JSPs).
* **Backend:** Java Servlets, Java Models, MySql (Database). 
* **Web Server:** Apache Tomcat.

## Roles

Following roles are implemented:
* Banking Staff
* Customer

## Workflow (Functionalities)


This project  is for Customer can view his Banking Profile and transfer Amount and Staff can Add , Delete Customer and Transfer Amount.
Following are the steps of work flow:

### Banking User

1.  The User must login using Credentials to access the Account.
2.  After login the session will be created and User can view his Profile and able to Transfer amount to other Account if User has enough balance.
3.  In Profile page User can view his Name , Account Number , Email , Mobile Number and Amount.
4.  In Transfer  page User needs to enter Receiver Account and Amount. If the entered Account and entered amount is valid then amount will credit to Receiver Account and amount will be debited from User Account.
5.  If User is Inactive for more than10 minutes the session will be terminated and User must login again to access Account.


### Banking Staff

1.  The Staff must login using Credentials to access the Account.
2.  After login the session will be created and Staff is able to Add , Delete Users Account .
3.  Staff is also able to Update Users Account Details based on requirements and able to view User Data.
4.  Like User if Staff is Inactive for more than10 minutes the session will be terminated and Staff must login again to access Account.

## Interface

### Banking Staff

#### Login

![Login](https://user-images.githubusercontent.com/92635926/146214278-0c9b3d6d-ff11-4146-9e3b-e027e95ec9a8.png)

#### Main Menu

![Admin Portal](https://user-images.githubusercontent.com/92635926/146214824-c57c9cf1-fa9a-4c82-8d0d-33f1a7a54235.png)

#### Add User

![Add User](https://user-images.githubusercontent.com/92635926/146215080-b793de9f-020a-42bb-b350-33418114f6db.png)

#### Update User Details

![Update](https://user-images.githubusercontent.com/92635926/146215217-a4052615-23e9-4bfe-9912-ae7c404602f0.png)

#### Profile View

![Profile page](https://user-images.githubusercontent.com/92635926/146215288-48aaaed2-dfed-46f5-aebf-174832aa31ea.png)

#### Delete User Account

![View Before Delete](https://user-images.githubusercontent.com/92635926/146215375-9fafb420-4680-4e76-89df-e51ff605b154.png)

![Before Delete](https://user-images.githubusercontent.com/92635926/146215447-6a8bc094-cf92-417e-897d-7f2956b48fa4.png)

#### Logout

![Logout](https://user-images.githubusercontent.com/92635926/146215519-4b38ebb5-9a3f-492b-a3ac-5fa4588ecf28.png)

### Banking User

#### Login

![Login Page](https://user-images.githubusercontent.com/92635926/146215789-32090afe-504f-47bf-ab7f-d15d5699ccc2.png)

![Invalid Login](https://user-images.githubusercontent.com/92635926/146215877-cb092072-0f98-42ed-874f-48f950a1131e.png)

#### Main Menu

![Main Menu](https://user-images.githubusercontent.com/92635926/146215939-70a2ca52-d0af-42e9-85ad-4f0257af446e.png)

#### Profile

![Profile](https://user-images.githubusercontent.com/92635926/146216019-872ec345-927f-4194-b97d-207534062596.png)

#### Transfer

![Transfer](https://user-images.githubusercontent.com/92635926/146216067-b37a1305-451e-4705-8dff-a9ec0b1f66ea.png)

![Transferred](https://user-images.githubusercontent.com/92635926/146216122-79d01fc9-4156-487f-a236-a06e3fa0c8c1.png)

#### Logout

![Logout](https://user-images.githubusercontent.com/92635926/146216196-08d05143-dde9-45d0-b067-4fa58249a996.png)

![Logout Page](https://user-images.githubusercontent.com/92635926/146216264-ca2da95f-fe90-4f13-9fea-f6e60ee1fa5b.png)
