Feature: Search articles
  As a user of the website
  I want to be able to browse and search articles
  So that I can find out latest and relevant news

  Background:
    Given User opens "https://www.bbc.com/" page
    When User clicks News button

  Scenario Outline: Check the name of the headline article
    Then User checks the name of the headline article against the '<expectedName>'
    Examples:
      | expectedName |
      | Johnson visits scene where British MP killed |

  Scenario Outline: Check secondary article titles
    Then User checks article titles '<articleTitles>' to the right and below the headline article
    Examples:
      | articleTitles |
      | British MP killing was terrorist incident - police, Russia\'s daily Covid deaths hit 1,000 landmark |

  Scenario Outline: Search by headline article category link
    When User copies the text of the Category link of the headline article and enters it to search bar
    And User clicks the search button
    Then User checks the '<expectedName>' of the first article
    Examples:
      | expectedName |
      | BBC Essex update: BBC Essex update 12:30 BST |