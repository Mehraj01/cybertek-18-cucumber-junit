Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search


  Background: User should be on google search page
    Given User is on the google search page

  Scenario: Google default title verification
    Then User should see title is Google


  Scenario: Google title verification after search
    When User searches "peach"
    Then User should see "peach" in the title

      # MAc: Option + Enter --> Allows you generate step definitions
      # Windows: Alt +Enter --> Allows you to generate step definitions

  @wip #work in progress
  Scenario: Google -About- link search page title verification
    Then User should see About link
    And User clicks to About link
    Then User should see title Google - About Google, Our Culture & Company News

    @googleTable
  Scenario: Google search page footer links verification
    Then User should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |

    #Make lines nice and straight
    #dommand option L - Mac
    # control alt L - windows




