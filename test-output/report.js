$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:\\eclipse\\workspace\\Cucumber\\src\\main\\java\\Features\\Login.feature");
formatter.feature({
  "name": "Login into CRM site",
  "description": "This feature to verify the login feature",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with valid credential details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "navigate to login page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSD.homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter login credential details",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSD.login_credential()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSD.submit_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "page should login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSD.successfullLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify crmsfa enter button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSD.verifyButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify logout button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSD.verifyLogoutButton()"
});
formatter.result({
  "status": "passed"
});
});