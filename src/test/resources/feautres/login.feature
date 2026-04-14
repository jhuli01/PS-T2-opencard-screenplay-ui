
Feature: User Login

  Scenario: Failed login with wrong password
    Given the user navigates to the login page
    When the user enters email "202335135@cibertec.pe" and password "wrongpass"
    And clicks on the login button
    Then the user should see the message "Warning: No match for E-Mail Address and/or Password."

  Scenario: Successful login with valid credentials
    Given the user navigates to the login page
    When the user enters email "202335135@cibertec.pe" and password "Test@12345"
    And clicks on the login button
    Then the user should see the name "Jhuli" in the page header
