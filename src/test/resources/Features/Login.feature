Feature: Login Feature
  Scenario: Login with valid credentials
    Given I open Login Page
    And I provide login succeed
    Then I should get logged in
