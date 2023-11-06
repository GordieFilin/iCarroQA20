package manager;

import dto.AddCarDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class CarHelper extends BaseHelper {
    public CarHelper(WebDriver driver) {
        super(driver);
    }

    By btnLetCarWork = By.xpath("//a[contains(@href, '/let-car-work')]");
    By inputLocation = By.xpath("//input[@id ='pickUpPlace']");
    By btnLocator = By.xpath("//div/div[3]/span/span");
    By inputManufacture = By.xpath("//input[@id ='make']");
    By inputModel = By.xpath("//input[@id ='model']");
    By inputYear = By.xpath("//input[@id ='year']");
    By btnFuel = By.xpath("//select[@id='fuel']");
    By btnDiesel = By.xpath("//option[@value ='Diesel']");
    By inputSeats = By.xpath("//input[@id ='seats']");
    By inputClass = By.xpath("//input[@id ='class']");
    By inputRegNumber = By.xpath("//input[@id ='serialNumber']");
    By inputPrice = By.xpath("//input[@id ='price']");
    By inputAbout = By.xpath("//textarea[@id ='about']");
    By btnSubmit = By.xpath("//button[@type ='submit']");
    By textSuccessCarAdd = By.xpath("//button[@class = 'positive-button ng-star-inserted']");
    public void addNewCar(AddCarDTO addCarDTO) {
        /*
       + click let-car-work
       + in location type "haifa" and click Haifa Port
       + type Manufacture
       + type model
       + type year
       + click fuel choose diesel
       + type seats
       + type car class
       + type car reg number
       + type price
       + type about
       + click submit
         */
        clickBase(btnLetCarWork);
        typeTextBase(inputLocation,addCarDTO.getLocation());
        clickBase(btnLocator);
        typeTextBase(inputManufacture, addCarDTO.getManufacture());
        typeTextBase(inputModel, addCarDTO.getModel());
        typeTextBase(inputYear, addCarDTO.getYear());
        clickBase(btnFuel);
        clickBase(btnDiesel);
        typeTextBase(inputSeats, addCarDTO.getSeats());
        typeTextBase(inputClass, addCarDTO.getCarClass());
        typeTextBase(inputRegNumber, addCarDTO.getCarRegNumber());
        typeTextBase(inputPrice, addCarDTO.getPrice());
        typeTextBase(inputAbout, addCarDTO.getAbout());
        clickBase(btnSubmit);

    }

    public boolean validatePopUpAfterAddNewCar(){
        return isTextEqual(textSuccessCarAdd,"Show car");
    }
}
