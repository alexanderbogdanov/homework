package cloud.autotests.tests;

import cloud.autotests.pages.YandexPage;
import cloud.autotests.tests.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static cloud.autotests.helpers.EnvironmentHelper.*;


@Epic("QA.GURU automation course")
@Story("Yandex tests")
@Tag("yandex")

public class YandexTests extends TestBase {

    @Test
    @Disabled
    @Description("Positive Search Test With PageObject")
    void SearchTest() {
        YandexPage yandexPage = new YandexPage();
        open(yaUrl);
        yandexPage.searchInput(YandexPage.query);
        yandexPage.verifyResultFound(YandexPage.searchResult);
    }

    @Test
    @Description("Positive Search Test With Steps")
    @DisplayName("Positive Search")
    void SearchTestWithSteps() {
        step("Открываем главную Яндекса", () -> open("https://yandex.ru"));
        step("Вводим запрос в строке поиска", () -> {
            $("#text").val("lepra").pressEnter();
        });
        step("Проверяем результаты поиска", () -> {
            $("html").shouldHave(text("Лепрозорий: вход"));
        });
    }
}
