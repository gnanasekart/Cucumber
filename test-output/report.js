$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri(".\\src\\main\\java\\Features\\LoginHooks.feature");
formatter.feature({
  "name": "Login into CRM site ith hooks",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login with valid credential details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@First"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Click the Create Lead link",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginHooksSD.createLead()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the user details to create lead",
  "rows": [
    {
      "cells": [
        "company_name",
        "first_name",
        "last_name",
        "email"
      ]
    },
    {
      "cells": [
        "amazon",
        "manoj",
        "kumar",
        "manoj@gmail.com"
      ]
    },
    {
      "cells": [
        "paypal",
        "dinesh",
        "raja",
        "dinesh@mail.com"
      ]
    },
    {
      "cells": [
        "cts",
        "vikesh",
        "raj",
        "vk@gmail.com"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginHooksSD.enterLead(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logout the page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginHooksSD.logout()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Login to find the lead",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Second"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Click Createlead button",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginHooksSD.clickCreateLead()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click findlead button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginHooksSD.Findleads()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logout from that page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginHooksSD.logoutpage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});