import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestLogout extends BaseTest {

    private WebDriver driver;

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void testLogout() {
        LoginPage objLoginPage = new LoginPage(driver);
        LogoutPage objLogoutPage = new LogoutPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("eliseev_23@gmail.com");
        objLoginPage.enterPassword("qwerty124");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();
        objLogoutPage.waitForLoadPage();
        objLogoutPage.clickButtonExit();
        objLogoutPage.verifyLogout();
    }

}
