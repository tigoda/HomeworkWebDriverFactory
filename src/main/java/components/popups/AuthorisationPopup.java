package components.popups;

import common.AbsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorisationPopup extends AbsCommon implements IPopup {

    public AuthorisationPopup(WebDriver driver) {
        super(driver);
    }

    private By searchResultsViewLocator = By.xpath("//div[text()='Вход']");
    private By inputLoginLocator = By.xpath("//input[@name='email']");
    private By inputPasswordLocator = By.xpath("//input[@type='password']");
    private By loginToAccountButtonLocator = By.xpath("//button[./*[text()='Войти']]");

    //    private String login = System.getProperty("login");
//    private String password = System.getProperty("password");
    private String login = "kristinka130788@mail.ru";
    private String password = "12345678Ok-";


    @Override
    public void popupShouldNotBeVisible() {

        assertThat(waiters.waitForElementNotVisible(searchResultsViewLocator))
                .as("Error")
                .isTrue();
    }

    @Override
    public void popupShouldBeVisible() {

        assertThat(waiters.waitForElementVisible(searchResultsViewLocator))
                .as("Error")
                .isTrue();
    }

    public AuthorisationPopup inputEmail() {

        $(By.xpath("//div[./input[@name='email']]")).click();

        assertThat(waiters.waitForElementVisible(inputLoginLocator))
                .as("Error")
                .isTrue();

        $(inputLoginLocator).sendKeys(login);

        return this;
    }

    public AuthorisationPopup inputPassword() {

        $(By.xpath("//div[./input[@type='password']]")).click();

        assertThat(waiters.waitForElementVisible((inputPasswordLocator)))
                .as("Error")
                .isTrue();

        $(inputPasswordLocator).sendKeys(password);

        return this;
    }


    public AuthorisationPopup loginToAccountButtonClick() {

        $(loginToAccountButtonLocator).click();

        return this;
    }


    public void accountLoginResult() {

        assertThat(waiters.waitForCondition(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//button[text()='Выйти']"))))
                .as("Error")
                .isTrue();

    }
}