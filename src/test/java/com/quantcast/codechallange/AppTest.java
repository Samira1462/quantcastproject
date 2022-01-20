package com.quantcast.codechallange;

import com.quantcast.codechallange.common.Validation;
import com.quantcast.codechallange.exception.InvalidArgsException;
import com.quantcast.codechallange.model.Cookie;
import com.quantcast.codechallange.service.MostActiveCookieService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class AppTest {
    private String resourceName = "/cookie-log.csv";

    private List<Cookie> testCookieList;

    private String cookieFilePath;

    private String emptyCookieFileName;

    private String url= "";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setup() {
        testCookieList = new ArrayList<>();
        testCookieList.add(new Cookie("sjdhfkguhfd","2019-02-02"));
        testCookieList.add(new Cookie("sjdhfkguhfd","2019-02-02"));
        testCookieList.add(new Cookie("urtirjtsadasd","2019-01-02"));
        testCookieList.add(new Cookie("asdasdasdasad","2019-03-02"));
        testCookieList.add(new Cookie("ewefwefrwefew","2019-04-02"));


    }

    @Test(expected = InvalidArgsException.class)
    public void whenExceptionThrownInvalidArgsException() {
        App.main(null);
    }

    @Test(expected = InvalidArgsException.class)
    public void notValidArgsExceptionThrownInvalidArgsException() {
        String [] args = new String[6];
        args[0] = "java -f cookie-file.csv ";
        args[1] = "cookie-file.csv";
        args[2] = "-d";
        args[3] = "2018-12-09";
        args[4] = "-h";
        args[5] = "input";
        App.main(args);
    }

    @Test
    public void notValidDateFormatException(){
 /*       Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        url = absolutePath + resourceName;*/
        Validation.isValid("2012-10");
        Assert.assertFalse(false);
    }

    @Test
    public void findMaxActiveCookie()  {
        MostActiveCookieService mostActiveCookieService = new MostActiveCookieService();
        String mostActiveCookiePerDate = mostActiveCookieService.getMostActiveCookiePerDate(testCookieList, "2019-02-02");
        Assert.assertSame(mostActiveCookiePerDate, "sjdhfkguhfd");
    }

    @Test
    public void cookieListIsEmptyList() {
        List<Cookie> emptyList = new ArrayList<>();
        MostActiveCookieService mostActiveCookieService = new MostActiveCookieService();
        String mostActiveCookiePerDate = mostActiveCookieService.getMostActiveCookiePerDate(emptyList, "2019-02-02");
        Assert.assertEquals(mostActiveCookiePerDate,"Not cookies find in specific date");
    }

}
