package tests;

import data.DataProviderLogin;
import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {


    @BeforeMethod(alwaysRun = true)
    public void preconditionsLogin() {
        //  app.navigateToMainPage();
        logoutIfLogin();

        // user login
        // user open web not login
    }

    @AfterMethod(alwaysRun = true)
    public void postConditionsLogin() {
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test(groups={"smoke"})
    public void positiveLoginUserDTO() {
        UserDTO userDTO = new UserDTO("gordie@gmail.com", "123456Aa!");
        app.getUserHelper().login(userDTO);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void positiveLoginUserDTOWith() {
        UserDTOWith userDTOWith = new UserDTOWith()
                .withEmail("gordie@gmail.com")
                .withPassword("123456Aa!");
        app.getUserHelper().login(userDTOWith);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

   // @Test(groups = {"smoke"}, dataProvider = "positiveDataLogin", dataProviderClass = DataProviderLogin.class)
    @Test (dataProvider = "loginCSV", dataProviderClass = DataProviderLogin .class)
    public void positiveLogin(UserDtoLombok userDP) {
//        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
//                .email("gordie@gmail.com")
//                .password("123456Aa!")
//                .build();

        app.getUserHelper().loginUserDtoLombok(userDP);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test(dataProvider = "negativePasswordDataLogin", dataProviderClass = DataProviderLogin.class)
    public void negativePasswordWithoutNumbers(UserDtoLombok userDP) {
//        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
//                .email("gordie@gmail.com")
//                .password("refagawAa!")
//                .build();

        app.getUserHelper().loginUserDtoLombok(userDP);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }

    @Test
    public void negativePasswordWithoutLetters() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("gordie@gmail.com")
                .password("12345678!")
                .build();

        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }

    @Test (priority = 1)
    public void negativePasswordWithoutSymbol() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aaa")
                .build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }
}
