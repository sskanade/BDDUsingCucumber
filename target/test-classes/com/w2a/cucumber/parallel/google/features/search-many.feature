Feature: Searching on Google

Scenario: Direct search on Google Firefox
Given launch browser 'firefox'
When user navigates to 'http://google.com'
Then user enter search term 'Way2Automation Selenium'
And click on search button

Scenario: Direct search on Google Chrome
Given launch browser 'chrome'
When user navigates to 'http://google.com'
Then user enter search term 'Way2Automation Java'
And click on search button
