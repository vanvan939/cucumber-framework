Feature: Go to https://www.saucedemo.com/ , Login and buy random 2 products successfully


  Background: Login successfully
    Given The user go to page with url "https://www.saucedemo.com/"
    Then Go to Page with logo "Swag Labs"
    When The user input username "standard_user" and password "secret_sauce"
    And The user click on Login
    Then Go to page with title "Products"

  Scenario: Buy 2 random products successfully
    When The user click on the first random product
    Then Name of button of product 1 is changed to "Remove"
    When The user click on the second random product
    Then Name of button of product 2 is changed to "Remove"
    When The user click on Cart icon
    Then Go to page with title "Your Cart"
    And The cart has correct 2 selected items
    When The user click on Check out
    Then Go to page with title "Checkout: Your Information"
    When The user enter First Name: "van", Last nam: "bui" and Postal Code: "0111"
    And The user click on Continue
    Then Go to page with title "Checkout: Overview"
    When The user click on Finish
    Then Go to page with title "Checkout: Complete!"
    When The user click on Back Home
    Then Go to page with title "Products"
