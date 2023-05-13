import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConstructorSection {

    private WebDriver driver;

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
    public void testEntryConstructorSectionWithClickLabelConstructor() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("eliseev_23@gmail.com");
        objLoginPage.enterPassword("qwerty124");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();

        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelConstructor();
        objConstructorSection.verifyLoadConstructorSection();

        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void testEntryConstructorSectionWithClickLogoStellarBurgers() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("eliseev_23@gmail.com");
        objLoginPage.enterPassword("qwerty124");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();

        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLogoStellarBurgers();
        objConstructorSection.verifyLoadConstructorSection();

        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void testEntryBuns() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelSauces();
        objConstructorSection.clickLabelBuns();
        objConstructorSection.verifyLoadBuns();

        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void testEntrySauces() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelSauces();
        objConstructorSection.verifyLoadSauces();

        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void testEntryFillings() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        ConstructorSection objConstructorSection = new ConstructorSection(driver);
        objConstructorSection.clickLabelFillings();
        objConstructorSection.verifyLoadFillings();

        driver.quit();
    }

}
