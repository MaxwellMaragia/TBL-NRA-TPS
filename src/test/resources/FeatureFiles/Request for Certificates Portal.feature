Feature: [SUC:29-01]-Request For Certificates-Portal

  Background:
    Given User navigates to portal
    Then Enters the username "1000056406" and password "Password@123" to login to portal


  @SUC:29-01 @UAT_N_M29_29-01-07
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (Tax Clearance Certificate Application)
    And Navigate to my tax > Certificate request
    Then Select Certificate type "Tax Clearance Certificate Application"