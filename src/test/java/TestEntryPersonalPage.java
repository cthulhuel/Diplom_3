import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestEntryPersonalPage extends BaseTest {

    private WebDriver driver;

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void testEntryPersonalPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("eliseev_23@gmail.com");
        objLoginPage.enterPassword("qwerty124");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();
        PersonalPage objPersonalPage = new PersonalPage(driver);
        objPersonalPage.verifyLoadPersonalPage();
    }

}
