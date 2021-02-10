# Mobile automation project (Appium-Java)

The project for the automation of mobile devices was created with the following tools

* Java
* Cucumber
* Gradle
* Intellij IDE

## Used dependencies

```
dependencies {
    implementation group: 'io.cucumber', name: 'cucumber-java', version: '6.9.1'
    implementation 'com.github.javafaker:javafaker:1.0.2'
    compile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.7.0'
    compile group: 'io.appium', name: 'java-client', version: '7.4.1'
    compile 'io.github.cdimascio:dotenv-java:2.2.0'
    testCompile group: 'io.cucumber', name: 'cucumber-junit', version: '6.9.1'
}
```

## Mobile Swipe

To perform an horizontal and vertical scroll down to an element we can follow this
guide: http://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-layout-direction/

```
public class SwipeHelp {

    public static MobileElement androidHorizonalSwipe(String carousel, String option){
        return BrowserManagement.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable("+carousel+").setAsHorizontalList()." +
                "scrollIntoView("+option+")"));
    }

    public static MobileElement androidVerticalSwipe(String carousel, String option){
        return BrowserManagement.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable("+carousel+").setAsVerticalList()." +
                        "scrollIntoView("+option+")"));
    }
}
```

## RECOMMENDATIONS

It is recommended to work with JUnit4, because the @RunWith annotation of the test runners is typical of JUnit 4, for
use with JUnit 5 and allure it is required to use the engine-vintage, but when doing so JUnit is not able to recognize
the tests de cucumber, in addition to generating some unexpected behaviors and errors, which makes the project unstable.

## RUN CODE

By console you can execute the following line, in regressionType replace it with: @Login or @Forms or @Swipe or @Menus
or @All

``
./gradlew test --info -DregressionType="regressionType"
``

For example:

``
./gradlew test --info -DregressionType="@Login"
``


