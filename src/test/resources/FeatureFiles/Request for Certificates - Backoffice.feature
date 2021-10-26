Feature: [SUC:29-01]-Request For Certificates-BackOffice

  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:29-01 @UAT_N_M29_29-01-01
  Scenario: UAT_N_M29_29-01-01-To Verify the process of creating certificate Request in BackOffice (GST Exempt Tax Certificate Application)
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
    Then Find purchaser details with tin "1000066411"
#    Then Find suppliers details with tin "1000065200"
#    Then Enter GST Excemptions for project number
#    Then Add GST Exempt Project Details
#    Then The goods listed above are eligible for entry under Customs Procedure Code No?
#    Then Enter procedue code number
#    Then Enter exclusive use for
#    Then Enter place of use as "Sierra Leonne"
#    Then Enter physical address
#    Then Enter amount paid as "1000"
#    Then Enter receipt number
#    Then Are bills of Quantity certified? "Yes"
#    Then Select certifier with tin "1000065200"
#    Then Enter attachment "id_doc.png"
#    Then Enter details of person making application
#    Then Click submit button for GST Excemption
#    Then Verify success message "Processing Completed - Reference Number -"
#    Then Obtain GST Excemption ARN "Processing Completed - Reference Number -"
#    Examples:
#      | Certificate                                       |
#      | GST Exempt Tax Certificate Application            |
#      | Tax Clearance Certificate Application             |
#      | Withholding Tax Exemption Certificate Application |
