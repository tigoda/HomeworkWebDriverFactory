import components.HeaderComponent;
import components.popups.AuthorisationPopup;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class AuthorizationOnTheSite_Test {
    private WebDriver driver = null;

    @BeforeEach
    public void init() {
        driver = new WebDriverFactory().create();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void authorisationOnOtus() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        AuthorisationPopup authorisationPopup = new AuthorisationPopup(driver);

        authorisationPopup
                .popupShouldNotBeVisible();

        new HeaderComponent(driver).loginButtonClick();

        authorisationPopup
                .popupShouldBeVisible();

        authorisationPopup
                .inputEmail()
                .inputPassword()
                .loginToAccountButtonClick()
                .accountLoginResult();

    }
}
