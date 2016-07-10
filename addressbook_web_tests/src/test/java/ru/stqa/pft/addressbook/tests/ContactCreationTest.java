package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        app.goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.goTo().goToAddNewPage();
        ContactData contact = new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1");
        app.getContactHelper().fillContactData(contact, true);
        app.getContactHelper().submitNewContact();
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
