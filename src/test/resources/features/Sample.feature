Feature: Hello World
  Scenario: Open WebView Menu
    Given I am in the WebDriverIo app
    When  I click on the "WebView" menu
    Then The web view opens

  Scenario: Open Login Menu
    Given I am in the WebDriverIo app
    When  I click on the "Login" menu
    Then The login opens

  Scenario: Open Forms Menu
    Given I am in the WebDriverIo app
    When  I click on the "Forms" menu
    Then The forms opens

  Scenario: Open Swipe Menu
    Given I am in the WebDriverIo app
    When  I click on the "Swipe" menu
    Then The swipe opens

  Scenario: Open WebView Menu
    Given I am in the WebDriverIo app
    When  I click on the "Home" menu
    Then The Home opens