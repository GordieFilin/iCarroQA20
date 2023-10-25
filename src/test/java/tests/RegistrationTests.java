package tests;

import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTests extends BaseTest{

//    @BeforeTest(alwaysRun = true)
//
//    public void preconditionsLogin() {
//        app.navigateToMainPage();
//        logoutIfLogin();
//    }
//
//    @AfterTest(alwaysRun = true)
//    public void postConditionsLogin() {
//        app.getUserHelper().clickOkPopUpSuccessLogin();
//    }

    @BeforeTest(alwaysRun = true)
    public void preconditionsLogin() {
        //  app.navigateToMainPage();
        logoutIfLogin();

        // user login
        // user open web not login
    }

    @AfterTest(alwaysRun = true)
    public void postConditionsLogin() {
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test
    public void negativeRegistrationWrongEmail(){

        UserDtoLombok user = UserDtoLombok.builder()
                .email("abc@")
                .password("123456Aa!")
                .lastname("abcd")
                .name("testing")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateMessageIncorrectEmail());
    }

    @Test
    public void negativeRegistrationWrongPassword(){
        String email = randomUtils.generateEmail(7);


        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa")
                .lastname("abcd")
                .name("testing")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
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

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validateErrorEmptyEmailReg());
    }

    @Test(groups={"regression"})
    public void positiveRegistration(){
        String email = randomUtils.generateEmail(7);


        UserDtoLombok user = UserDtoLombok.builder()
                .email(email)
                .password("123456Aa!")
                .lastname("abcd")
                .name("testing")
                .build();

        app.getUserHelper().fillRegistrationForm(user);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterRegistration());
    }
}
