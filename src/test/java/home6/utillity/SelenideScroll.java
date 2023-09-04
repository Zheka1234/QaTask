package home6.utillity;

import com.codeborne.selenide.Selenide;

public class SelenideScroll {

    public static void scrollDown() {
        Selenide.executeJavaScript("window.scrollTo(0, 400)");
    }
}
