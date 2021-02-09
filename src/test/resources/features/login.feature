Feature: Login verification

  Scenario Outline: validate login
    Given I am in the WebDriverIo app
    And  I click on the "<menu>" menu
    When I write the "<email>" and "<password>"
    And I click the login button
    Then the system displays the "<msg>" message


    Examples:
      | menu  | email    | password | msg   |
      | Login |          |          | error |
      | Login | invalido | 1234567  | error |
      | Login | ana@gmail.com | 12345678 | success |
