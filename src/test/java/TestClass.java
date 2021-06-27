package test.java;

import main.java.PageEvents.LoginPage;
import main.java.PageObjects.LoginPageElements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseTest{

    @Test
    public void Login_Valid_Email_Valid_Pass()
    {
        LoginPage loginPage= new LoginPage();
        loginPage.EnterEmail("mansoor.ali@fiveriverstech.com");
        loginPage.EnterPassword("Mansoor123");
        impwait(10);
        loginPage.ClickLogin();
    /*
    String Act_title =driver.getTitle();
    String Exp_title="My Courses – MZ Creates";
    System.out.println(Act_title);
    Assert.assertEquals(Act_title, Exp_title );*/

    }
    @Test
    public void Login_InValid_Email_Correct_Pass()
    {
        LoginPage loginPage= new LoginPage();
        loginPage.EnterEmail("mansoor.ali@fiiveriverstech.com");
        loginPage.EnterPassword("Mansoor123");
        impwait(10);
        loginPage.ClickLogin();
        /*
        String Act_title =driver.getTitle();
        String Exp_title="Student Login – MZ Creates";
        System.out.println(Act_title);
        Assert.assertEquals(Act_title, Exp_title );*/


    }
    @Test
    public void Login_Valid_Email_InCorrect_Pass()
    {
        LoginPage loginPage= new LoginPage();
        loginPage.EnterEmail("mansoor.ali@fiveriverstech.com");
        loginPage.EnterPassword("Mansoor1234");
        impwait(10);
        loginPage.ClickLogin();
        String exp_info= "Invalid username or password.";
        String Act_info=loginPage.GetTextInfo();
        System.out.println(Act_info);
        Assert.assertEquals(exp_info,Act_info);
        /*
        String Act_title =driver.getTitle();
        String Exp_title="Student Login – MZ Creates";
        System.out.println(Act_title);
        Assert.assertEquals(Act_title, Exp_title );*/

    }
    @Test
    public void Login_Blank_Email_Blank_Pass()
    {
        LoginPage loginPage= new LoginPage();
        loginPage.EnterEmail("");
        loginPage.EnterPassword("");
        impwait(10);
        loginPage.ClickLogin();

        String Act_title =driver.getTitle();
        String Exp_title="Student Login – MZ Creates";
        System.out.println(Act_title);
        System.out.println(Exp_title);
        Assert.assertEquals(Act_title, Exp_title );


    }

}
