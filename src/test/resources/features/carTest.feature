Feature: Car details can be checked free on the cartaxcheck.co.uk portal

  Scenario Outline: Extract the vehicle details from an input file and compare with a given output file
    Given the user reads from an input file "car_input.txt"
    And the user search the car details in the portal for a given "<inputRow>"
    Then the car details are displayed
    And car details should match with the "car_output.txt" for the specific "<outPutRow>"

    Examples:
      | inputRow | outPutRow |
      |    0 |   0 |
      |    1 |   1 |
      |    2 |   2 |
      |    3 |   3 |