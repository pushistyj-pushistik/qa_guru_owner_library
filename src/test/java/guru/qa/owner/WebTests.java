package guru.qa.owner;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import guru.qa.owner.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebTests {
    @BeforeAll
    static void setUp () {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.baseUrl = config.baseUrl();
        Configuration.remote = config.remoteUrl();
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.browserVersion();
    }

    @Test
    public void findJUnit5Example() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").find(byText("Soft assertions")).click();
        $$("#wiki-body").find(Condition.text("Using JUnit5 extend test class")).shouldBe(Condition.visible);
    }
}
