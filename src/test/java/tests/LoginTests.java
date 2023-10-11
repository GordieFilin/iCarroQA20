package tests;

import dto.UserDTO;
import dto.UserDTOWith;
import dto.UserDtoLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

//    @Test
//    public void positiveLoginUserDTO(){
//        UserDTO userDTO = new UserDTO("gordie@gmail.com", "123456Aa!");
//        app.getUserHelper().login(userDTO);
//        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
//    }
//
//    @Test
//    public void positiveLoginUserDTOWith(){
//        UserDTOWith userDTOWith = new UserDTOWith()
//                .withEmail("gordie@gmail.com")
//                .withPassword("123456Aa!");
//        app.getUserHelper().login(userDTOWith);
//        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
//    }

    @Test
    public void positiveLogin(){
        UserDtoLombok userDtoLombok = UserDtoLombok.builder()
                .email("gordie@gmail.com")
                .password("123456Aa!")
                .build();

        app.getUserHelper().loginUserDtoLombok(userDtoLombok);
        Assert.assertTrue(app.getUserHelper().validatePopUpMessageSuccessAfterLogin());
    }
}
