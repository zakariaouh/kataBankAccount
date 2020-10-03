# Bank account kata

- Developed using TDD   
- You can start by executing tests or BanKataApplication.java

Think of your personal bank account experience When in doubt, go for the simplest solution 
 
#### Requirements 
   
- Deposit and Withdrawal   
- Account statement (date, amount, balance)   
- Statement printing   
    
#### User Stories   

##### US 1:   
In order to save money   
As a bank client   
I want to make a deposit in my account   
   
##### US 2:   
In order to retrieve some or all of my savings   
As a bank client   
I want to make a withdrawal from my account   
   
##### US 3:   
In order to check my operations   
As a bank client   
I want to see the history (operation, date, amount, balance)  of my operations  

#### Please note
- Prohibiting withdrawal with a negative amount is a management rule not present in Kata, so I did not implement it.
- I created my own `Clock` to have full control of the time, that's why I chose to use a String date, I can maybe change it to my one `Date`, but for now String do the Job.

#### Not released yet
- Rename the `Account` class to  `AccountManager`  then the account manager creates accounts on demand.
