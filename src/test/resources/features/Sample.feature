Feature: Tabbar verification

  Scenario Outline: Open WebView Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    Then The "<menu>" opens

    Examples:
      | menu    |
      | WebView |

  Scenario Outline: Open Login Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    Then The "<menu>" opens

    Examples:
      | menu  |
      | Login |

  Scenario Outline: Open Forms Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    Then The "<menu>" opens

    Examples:
      | menu  |
      | Forms |

  Scenario Outline: Open Swipe Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    Then The "<menu>" opens

    Examples:
      | menu  |
      | Swipe |

  Scenario Outline: Open WebView Menu
    Given I am in the WebDriverIo app
    When  I click on the "<menu>" menu
    Then The "<menu>" opens

    Examples:
      | menu |
      | Home |