import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogout {

    private WebDriver driver;

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void testLogout() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

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

        driver.quit();
    }



}
