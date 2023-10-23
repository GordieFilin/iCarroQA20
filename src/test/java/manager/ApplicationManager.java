package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    EventFiringWebDriver driver;
    UserHelper userHelper;


    public void init(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.navigate().to("https://ilcarro.web.app/search");
        logger.info("open page: https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.register(new WDListener());

        userHelper = new UserHelper(driver);
        logger.info("navigated to the url: https://ilcarro.web.app/search");

    }

    public void navigateToMainPage(){
        driver.navigate().to("https://ilcarro.web.app/search");
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void tearDown(){driver.quit();}
}
