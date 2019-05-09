# Google Search Test template
The `Google Search Test template` is a maven template for test automation projects.

This template uses selenium, cucumber and serenity to:
 1. automate browser actions,
 2. through gherkin style (given, when, then) feature files and
 3. generate test-reports (-> mvn verify)

---  

## Feel free to fork this project as a base for your test automation projects.  

### This template includes:
 * latest drivers (chromedriver & geckodriver)
 * drivers are added to failsafe plugin
 * dependencies have been updated to latest versions
 
---

---  
This template is based on the maven serenity-cucumber-archetype
---

How to Run Tests :

1. Run from Java Class - DefinitionTestSuite
2. Run from build :   mvn clean Verify


Results :

Check for the folder 'site' under target folder to verify the results of tests