Feature: Testing the admin signin feature

Scenario: Testing the sign in feature with valid data
Given the admin has loaded the application in the browser
When the admin clicks on sign in link
When the admin enters the valid email
And the admin enters the valid password
And the admin clicks on the sign in button
Then the admin page must be displayed
#When the admin clicks on hotels counter
#When the admin clicks on delete button
#When the admin clicks on admin link
#When the admin clicks on manager counter
#When the admin clicks on register manager
#When the admin enters manager name
#And the admin enters email
#And the admin enters password
#And the admin clicks on register manager button
When the admin clicks on Add Hotel
And admin enters hotel name
And admin enters ac rooms
And admin enters non-ac room
And admin enters hotel location
And admin clicks on add hotel
When the admin clicks on admin
And admin clicks on hotels counter