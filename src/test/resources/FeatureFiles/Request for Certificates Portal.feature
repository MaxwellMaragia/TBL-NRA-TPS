Feature: [SUC:29-01]-Request For Certificates-Portal

  Background:
    Given User navigates to portal
    Then Enters the username "1000056406" and password "Password@123" to login to portal


  @SUC:29-01 @UAT_N_M29_29-01-07
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (Tax Clearance Certificate Application)
    And Navigate to my tax > Certificate request
    Then Select Certificate type "Tax Clearance Certificate Application"
    Then Enter tin as "1000059405"
    And Taxpayer name as "DR Maxipain MDsyL"
    And Trading name as "Codei Systems"
    And Email as "margiewambui11@gmail.com"
    And Contact number as "+254707338839"
    And Postal address as " Kenema,  Kenema,  East,  Sierra Leone"
    Then Enter transaction details description "Change of ownership of a company."
    Then Enter assessment date as "10/2021"
    Then Click next to go to attachment details screen
    Then Enter attachment details (Portal) "Application Letter"
    Then Submit portal Tax Clearance Certificate Application
    Then Verify portal success message "Your TCC Certificate request has been submitted successfully. Your reference number is:"
    Then Obtain Tax Clearance ref number "Your TCC Certificate request has been submitted successfully. Your reference number is:"
    Then Navigate to my tax > View Certificate Request Status
    Then Enter request number
    Then Verify case request status "Approved"

  @SUC:29-01 @UAT_N_M29_29-01-07 @boom
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (GST Exempt Tax Certificate Application)
    And Navigate to my tax > Certificate request
    Then Select GST Exempt Tax Certificate Application certificate "GST Exempt Tax Certificate Application"
    Then Enter purchaser tin "1000068609" name "DR Maxipain ajdUkZ" and address "Sierra Leone, East, Kenema"
    Then Enter supplier tin "1000066411" name "DR Maxipain kWKCR" and address "Sierra Leone, East, Kenema"
    Then Proceed to GST screen
    Then Upload GST CSV template
    Then Enter GST Excempt project number
    Then Enter custom procedue code number
    Then Fill in use by field "Government"
    Then Give place of use "Government offices Sierra Leone"
    Then Give physical address "Kenema,  Kenema,  East,  Sierra Leone"
    Then Enter processing fees and receipt number
    Then Enter bill of quantity surveyor details
    Then Proceed to attachment details screen
    Then Enter attachment details for GST (portal)
    Then Enter details of person making the application (GST portal)
    Then Submit GST Excemption certificate application (Portal)
    Then Verify portal success message "Your GST Certificate request has been submitted successfully. Your reference number is:"
    Then Obtain GST Excemption Certificate ref number "Your GST Certificate request has been submitted successfully. Your reference number is:"
    Then Navigate to my tax > View Certificate Request Status
    Then Enter request number
    Then Verify case request status "Approved"
