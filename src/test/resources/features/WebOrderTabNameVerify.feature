@ui
Feature:Weborder tab name verify

Scenario: User should see side bar tabs as expected
Given we are at web order login page
When we provide valid credentials
Then we should see all order page
Then side bar tabs should be as below
| View all orders   |
| View all products |
| Order             |


  Scenario: User should see product table as expected
    Given we are at web order login page
    And we provide valid credentials
    When we select "View all products" tab from sidebar
    Then we should see table with below content
    # for the sake of simplicity below table is modified to match exactly to actual table
      | Product name    | Price | Discount |
      | MyMoney         | $100  | 8%       |
      | FamilyAlbum     | $80   | 15%      |
      | ScreenSaver     | $20   | 10%      |