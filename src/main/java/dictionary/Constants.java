package dictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {

    private Constants() {
    }

    public static final String HOME_MENU = "Home";
    public static final String WEBVIEW_MENU = "WebView";
    public static final String LOGIN_MENU = "Login";
    public static final String FORMS_MENU = "Forms";
    public static final String SWIPE_MENU = "Swipe";
    public static final String TITLE_LOGIN_MENU = "Login / Sign up Form";
    public static final String TITLE_FORMS_MENU = "Form components";
    public static final String TITLE_SWIPE_MENU = "Swipe horizontal";
    public static final List<String> BUTTONS_ACTIVE_ALERT = Collections.unmodifiableList(Arrays.asList("ASK ME LATER", "CANCEL", "OK"));

    public static final String ERROR_INPUT_EMAIL = "Please enter a valid email address";
    public static final String ERROR_INPUT_PASSWORD = "Please enter at least 8 characters";
    public static final String SUCCESS_INPUT_PASSWORD = "You are logged in!";


}
