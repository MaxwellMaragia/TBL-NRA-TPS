Feature: [SUC:29-01]-Request For Certificates-Portal

  Background:
    Given User navigates to portal
#    Then Enters the username "1000056406" and password "Password@123" to login to portal
    Then Enters the username "1000070621" and password "Password@123" to login to portal

  @SUC:29-01 @UAT_N_M29_29-01-07
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (Tax Clearance Certificate Application - Change of ownership of a company)
    And Navigate to my tax > Certificate request
    Then Select Certificate type "Tax Clearance Certificate Application" and transaction type "Change of ownership of a company."
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

  @SUC:29-01 @UAT_N_M29_29-01-07
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (Tax Clearance Certificate Application - Externalisation of funds to non-resident service providers whose source is deemed to be Sierra Leone)
    And Navigate to my tax > Certificate request
    Then Select Certificate type "Tax Clearance Certificate Application" and transaction type "Externalisation of funds to non-resident service providers whose source is deemed to be Sierra Leone."
    Then Enter transaction and assessment details "11/2021"
    Then Enter remittance details
    Then Enter attachment details (Portal) "Details of the contracts agreements"
    Then Submit portal Tax Clearance Certificate Application
    Then Verify portal success message "Your TCC Certificate request has been submitted successfully. Your reference number is:"
    Then Obtain Tax Clearance ref number "Your TCC Certificate request has been submitted successfully. Your reference number is:"
    Then Navigate to my tax > View Certificate Request Status
    Then Enter request number
    Then Verify case request status "Approved"


  @SUC:29-01 @UAT_N_M29_29-01-07
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (Tax Clearance Certificate Application - Transfer of land and building)
    And Navigate to my tax > Certificate request
    Then Select Certificate type "Tax Clearance Certificate Application" and transaction type "Transfer of land and building"
    Then Enter transaction and assessment details "11/2021"
    Then Enter transfer details with tin "1000070034"
    Then Enter attachment details (Portal) "Cost of Improvement Details"
    Then Submit portal Tax Clearance Certificate Application
    Then Verify portal success message "Your TCC Certificate request has been submitted successfully. Your reference number is:"
    Then Obtain Tax Clearance ref number "Your TCC Certificate request has been submitted successfully. Your reference number is:"
    Then Navigate to my tax > View Certificate Request Status
    Then Enter request number
    Then Verify case request status "Approved"


  @SUC:29-01 @UAT_N_M29_29-01-07
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

  @SUC:29-01 @UAT_N_M29_29-01-07
  Scenario: UAT_N_M29_29-01-07-To Verify the process of creating certificate Request in Portal (Withholding Tax Exemption Certificate Application)
    And Navigate to my tax > Certificate request
    Then Select Withholding Tax Exemption Certificate Application certificate "Withholding Tax Exemption Certificate Application"
    Then Select nature of income as "Actuarial fees"
    Then Type description of nature of income
    Then Select reason for applying excemption as "Bilateral Agreement between Govts" and click next
    Then Enter attachment details for WHT excemption
    Then Enter details of person making the application (WHT Excemption portal)
    Then Submit WHT excemption certificate application
    Then Verify portal success message "Your WHTEC Certificate request has been submitted successfully. Your reference number is:"
    Then Obtain WHT Excemption Certificate ref number "Your WHTEC Certificate request has been submitted successfully. Your reference number is:"
    Then Navigate to my tax > View Certificate Request Status
    Then Enter request number
    Then Verify case request status "Approved"


