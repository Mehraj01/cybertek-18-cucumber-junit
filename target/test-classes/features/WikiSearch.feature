@wiki
Feature: Wiki title and search verifications

  Background: User is on the Wiki home page
    Given User is on the Wikipedia home page


  Scenario: Search functionality title verification
    When User types "Steve Jobs" in the wiki search page
    Then User should see "Steve Jobs" in the wiki title

  @wiki
  Scenario: Search functionality header verification
    When User types "Steve Jobs" in the wiki search page
    Then User should see "Steve Jobs" in the main header


  #Scenario: Search functionality header verification
    #When User types "Steve Jobs" in the wiki 1 search page
    #Then User should see "Steve Jobs" in the main header

  @wikiScenarioOutline
  Scenario Outline: Search functionality header verification
    When User types "<searchValue>" in the wiki search page
    Then User should see "<expectedTitle>" in the wiki title
    Then User should see "<expectedMainHeader>" in the main header
    Then User should see "<expectedImageHeader>" in the image header

    Examples: example test data for wikipedia steps
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | John Travolta   | John Travolta   | John Travolta      | John Travolta       |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |


