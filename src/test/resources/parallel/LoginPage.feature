Feature: login page Test

Scenario: get login page title
Given user is on login page
When user gets title
Then title should be "Botprise Staging"


Scenario: check forgot password link is available
Given user is on login page
When user check forgot password link is displayed


Scenario: User Login with correct credentials
Given user is on login page
When user enters username "admin@botprise.com"
And user enters pwd "BotpriseTeam2021$$"
And user clicks on login button
