import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEntryPersonalPage {

    private WebDriver driver;

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void testEntryPersonalPage() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("eliseev_23@gmail.com");
        objLoginPage.enterPassword("qwerty124");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();

        PersonalPage objPersonalPage = new PersonalPage(driver);
        objPersonalPage.verifyLoadPersonalPage();

        driver.quit();
    }



}
