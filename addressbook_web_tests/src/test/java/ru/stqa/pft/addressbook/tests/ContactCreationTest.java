package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {
    
    @Test
    public void testContactCreation() {

        app.goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToAddNewPage();
        ContactData contact = new ContactData("Daria", "Churkina", "123", "daria.churkina@inbox.ru", "Test1");
        app.getContactHelper().fillContactData(contact, true);
        app.getContactHelper().submitNewContact();
        app.goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() +1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
