Feature: Card Tests

  @Test
  Scenario: Post Card Data
    Given I set card owner as Abc
    When I set card number as 4222222222222
    And I set card date as 01/28
    And I set card cvv code as 123
    Then I post card data