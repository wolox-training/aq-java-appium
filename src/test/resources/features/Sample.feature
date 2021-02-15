Feature: Tabbar verification

  Scenario Outline: Open "<menu>" Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    Then The "<menu>" opens

    Examples:
      | menu    |
      | WebView |
      | Login   |
      | Forms   |
      | Swipe   |
      | Home    |