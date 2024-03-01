@Runner
Feature: SingUp | user should be able to sign up new account with Random data

  Scenario: user should be able to signUp with Random data

  Given user navigate to URL home page
  When user signUp and register with Random test data
  And user signUp successfully with Random data "ACCOUNT CREATED!"
  Then user logout successfully
