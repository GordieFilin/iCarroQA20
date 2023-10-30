package tests;

import data.DataProviderReg;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTests extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {
        logoutIfLogin();
    }

//    @AfterMethod(alwaysRun = true)
//    public void postConditionsRef() {
//    app.getUserHelper().refreshPage();
//    }

    @Test
    public void negativeRegistrationWrongEmail(){

        UserDtoLombok user = UserDtoLombok.builder()
                .email("abc@")
                .password("123456Aa!")
                .lastname("abcd")
                .name("testing")
                .build();

        app.getUserHelper().fillRegistrationFormNegativeTest(user);
        Assert.assertTrue(app.getUserHelper().validateMessageIncorrectEmail());
    }

    @Test
    public void negativeRegistrationWrongPassword(){
        String email = randomUtils.generateEmail(7);


        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("12345678")
                .lastname("abcd")
                .name("testing")
                .build();

        app.getUserHelper().fillRegistrationFormNegativeTest(user);
       Assert.assertTrue(app.getUserHelper().validateMessageWrongPassword());
    }

    @Test
    public void negativeRegistrationBlankEmail(){

        UserDtoLombok user = UserDtoLombok.builder()
                .email("")
                .password("123456Aa!")
                .lastname("abcd")
                .name("testing")
                .build();

        app.getUserHelper().fillRegistrationFormNegativeTest(user);
        Assert.assertTrue(app.getUserHelper().validateErrorEmptyEmailReg());
    }

    @Test(groups={"regression"}, dataProvider = "positiveDataReg", dataProviderClass = DataProviderReg.class)
    public void positiveRegistration(UserDtoLombok userDP){


//        String email = randomUtils.generateEmail(7);
//        UserDtoLombok user = UserDtoLombok.builder()
//                .email(email)
//                .password("123456Aa!")
//                .lastname("abcd")
//                .name("testing")
//                .build();

        app.getUserHelper().fillRegistrationForm(userDP);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }


//    @Test (dataProvider = "RegCSV", dataProviderClass = DataProviderLogin .class)
//    public void positiveRegistration(UserDtoLombok userDP){
//        app.getUserHelper().fillRegistrationForm(userDP);
//        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
//    }
}
