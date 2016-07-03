package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {
    
    @Test
    public void testContactCreation() {

        app.goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToAddNewPage();
        app.getContactHelper().fillContactData(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1"), true);
        app.getContactHelper().submitNewContact();
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);
    }
}
