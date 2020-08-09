Feature: Login into CRM site
This feature to verify the login feature

Scenario: Login with valid credential details
Given navigate to login page
When enter login credential details
And click login button
Then page should login successfully
And verify crmsfa enter button
And verify logout button

