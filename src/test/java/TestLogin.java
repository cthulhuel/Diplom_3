import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class TestLogin extends BaseTest {

    private final String Email;
    private final String Password;

    public TestLogin(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][] {
                { "eliseev_23@gmail.com", "qwerty124"},
        };
    }

    private WebDriver driver;

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
        objLoginPage.clickButtonEnterModal();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginPersonalPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterPersonal();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginRegistrationPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterRegistration();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginForgotPage() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterForgot();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
    }

}
