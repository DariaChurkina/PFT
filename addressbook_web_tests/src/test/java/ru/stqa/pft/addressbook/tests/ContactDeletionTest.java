package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goToHomePage();

        if (!app.getContactHelper().isThereAContact()) {
            app.goTo().goToAddNewPage();
            app.getContactHelper().createContact(new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1"));
            app.goToHomePage();
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getAccept(); //Как бороться с незаписывающимися действиями для диалогового окна
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
