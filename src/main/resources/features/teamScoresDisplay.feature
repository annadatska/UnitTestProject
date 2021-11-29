Feature: Team scores display
  As a user of the website
  I want to be able to search results of the football championships
  So that I can find out the scores of my favorite teams

  Scenario Outline: Team scores display
    Given User opens "https://www.bbc.com/" page
    And User clicks Sport menu button
    And User clicks Football menu button
    And User clicks Scores and fixtures button
    When User makes search for the championship by a keyword '<championship>'
    And User filters the Score Results by month '<month>'
    Then User checks the name of first team '<firstTeam>'
    And User checks the name of second team '<secondTeam>'
    And User checks the score of first team '<firstScore>'
    And User checks the score of second team '<secondScore>'
    When User clicks on first team name
    Then User checks the name of first team '<firstTeam>' on the next page
    And User checks the name of second team '<secondTeam>'
    And User checks the score of first team '<firstScore>'
    And User checks the score of second team '<secondScore>'
    Examples:
      | championship          | month | firstTeam   | secondTeam | firstScore | secondScore |
      | Scottish Championship | AUG   | Dunfermline | Arbroath   | 0          | 3           |
