package cloud.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YandexPage {
    //    elements
    SelenideElement queryInput = $(by("id", "text")),
            htmlBody = $("html");

    //    logic
    public static String query = "lepra";
    public static String searchResult = "Лепрозорий: вход";

    @Step("Type search query {query}")
    public void searchInput(String query) {
        queryInput.val(query).pressEnter();
    }

    @Step("Verify if found {queryResult}")
    public void verifyResultFound(String searchResult) {
        htmlBody.shouldHave(text(searchResult));
    }
}
