Feature: Forms verification

  Scenario Outline: Validate form elements
    Given I am in the WebDriverIo app
    And  I click on the "<menu>" menu
    When I write something in the input field
    And I press the form switch
    And I select option "<optionDD>" from the dropDown
    Then The text entered is displayed in the result field
    And Switch state changes
    And The inactive button is disabled

    Examples:
      | menu  | optionDD            |
      | Forms | This app is awesome |


  Scenario Outline: Validate form alert
    Given I am in the WebDriverIo app
    And  I click on the "<menu>" menu
    When I click the Active button
    Then The system displays an alarm with the corresponding buttons

    Examples:
      | menu  |
      | Forms |