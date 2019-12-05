Feature: Searching on Google using scenario outline

Scenario Outline: Searching on Google with scenario outline
Given launch browser '<browserName>'
When user navigates to '<url>'
Then user enter search term '<search>'
And click on search button

Examples:
	|browserName	|url				|search						|
	|chrome			|http://google.com	|Way2Automation	java		|
	|firefox		|http://google.com	|Way2Automation Selenium	|
