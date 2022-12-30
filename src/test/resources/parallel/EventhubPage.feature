Feature: verification of BTU creation and check existance 

#Scenario: user login to servicenow and creates ticket
#Given user logs in servicenow
#When user creates two tickets


Scenario: User creates BTU 
Given Userlogin to stageapp
When user goes to eventhub page
Then user creates BTU