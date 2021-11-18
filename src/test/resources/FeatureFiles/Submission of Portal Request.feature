Feature: [SUC:29-08] Submission of Walk-in and Other Requests

  Background:
    Given User navigates to portal
    Then Enters the username "1000070621" and password "Password@123" to login to portal

  @SUC:29-08 @UAT_N_M29_29-08-01
  Scenario: UAT_N_M29_29-08-01-To verify the process of Failed Validation
    And Navigate to my tax > General service request
    Then Select request type "Amendment of Tax Return"
    Then Select return type for amendment as "Pay As You Earn Return"
    Then Enter period for amendment as "01/2020" and reasons for applying for amendment
    Then Enter attachment details for general service request "Any Other"
    Then Submit general service request application
    Then Verify portal success message "Your Service request has been submitted successfully. Your reference number is:"
    Then Obtain general service request arn "Your Service request has been submitted successfully. Your reference number is:"
    Given Open CRM URL Module as "TaxpayerServOff1"
    And Close Popup Window
    And Click on Case management dropdown
    And click on Queues
    Then switch to frame0
    And enters service request reference number in search results
    And tick case checkbox
    And pick the case from dropdown
    Then switch to frame0
    Then Click on reference number
    Then switch to frame1
    And wait for plan to load "Request Type"
    Then switch to frame1
    And Select status as send for approval
    Then Save general service request application
    Then Case status should be ""
