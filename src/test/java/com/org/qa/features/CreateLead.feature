Feature: Login into CRM site with hooks

Scenario: Login with valid credential details
Given Click the Create Lead link
When Enter the user details to create lead 
	| company_name | first_name | last_name | email | phone |
	| amazon | manoj | kumar | manoj@gmail.com | 222333 |
	| paypal | dinesh | raja | dinesh@mail.com | 444555 |
	| cts | vikesh | raj | vk@gmail.com | 666777 |
	

Then logout the page
