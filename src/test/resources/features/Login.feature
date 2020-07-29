Feature: Sign in

  Scenario Outline: Success Login
    Given Browser is started
    And mail.ru page is loaded
    When I  type "<login>" to login input
    And I click button for submit
    And I type "<password>" to password input
    And I click button for submit password
    Then I see "<login>"

    Examples:
      | login                   | password     |
      | a.shafalovich91@mail.ru | nastusha1213 |

  Scenario: Incorrect Password Test
    Given Browser is started
    And mail.ru page is loaded
    When I  type "a.shafalovich91@mail.ru" to login input
    And I click button for submit
    And I type "behbfhgbrhb" to password input
    And I click button for submit
    Then I see incorrectPasswordMessage

  Scenario: Incorrect Login Test
    Given Browser is started
    And mail.ru page is loaded
    When I  type "rthjgrtgrh@mail.ru" to login input
    And I click button for submit
    Then I see incorrectLoginMessage

