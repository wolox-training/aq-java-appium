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
To perform the action horizontal and vertical scroll down to an element we can guide the : http://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-layout-direction/

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