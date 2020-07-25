@loginWithBackground
Feature: Login feature

  CBT-25: As a user, I should be able to login with correct credentials
  to different accounts, and dashboard should be displayed.
  #this is how you comment in feature file

  # we user Background we have repeated actions. You just add 1 line with Background
  #Before Annotation runs here
  Background: BackStory is that user is on the login page
    Given User is on the login page
    #Then User sees title is library

  Scenario: Librarian login scenario
    When User logs in as librarian
    Then User should see dashboard
    #After Annotation runs here

  Scenario: Student login scenario
    When User logs in as student
    Then User should see dashboard
    #After Annotation runs here

   @db
  Scenario: Admin login scenario
     #BeforeStep runs here
    When User logs in as admin
     #AfterStep runs here
     #BeforeStep runs here
    Then User should see dashboard
      #AfterStep runs here
     #After Annotation runs here