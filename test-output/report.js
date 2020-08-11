$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:\\eclipse\\workspace\\Cucumber\\src\\main\\java\\Features\\CreateLead.feature");
formatter.feature({
  "name": "CreateLead Account",
  "description": "\tCreating an lead account in testleaf site",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "First Login and then create lead",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Launch the leaf page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateLeadSD.launch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login the leaf page",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "demosalesmanager",
        "crmsfa"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CreateLeadSD.login(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify successfully login page",
  "keyword": "When "
});
formatter.match({
  "location": "CreateLeadSD.successfullyLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click click crmsfa button",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateLeadSD.crmsfaButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify crm main page",
  "keyword": "And "
});
formatter.match({
  "location": "CreateLeadSD.crmMainPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Create Lead link",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateLeadSD.createLead()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter user details to create lead",
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
  "keyword": "And "
});
formatter.match({
  "location": "CreateLeadSD.enterLead(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "CreateLeadSD.tearDown()"
});
formatter.result({
  "status": "passed"
});
});