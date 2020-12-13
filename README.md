## UIAutomationExercise

##### Run test from command line using Maven

```
mvn -Dtest=AddItemToCartTest test
```

##### Project Structure
- `src/java/lib/Base` contains BrowserChrome class for setUp and tearDown tests.
- `src/java/lib/Store` contains HashMap for storing data during test steps.
- `src/java/lib/UI/MainPageObject` contains general re-usable methods.
- `src/java/lib/UI/*` contains PageObjects with elements and methods for specific pages.
- `src/java/tests` contains actual Tests.
