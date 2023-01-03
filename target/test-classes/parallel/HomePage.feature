Feature: Home Page feature



Background:
Given user has already loggen to application
|username||password|
|admin@botprise.com||BotpriseTeam2021$$|


Scenario: Home page title
Given user is on home page
When user gets title
Then title should be "Botprise Staging"

Scenario: user checks Botprise lab name
Given user is on home page
Then user gets copany name
|companynamet||no company Name|
|Botprise Lab||BotpriseTeam2021$$e|
And company name should be "Botprise Lab"