import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.open;

public class GitAutotests {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void findJUnit5Example() {
        open("https://github.com/");
        //открыть страницу github.com
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        //поиск по "selenide"
        $(byAttribute("href","/selenide/selenide")).click();
        //открыть проект selenide
        $("#wiki-tab").click();
        //перейти в раздел wiki
        $("#wiki-pages-box").scrollIntoView(false).$("div:last-child").$("button",1).click();
        //раскрыть список Pages
        $(byAttribute("data-filterable-for","wiki-pages-filter")).shouldHave(text("SoftAssertions"));
        //найти раздел Soft Assertions
        $(byAttribute("href","/selenide/selenide/wiki/SoftAssertions")).click();
        //перейти в раздел Soft Assertions
        $("#wiki-body").$$(".markdown-heading").findBy(text("JUnit5")).sibling(0).shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
        //поиск примера для JUnit5
    }

}
