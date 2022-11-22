Feature:Login
  Scenario: login aja
    Given i open the browser
    And i fill email "standard_user" and correct password "secret_sauce"
    And i click login
    Then i should be login
