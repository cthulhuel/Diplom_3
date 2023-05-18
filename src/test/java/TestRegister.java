import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestRegister {

    private final String Name;
    private final String Email;
    private final String Password;

    public TestRegister(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][] {
                { "evgeny", "eliseev_23@gmail.com", "qwerty124" },
        };
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void testSuccessRegister() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.enterName(Name);
        objRegisterPage.enterEmail(Email);
        objRegisterPage.enterPassword(Password);
        objRegisterPage.clickButtonRegister();
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void testErrorRegisterWithIncorrectPassword() {
        RegisterPage objRegisterPage = new RegisterPage(driver);
        objRegisterPage.enterName("TestName");
        objRegisterPage.enterEmail("TestEmail@email.com");
        objRegisterPage.enterPassword("12345");
        objRegisterPage.clickButtonRegister();
        objRegisterPage.verifyErrorRegisterWithIncorrectPassword();
    }

}
