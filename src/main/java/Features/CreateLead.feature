Feature: CreateLead Account
	Creating an lead account in testleaf site

@Smoketestcase	
Scenario: First Login and then create lead
Given Launch the leaf page
And Login the leaf page
	| username | password |
	| demosalesmanager | crmsfa |

When Verify successfully login page
Then click click crmsfa button
And Verify crm main page
Then Click Create Lead link
And Enter user details to create lead
	| company_name | first_name | last_name | email |
	| amazon | manoj | kumar | manoj@gmail.com |
	| paypal | dinesh | raja | dinesh@mail.com |
	| cts | vikesh | raj | vk@gmail.com |
 
And close the browser