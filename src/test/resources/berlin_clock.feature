Feature: Convert digital time to Berlin Time

  As a digital time user
  I want to be able to see with the Berlin Clock representation

  Scenario Outline: Should not implement the Berlin Clock representation when invalid time passed
    Given the current time is "<HOUR>" "<MINUTE>" "<SECOND>"
    When the client converts it to Berlin representation
    Then the Berlin representation is "<RESULT>"
    Examples:
      | HOUR | MINUTE | SECOND | RESULT                                                        |
      |      |        |        | Unable to convert digital time to Berlin Clock representation |
      | -01  |        |        | Unable to convert digital time to Berlin Clock representation |
      | -01  | 00     |        | Unable to convert digital time to Berlin Clock representation |
      | 25   | 00     | 00     | Unable to convert digital time to Berlin Clock representation |
      | 00   | 62     | 00     | Unable to convert digital time to Berlin Clock representation |
      | 00   | 00     | 62     | Unable to convert digital time to Berlin Clock representation |

  Scenario Outline: Should implement the Berlin Clock representation when valid time passed
    Given the current time is "<HOUR>" "<MINUTE>" "<SECOND>"
    When the client converts it to Berlin representation
    Then the Berlin representation is "<RESULT>"
    Examples:
      | HOUR | MINUTE | SECOND | RESULT                   |
      | 00   | 00     | 00     | YXXXXXXXXXXXXXXXXXXXXXXX |
      | 23   | 59     | 59     | XRRRRRRRXYYRYYRYYRYYYYYY |