Feature: select highest fare

  Scenario Outline: Highest fare
    Given open "<bn>" browser
    And launch "https://www.spicejet.com" site
    When search flights from "<From>" to "<To>"
    And select <Departure year> , "<Departure month>" , <Departure day>
    And select <Return year> , "<Return month>" and <Return day>
    And click on search flights
    Then flights table should be displayed
    And select highest fare flight for Departure
    And select highest fare flight for Return
    And click continue
    When close site

    Examples: 
      | bn      | From      | To        | Departure year | Departure month | Departure day | Return year | Return month | Return day |
      | Chrome  | Bengaluru | Delhi     |           2022 | May             |            12 |        2022 | July         |         12 |
      | Firefox | Delhi     | Bangaluru |           2023 | January         |             2 |        2023 | February     |         24 |
