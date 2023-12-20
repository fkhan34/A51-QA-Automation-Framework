Feature: Login Feature
  Scenario: Login with valid credentials
    Given I open browser
    And I open Login Page
    When I enter email "faizan.khan@testpro.io"
    And I enter password "master21"
    And I submit
    Then I should get logged in