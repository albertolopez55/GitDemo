Feature: Search and place order  vegetables

@SeleniumTest
Scenario: Search for items and validate results
Given User is on Greencart Landing page
When User searched for "Cucumber" vegetable
Then "Cucumber" results are displayed


@SeleniumTest1
Scenario: Search for items and then move to checkout page
Given User is on Greencart Landing page
When User searched for "Brinjal" vegetable
And Added items to cart
And User proced to Checkout page for purchase
Then verify selected "Brinjal" items are displayed in checkout page
