package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegisterPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
