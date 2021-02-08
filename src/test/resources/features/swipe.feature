Feature: Swipe verification

  Scenario Outline: Open WebView Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    And The "<menu>" opens
    And I search on the carousel "<text>"
    Then carousel element is clickable

    Examples:
      | menu  | text              |
      | Swipe | CREAT COMMUNITY   |
      | Swipe | EXTENDABLE        |
