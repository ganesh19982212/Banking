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
<p align="middle">
   <img src="../master/Images/Login.png" width="400"/>
</p>

#### Main Menu
<p align="middle">
   <img src="/Banking_Admin/Images/Admin Portal.png" width="400"/>
</p>

#### Add User
<p align="middle">
   <img src="../Banking_Admin/Images/Add User.png" width="400"/>
</p>

#### Update User Details
<p align="middle">
   <img src="../Banking_Admin/Images/Update.png" width="400"/>
</p>

#### Profile View
<p align="middle">
   <img src="../Banking_Admin/Images/Profile page.png" width="400"/>
</p>

#### Delete User Account
<p align="middle">
   <img src="../Banking_Admin/Images/View Before Delete.png" width="400"/>
   <img src="../Banking_Admin/Images/Before Delete.png" width="400"/>
</p>

#### Logout
<p align="middle">
   <img src="../Banking_Admin/Images/Logout.png" width="400"/>
</p>

### Banking User

#### Login
<p align="middle">
   <img src="../Banking_User/Images/Login Page.png" width="400"/>
   <img src="../Banking_User/Images/Invalid Login.png" width="400"/>
</p>

#### Main Menu
<p align="middle">
   <img src="../Banking_User/Images/Main Menu.png" width="400"/>
</p>

#### Profile
<p align="middle">
   <img src="../Banking_User/Images/Profile.png" width="400"/>
</p>

#### Transfer
<p align="middle">
   <img src="../Banking_User/Images/Transfer.png" width="400"/>
   <img src="../Banking_User/Images/Transferred.png" width="400"/>
</p>

#### Logout
<p align="middle">
   <img src="../Banking_User/Images/Logout.png" width="400"/>
   <img src="../Banking_User/Images/Logout Page.png" width="400"/>
</p>
