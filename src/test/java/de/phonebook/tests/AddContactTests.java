package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    
    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("manuel@gm.com")
                .setPassword("Manuel1234$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Oliver")
                .setLastname("Kan")
                .setPhone("1234567890")
                .setEmail("kan@gm.com")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyByName("Oliver"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}
