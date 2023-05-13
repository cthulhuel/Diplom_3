import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorSection {

    private WebDriver driver;

    private By labelAbout = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");
    private By labelConstructor = By.xpath(".//a[@href='/']");
    private By logoStellarBurgers = By.xpath("//*[@xmlns='http://www.w3.org/2000/svg']");
    private By labelBuns = By.xpath("//*[text()='Булки']/.");
    private By labelSauces = By.xpath("//*[text()='Соусы']/.");
    private By labelFillings = By.xpath("//*[text()='Начинки']/.");
    private By kratornayaBun = By.xpath("//*[text()='Краторная булка N-200i']/.");
    private By antarianSauce = By.xpath("//*[text()='Соус с шипами Антарианского плоскоходца']/.");
    private By tetraodontymformFilling = By.xpath("//*[text()='Филе Люминесцентного тетраодонтимформа']/.");

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
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(kratornayaBun).getText() != null));
        String ExpectedText = "Краторная булка N-200i";
        String ActualText = driver.findElement(kratornayaBun).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

    public void verifyLoadSauces() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(antarianSauce).getText() != null));
        String ExpectedText = "Соус с шипами Антарианского плоскоходца";
        String ActualText = driver.findElement(antarianSauce).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

    public void verifyLoadFillings() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(tetraodontymformFilling).getText() != null));
        String ExpectedText = "Филе Люминесцентного тетраодонтимформа";
        String ActualText = driver.findElement(tetraodontymformFilling).getText();
        Assert.assertEquals("Текст не соответствует ожидаемому результату", ExpectedText, ActualText);
    }

}
