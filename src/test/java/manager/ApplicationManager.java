package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigProperties;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    static String browser;
    public ApplicationManager() {
        browser = System.getProperty("browser", BrowserType.CHROME);
    }
    EventFiringWebDriver driver;
    UserHelper userHelper;
    CarHelper carHelper;


    public void init(){
       // driver = new EventFiringWebDriver(new ChromeDriver());

        if(browser.equals(BrowserType.CHROME)) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("created chrome browser");
        }else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("started tests in firefox driver");
        }
//        driver.navigate().to("https://ilcarro.web.app/search");
//        logger.info("open page: https://ilcarro.web.app/search");
        driver.navigate().to(ConfigProperties.getProperty("url"));
        logger.info("open page: " + ConfigProperties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.register(new WDListener());

        userHelper = new UserHelper(driver);
        carHelper = new CarHelper(driver);
        logger.info("navigated to the url: https://ilcarro.web.app/search");

    }

    public void navigateToMainPage(){
        driver.navigate().to(ConfigProperties.getProperty("url"));
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
    
  public CarHelper getCarHelper(){
        return carHelper;
  }

    public void tearDown(){driver.quit();}
}
