package environment;

import com.browserup.bup.BrowserUpProxy;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;


import static com.codeborne.selenide.Selenide.*;

public class EnvironmentSetup {

    public BrowserUpProxy bmp;

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        System.setProperty("selenide.browser", "Chrome");

        Configuration.headless = true;
        open("https://localhost:7135/swagger/index.html");
    }

    public void tearDown() {
        closeWebDriver();
    }
}