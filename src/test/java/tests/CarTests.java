package tests;

import dto.AddCarDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarTests extends BaseTest{

    @BeforeMethod
    public void preconditionsLogin() {
        alwaysLogin();
    }

    @Test
    public void positiveAddNewCar(){
        AddCarDTO addCarDTO = new AddCarDTO("Haifa", "France", "Renault",
                "2003","5","Sedan", "222223", "12", "Good car");
        app.getCarHelper().addNewCar(addCarDTO);
        Assert.assertTrue(app.getCarHelper().validatePopUpAfterAddNewCar());
        }

    }

