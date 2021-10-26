Feature: [SUC:29-13]-Request For Certificates-BackOffice

  Background:
    Given User navigates to the login page
    Then Enters the username "tripsuser" and password "Passw0rd" to login

  @SUC:29-13 @UAT_M29_29-13-01 @faq
  Scenario Outline: UAT_M29_29-13-01-To verify the process of creating FAQs
    And Click on Taxpayer services > FAQs > Create FAQ
    Then Submit FAQ
    Then Verify error message "Section: Validation Error: Value is required."
    Then Verify error message "FAQ: Validation Error: Value is required."
    Then Verify error message "Answer: Validation Error: Value is required."
    Then Verify all fields and dropdown values and select category as "<Category>"
    Then Enter random FAQ and answer
    Then Submit FAQ
    Then Verify success message "FAQ Details are saved successfully"
    Examples:
      | Category               |
      | Exemptions             |
      | General                |
      | Objections and Appeals |
      | Payments               |
      | Portal                 |
      | Refunds                |
      | Registration           |
      | Tax Returns            |

  @SUC:29-14 @UAT_M29_29-14-01 @faq
  Scenario: UAT_M29_29-14-01-To verify the process of updating FAQ
    And Click on Taxpayer services > FAQs > Update FAQ
    Then Search for FAQ
    Then Verify error message "At least one field is required"
    Then Enter Invalid FAQ details
    Then Search for FAQ
    Then Verify no data is found in table
    Then Enter valid FAQ
    Then Search for FAQ
    Then Verify FAQ found and displayed in table
    Then Click edit button
    Then Enter new random answer
    Then Click submit to update FAQ
    Then Verify success message "FAQ Details are updated successfully"




