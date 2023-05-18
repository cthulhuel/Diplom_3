import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class ConstructorSection {

    private WebDriver driver;
    final static String URL = "https://stellarburgers.nomoreparties.site/";
    private By labelAbout = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");
    private By labelConstructor = By.xpath(".//a[@href='/']");
    private By logoStellarBurgers = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']");
    private By labelBuns = By.xpath("//*[text()='Булки']/.");
    private By labelSauces = By.xpath("//*[text()='Соусы']/.");
    private By labelFillings = By.xpath("//*[text()='Начинки']/.");
    private By labelBunsSelected = By.xpath(".//div[@Class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Булки']");
    private By labelSaucesSelected = By.xpath(".//div[@Class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Соусы']");
    private By labelFillingsSelected = By.xpath(".//div[@Class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/h2[text()='Начинки']");

    public ConstructorSection(WebDriver driver) { this.driver = driver; }

    public void clickLabelConstructor() { driver.findElement(labelConstructor).click(); }
    public void clickLogoStellarBurgers() { driver.findElement(logoStellarBurgers).click(); }
    public void clickLabelBuns() { driver.findElement(labelBuns).click(); }
    public void clickLabelSauces() { driver.findElement(labelSauces).click(); }
    public void clickLabelFillings() { driver.findElement(labelFillings).click(); }

    public void verifyLoadConstructorSection() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelAbout).getText() != null));
        String ExpectedText = "Соберите бургер";
        String ActualText = driver.findElement(labelAbout).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

    public void verifyLoadBuns() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelBuns).getText() != null));
        assertTrue(driver.findElement(labelBunsSelected).isDisplayed());
        }

    public void verifyLoadSauces() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelSauces).getText() != null));
        assertTrue(driver.findElement(labelSaucesSelected).isDisplayed());
    }

    public void verifyLoadFillings() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(labelFillings).getText() != null));
        assertTrue(driver.findElement(labelFillingsSelected).isDisplayed());
    }

}
