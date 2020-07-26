Feature: Sign in

  Scenario: Success Login
    Given Browser is started
    And mail.ru page is loaded
    When I  type "a.shafalovich91@mail.ru" to login input
    And I click button for submit
    And I type "nastusha1213" to password input
    And I click button for submit
    Then I see my emailId
    Then I close Browser

  Scenario: Incorrect Login Test
    Given Browser is started
    And mail.ru page is loaded
    When I  type "rthjgrtgrh@mail.ru" to login input
    And I click button for submit
    Then I see incorrectLoginMessage
    Then  I close Browser

  Scenario:  Incorrect Password Test
    Given Browser is started
    And mail.ru page is loaded
    When I  type "a.shafalovich91@mail.ru" to login input
    And I click button for submit
    And I type "behbfhgbrhb" to password input
    And I click button for submit
    Then I see incorrectPasswordMessage









