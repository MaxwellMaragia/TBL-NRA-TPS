Feature: [SUC:29-01]-Request For Certificates-BackOffice

  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:29-01 @UAT_N_M29_29-01-03
  Scenario: UAT_N_M29_29-01-03-To Verify the process of failed validation
    And Click on Taxpayer services > Certificate Types > Create certificate request
    Then Click next button
    Then Verify error message "Certificate Type: Validation Error: Value is required."
    Then Select certificate "GST Exempt Tax Certificate Application"
    Then Click next button
    Then Click submit button for GST Excemption
    Then Verify error message "Purchaser Name: Validation Error: Value is required."
    Then Verify error message "Purchaser Address: Validation Error: Value is required."
    Then Verify error message "GST EXEMPT PROJECT No: Validation Error: Value is required."
    Then Verify error message "The goods listed above are eligible for entry under Customs Procedure Code No.: Validation Error: Value is required."
    Then Verify error message "And are for exclusive use for/by: Validation Error: Value is required."
    Then Verify error message "Place of use: Validation Error: Value is required."
    Then Verify error message "Physical Address: Validation Error: Value is required."
    Then Verify error message "Amount Paid: Validation Error: Value is required."
    Then Verify error message "Reciept Number: Validation Error: Value is required."
    Then Verify error message "Bills of Quantity Certified: Validation Error: Value is required."
    Then Verify error message "Document Type: Validation Error: Value is required."
    Then Verify error message "Document Name / Number: Validation Error: Value is required."
    Then Verify error message "Full Name: Validation Error: Value is required."
    Then Verify error message "Office Title/Designation: Validation Error: Value is required."
    Then Verify error message "Identification Number: Validation Error: Value is required."

  @SUC:29-01 @UAT_N_M29_29-01-01
  Scenario: UAT_N_M29_29-01-01-To Verify the process of creating certificate Request in BackOffice (GST Exempt Tax Certificate Application)
    And Click on Taxpayer services > Certificate Types > Create certificate request
    Then Click next button
    Then Verify error message "Certificate Type: Validation Error: Value is required."
    Then Select certificate "GST Exempt Tax Certificate Application"
    Then Click next button
    Then Find purchaser details with tin "1000066411"
    Then Find suppliers details with tin "1000065200"
    Then Enter GST Excemptions for project number
    Then Add GST Exempt Project Details
    Then The goods listed above are eligible for entry under Customs Procedure Code No?
    Then Enter procedue code number
    Then Enter exclusive use for
    Then Enter place of use as "Sierra Leonne"
    Then Enter physical address
    Then Enter amount paid as "1000"
    Then Enter receipt number
    Then Are bills of Quantity certified? "Yes"
    Then Select certifier with tin "1000065200"
    Then Enter attachment "id_doc.png"
    Then Enter details of person making application
    Then Click submit button for GST Excemption
    Then Verify success message "Processing Completed - Reference Number -"
    Then Obtain GST Excemption ARN "Processing Completed - Reference Number -"
    And Click on Taxpayer services > Certificate Types > Track request status
    Then Enter ref number
    Then Verify status "Approved"

  @SUC:29-01 @UAT_N_M29_29-01-01
  Scenario: UAT_N_M29_29-01-01-To Verify the process of creating certificate Request in BackOffice (Tax Clearance Certificate Application)
    And Click on Taxpayer services > Certificate Types > Create certificate request
    Then Click next button
    Then Verify error message "Certificate Type: Validation Error: Value is required."
    Then Select certificate "Tax Clearance Certificate Application"
    Then Click next button
    Then Find tin for tax clearance "1000069222"
    Then Enter transaction details "Change of ownership of a company."
    Then Enter period of assessment month "10" and year "2021"
    Then Enter attachment details
    Then Enter details of person making the application
    Then Submit certificate request application
    Then Verify success message "Processing Completed - Reference Number -"
    Then Obtain Certificate Request ARN "Processing Completed - Reference Number -"
    And Click on Taxpayer services > Certificate Types > Track request status
    Then Enter ref number
    Then Verify status "Approved"

  @SUC:29-01 @UAT_N_M29_29-01-01
  Scenario: UAT_N_M29_29-01-01-To Verify the process of creating certificate Request in BackOffice (WITHHOLDING TAX EXEMPTION)
    And Click on Taxpayer services > Certificate Types > Create certificate request
    Then Click next button
    Then Verify error message "Certificate Type: Validation Error: Value is required."
    Then Select certificate "Withholding Tax Exemption Certificate Application"
    Then Click next button
    Then find tin for withholding tax excemption "1000069222"
    Then fill in witholding tax excemption details
    Then Enter attachment details for Withholding Tax Exemption Certificate Application
    Then Enter details of person making the application for Withholding Tax Exemption Certificate Application
    Then Submit withholding tax excemption application
    Then Verify success message "Processing Completed - Reference Number -"
    Then Obtain Certificate Request ARN "Processing Completed - Reference Number -"
    And Click on Taxpayer services > Certificate Types > Track request status
    Then Enter ref number
    Then Verify status "Approved"

  @SUC:29-01 @UAT_N_M29_29-01-05 @boom
  Scenario: UAT_N_M29_29-01-05-To verify the process of Compliance Breach and Compliance Check
    And Click on Taxpayer services > Certificate Types > Create certificate request
    Then Click next button
    Then Verify error message "Certificate Type: Validation Error: Value is required."
    Then Select certificate "Tax Clearance Certificate Application"
    Then Click next button
    Then Find tin for tax clearance "1000062805"
    Then Enter transaction details "Change of ownership of a company."
    Then Enter period of assessment month "10" and year "2021"
    Then Enter attachment details
    Then Enter details of person making the application
    Then Submit certificate request application
    Then Verify success message "Application Rejected - Reference Number -"
    Then Obtain Certificate Request ARN "Application Rejected - Reference Number -"
    And Click on Taxpayer services > Certificate Types > Track request status
    Then Enter ref number
    Then Verify status "Rejected"
