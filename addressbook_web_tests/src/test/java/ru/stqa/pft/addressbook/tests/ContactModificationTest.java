package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test

    public void testContactModification() {
        app.goToHomePage();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddNewPage();
            app.getContactHelper().createContact(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1"));
            app.goToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(new ContactData("Maria", "Churkina", "789", "daria.churkina@inbox.ru", null), false);
        app.getContactHelper().submitContactModification();
        app.goToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
