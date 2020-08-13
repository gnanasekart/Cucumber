Feature: Login into CRM site ith hooks

Scenario: Login with valid credential details
Given Click the Create Lead link
When Enter the user details to create lead 
	| company_name | first_name | last_name | email |
	| amazon | manoj | kumar | manoj@gmail.com |
	| paypal | dinesh | raja | dinesh@mail.com |
	| cts | vikesh | raj | vk@gmail.com |
	

Then logout the page
