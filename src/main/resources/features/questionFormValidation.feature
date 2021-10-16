Feature: Validation question form
  As a user of the website
  I want to see error messages if input credentials are invalid
  So that I can know that my question was sent successfully

  Background:
    Given User opens "https://www.bbc.com/" page
    And User clicks News button
    And User clicks Coronavirus button
    And User clicks Your coronavirus stories
    And User opens Question form

  Scenario Outline: Check empty question error messages
    When User enters '<question>', '<name>' and '<email>'
    Then User checks an empty question field '<errorMessage>'
    Examples:
      | question | name | email | errorMessage |
      || Anna | asdfghj@afdgh.com | can\'t be blank |

  Scenario Outline: Check empty name error message
    When User enters '<question>', '<name>' and '<email>'
    Then User checks an empty name field '<errorMessage>'
    Examples:
      | question | name | email | errorMessage |
      | question || asdfghj@afdgh.com | Name can\'t be blank |

  Scenario Outline: Check empty email error message
    When User enters '<question>', '<name>' and '<email>'
    Then User checks en empty email field '<errorMessage>'
    Examples:
      | question | name | email | errorMessage |
      | question | Anna || Email address can\'t be blank |

