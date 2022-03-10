Feature: Validation of Adactin web Application
Scenario: TC01_Validation of Order Id with valid Details
Given User launch Adactin web Application
Then User verify Adactin Home page Hotel is displayed
When User enters valid username and valid password
And User clicks Login Button 
Then User verify Search Hotel page is displayed
When User select valid Location,Hotels Name,Room Type,no of Rooms,check in date,check out date,Adults per Room,Children per Room
And User clicks search Button
Then User verify Select Hotel page is displayed
When User select the select hotel options 
And User click search Button
Then User verify Book A hotel page is displayed
When User enters valid First Name,Last Name,Billing Address,Credit card number,Card Type and select Month,Year,Cvv number
And User clicks BookNow Button
Then User verify Booking Verification page is displayed
Then User verify the Order Id is displayed