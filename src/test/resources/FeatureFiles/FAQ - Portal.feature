Feature: [SUC:29-15]-FAQ Portal

  Background:
    Given User navigates to portal
    Then Enters the username "1000056406" and password "Password@123" to login to portal


  @SUC:29-15 @UAT_M29_29-15-01 @UAT_M29_29-15-02
  Scenario: UAT_M29_29-15-02-To verify the process of viewing and searching FAQ
    And Navigate to my support > FAQ
    Then Verify all FAQ categories are displayed
    Then Search for invalid faq
    Then Search for valid faq
