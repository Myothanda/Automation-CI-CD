
@tag
Feature: Error validation
  I want to use this template for my feature file
  
  Background:
 
  @tag2
  Scenario Outline: Title of your scenario outline
  Given I landed on Ecommerce Page 
  When Logged in with username <name> and password <password>
  Then "Incorrect email or password." message is displayed on ConfirmationPage
    
 Examples: 
   | name             | password        | productName  |
   | myo123@gmail.com |  Chichu1998@3 |ZARA COAT 3 |