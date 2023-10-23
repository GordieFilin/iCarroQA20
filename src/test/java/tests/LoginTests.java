package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {


    @BeforeMethod
    public void preconditionsLogin() {
        //  app.navigateToMainPage();
        logoutIfLogin();

        // user login
        // user open web not login
    }

    @AfterMethod
    public void postConditionsLogin() {
        app.getUserHelper().clickOkPopUpSuccessLogin();
    }

    @Test
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

    @Test
    public void positiveLogin() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("gordie@gmail.com")
                .password("123456Aa!")
                .build();

        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }

    @Test
    public void negativePasswordWithoutNumbers() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("gordie@gmail.com")
                .password("refagawAa!")
                .build();

        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
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

    @Test
    public void negativePasswordWithoutSymbol() {
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("testqa20@gmail.com")
                .password("123456Aaa")
                .build();
        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageLoginIncorrect());
    }
}
