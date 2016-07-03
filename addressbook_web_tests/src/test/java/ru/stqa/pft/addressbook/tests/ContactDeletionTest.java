package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        app.goToHomePage();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddNewPage();
            app.getContactHelper().createContact(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1"));
            app.goToHomePage();
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getAccept(); //Как бороться с незаписывающимися действиями для диалогового окна
        app.goToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before -1);
    }

}
