Feature: Integration Modeller test

Scenario: Verification of Integration modeller.
Given login to stageapp
When go to integrations page
Then create integration through modeller with curl "curl -XPOST -H "Content-type: application/json" -d '{"description":"Test Description"}' 'https://$servicenow_instance/api/now/table/incident' -u $username:'$password'" username "admin" servicenow_instance "dev59080.service-now.com" password "eh8+IZ%zZiU8"