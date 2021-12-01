Feature: [SUC:29-08] Submission of Walk-in and Other Requests

  @SUC:29-08 @UAT_N_M29_29-08-01 @amendment-of-tax-return
  Scenario: UAT_N_M29_29-08-01-To verify the process of General service request (Returns adjustment)
    Given User navigates to portal
    Then Enters the username "1000070621" and password "Password@123" to login to portal
    And Navigate to my tax > General service request
    Then Select request type "Amendment of Tax Return"
    Then Select return type for amendment as "Pay As You Earn Return"
    Then Enter period for amendment as "01/2020" and reasons for applying for amendment
    Then Enter attachment details for general service request "Any Other"
    Then Submit general service request application
    Then Verify portal success message "Your Service request has been submitted successfully. Your reference number is:"
    Then Obtain general service request arn "Your Service request has been submitted successfully. Your reference number is:"

  @SUC:29-08 @UAT_N_M29_29-08-01 @any-other-taxpayer-service-request
  Scenario: UAT_N_M29_29-08-01-To verify the process of General service request (Any Other Taxpayer Service Requests)
    Given User navigates to portal
    Then Enters the username "1000070621" and password "Password@123" to login to portal
    And Navigate to my tax > General service request
    Then Select request type "Any Other Taxpayer Service Requests"
    Then Enter subject and details of request
    Then Enter attachment details for general service request "Any Other"
    Then Submit general service request application
    Then Verify portal success message "Your Service request has been submitted successfully. Your reference number is:"
    Then Obtain general service request arn "Your Service request has been submitted successfully. Your reference number is:"

  @SUC:29-08 @UAT_N_M29_29-08-01 @cancellation-of-tax-return
  Scenario: UAT_N_M29_29-08-01-To verify the process of General service request (Returns cancellation)
    Given User navigates to portal
    Then Enters the username "1000070621" and password "Password@123" to login to portal
    And Navigate to my tax > General service request
    Then Select request type "Cancellation of Tax Return"
    Then Select return type for cancellation as "Pay As You Earn Return"
    Then Enter period for cancellation as "01/2020" and reasons for applying for amendment
    Then Enter attachment details for general service request "Any Other"
    Then Submit general service request application
    Then Verify portal success message "Your Service request has been submitted successfully. Your reference number is:"
    Then Obtain general service request arn "Your Service request has been submitted successfully. Your reference number is:"

  @SUC:29-08 @UAT_N_M29_29-08-01 @amendment-of-tax-return @any-other-taxpayer-service-request @cancellation-of-tax-return
  Scenario: UAT_N_M29_29-08-01-To verify the process of send for approval (General service request - Returns adjustment)
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
    Then Case status should be "Pending for Approval"

  @SUC:29-08 @UAT_N_M29_29-08-01 @amendment-of-tax-return @any-other-taxpayer-service-request @cancellation-of-tax-return
  Scenario: UAT_N_M29_29-08-01-To verify the process of approval (General service request - Returns adjustment)
    Given Open CRM URL Module as "TaxpayerServsup1"
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
    Then Approve general service request application
    Then Save general service request application
    Then Case status should be "Approved"