@Runner
Feature: SingUp | user should be able to add items to the cart and to sign up with new account

  Scenario: user should be able to add items and signUp

  Given user navigate to home page
  When User add 2 items to the cart
  And user click on view cart to proceed checkout
  And user add valid name and email to register
  And user fill all his account details with "ACCOUNT CREATED!"
  When user navigate to the cart page and proceed to checkout
  And user add random data for payment and download the invoice


