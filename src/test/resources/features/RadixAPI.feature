Feature: Get root hashes of each file

  @wip
  Scenario: Get root hashes of each file
    Given User sends a download request to API
    Then The API should return a merkle hashes
    And The merkle hashes should be in json format
    And The API should return number of pieces of the files

