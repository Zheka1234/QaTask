Feature: Onliner Auto And Flat

  @success
  Scenario: check points of onliner auto
    Given openPage onliner
    When On the open page, the user will move the mouse to the AutoFlea Market menu
    Then The user saw prices, cities, brands


  @success
  Scenario: check points of onliner Houses and Apartments
    Given openPage onliner Start
    When On the open page, the user will move the mouse pointer over the house and apartment menu
    Then The user saw prices, cities