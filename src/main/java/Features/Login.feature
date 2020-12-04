Feature: Login into CRM site
This feature to verify the login feature

#BAckground keyword used to reduce multi time code repetration inside scenatios
Background: 
Given Login with valid credential details
Given navigate to login page
When enter username and password 
| demosalesmanager | crmsfa   |
| demosalesmanager | crmsfa1   |

And click login button


#login using data driven without example
Scenario: Login with valid credential details
#Given navigate to login page
#When enter username "demosalesmanager" and password "crmsfa"
#And click login button
Then page should login successfully
And verify crmsfa enter button
And verify logout button

#---------------------------------------------------------------

#login using data driven - data table with example and scenario outline
#Scenario Outline: Login with valid credential details
#Given navigate to login page
#When enter username "<username>" and password "<password>"
#And click login button
#Then page should login successfully
#And verify crmsfa enter button
#And verify logout button
#
#Examples:
#	| username         | password |
#	| demosalesmanager | crmsfa   |

#------------------------------------------------------------------------

#login using data driven - data table without example and scenario outline
Scenario: Login with valid credential details
#Given navigate to login page
#When enter username and password 
#| demosalesmanager | crmsfa   |
#| demosalesmanager | crmsfa1   |
#
#And click login button
Then page should login successfully
And verify crmsfa enter button
Then verify logout button
And Close te browser
Then Click on create lead
And Enter user details 
| manoj | kumar | amazon |
 

