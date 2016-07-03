package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {
    
    @Test
    public void testContactCreation() {

        app.goToHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().goToAddNewPage();
        app.getContactHelper().fillContactData(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1"), true);
        app.getContactHelper().submitNewContact();
        app.goToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before +1);
    }
}
