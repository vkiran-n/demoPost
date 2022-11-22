#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Scenarios for GMO online

  Scenario: GMO home page
    Given I am on gmo home page
    When I enter gmo online
    Then I should see catalag page

Scenario: Catalog page - item selection
Given Catalog page is displayed
When I select 2 qty of Glacier Sun Glasses and place order
Then Place order page is displayed with items selected


Scenario: Place order
Given Place order page is displayed
When I checkout
Then billing information page should be displayed

Scenario: Billing page
Given Billing page is displayed
When I input correct billing address
Then the system should take me to receipt page

Scenario: Online receipt page
Given I am on receipt page
When I return to home page
Then Home page should be displayed



