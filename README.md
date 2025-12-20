# Mini Banking App

## Plan

- So the plan is writing a console based Mini Banking App.
- To write it, I thought about the actually a bank App.
- In bank App, there are banch of operation will be, but in my app, it is the mini version of the app,
- where it is likely to be a miniversion of the app


## Actual how my app works?


- So in my app there will be the three classes, main clases such as: Account, User, Transaction and Bank
- Actually it will be 4 classes...

## User

- In the User section, user can only register or login and exit the account.
- What User class cannot do?
- That is the main question actually.
- When you register the account, you just enter your age, name, and phone number.
- You cannot add the balance of the card! The account will be registered by the phone number and password.
- You cannot make the transitions and change the balance

## Account

- So in the Account, there will be things such as transaction history, Owner of the account and the balance where you will give the permission to increase and decrease.
- Account cannot check the validation of the cards or phone numbers.


## Transaction

- Transaction will have only facts about the transaction.
- It is such as document or receipt for transaction things.
- It cannot transfer the money.

## Exception

- There will be exc>eption like a about the money in minus
- Card number wrong
- phone number wrong

## Bank

- In the bank, actually we have the access to the user and their accounts
- So in the bank, there will be only the data that is a User has an account or not

## BankService

- It is the new class that it wil make the all bank services.
- With services I mean, making the transfers of the money, validations and such things.

# Design

## User

- User will have the options such as `name`, `phone number`, `password`.
- It has functions such as returning the phone number, for when you login into account it will search by number
- It has methods such as password and name.
- For this class I use record with toString in toString it will show only the name and the phone number
- I will add the find methods that returns the object of the User

## Account

- In the account when you create or login, in the register, user will enter the phone number and password and the balance, constructor will be like this `Account(User user, balance)`
- The person who just login into their account, they will just provide the phone number and the password, if such a user will not show, it will be the two options, Try again or register.
- Will be methods such as making transfers, and the finding account for login page, Transactions happens with the help of class of Transfer

## Transaction

- It will be list such as transactions list to be used for lator when we do the transaction.
- Will be the primitive data such as transfer for used for payments, card for card numbers and phone for phone numbers transfer
- Will be validation for card number and for phone number
- In the payment method, We will borrow the information of balance from Account and make the payment.
- I will create the validation methods for transfer to use it in the transfer for phone number and transfer for the card number, it just shows the will be money enough or not
- And will be method for making plus for balance