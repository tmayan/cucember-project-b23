@ui
Feature: Web order app login
  As a user
  I should be able to login to web order app

  #This is where repeating beginning code can go, this is how we comment in feature file

  Background:
  Given we are at web order login page

  Scenario: User login successfully
    When we provide valid credentials
    Then we should see all order page


  Scenario: User login fail
   When we provide invalid credentials
   Then we should still be at login page
   And login error message should be present

  Scenario: User login error message should be present
    When user provide username "Tester" and password "test"
    Then we should see all order page

  Scenario: User login with wrong credentials

    When user provide username "BLA" and password "BLA"
    Then we should still be at login page
    And login error message should be present


