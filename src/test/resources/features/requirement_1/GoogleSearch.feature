Feature: As an User I can
  Navigate to Google search page on any browser.Search for "Adaptavist"In the search result page, capture all the links containing "Adaptavist" and navigate to each of them and capture a screenshot of the landing page.

  Scenario: Looking up the Search results of 'Adaptavist'
    Given the user is on the Google home page
    When the user looks up the definition of the word 'Adaptavist'
    Then they should see the definition 'Adaptavist'
    When I capture all the links containing Adaptavist
    And I navigate to each of them

