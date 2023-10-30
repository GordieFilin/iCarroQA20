package data;

import dto.UserDtoLombok;
import manager.BaseHelper;
import org.testng.annotations.DataProvider;
import tests.BaseTest;
import utils.RandomUtils;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderReg {
    RandomUtils randomUtils = new RandomUtils();
    @DataProvider
    public Iterator<Object[]> positiveDataReg() {
        List<Object[]> list = new ArrayList<>();
        String email = randomUtils.generateEmail(7);
        list.add(new Object[]{
                UserDtoLombok.builder()
                        .email(email)
                        .password("123456Aa!")
                        .name("abc")
                        .lastname("test")
                        .build()
        });
        return list.iterator();
    }
}
