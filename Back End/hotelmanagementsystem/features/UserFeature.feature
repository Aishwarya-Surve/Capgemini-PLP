Feature: Testing the user signin feature

Scenario: Testing the sign in feature with valid data
Given the user has loaded the application in the browser
When the user clicks on sign in link
When the user enters the valid email
And the user enters the valid password
And the user clicks on the sign in button
Then the booking page must be displayed
#When the user clicks on location
#And the user selects location
#And the user selects checkin date
#And the user selects checkout date
#And the user clicks on search button
When the user clicks on view bookings
When the user clicks on profile
And the user clicks on see profile