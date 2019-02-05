Feature: Trello Login

Scenario Outline:Trello Login
Given I am on Tello Login Page
When I entered my "<user>" and "<password>"
And I clicked on Login button
Then I got navigated to Trello Home Page


Examples:
|user              |password |
|azharw49@gmail.com|Chelsea@1| 