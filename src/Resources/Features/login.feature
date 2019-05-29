@Login

Feature: LoginPage
  Scenario Outline: user should not be able to login with invalid credential
    Given user is on Login page
    When user enters invalid "<Email>" or "<password>"
    Then user should able to see the "<error message>"

    Examples:
      |Email                 |password    |error message|
      |prisha1234@gmail.com  |prisha1234  |Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect|
      |prisha123@gmail.com   |prisha123  |Login was unsuccessful. Please correct the errors and try again.No customer account found             |
      |prisha1234@gmail.com  |            |Login was unsuccessful. Please correct the errors and try again.No customer account found|
      |                      |prisha1234  |Login was unsuccessful. Please correct the errors and try again.No customer account found|
      |prisha1234@gmail.com  |prisha123   |Login was unsuccessful. Please correct the errors and try again.No customer account found|
      |                      |prisha123   |Login was unsuccessful. Please correct the errors and try again.No customer account found|

