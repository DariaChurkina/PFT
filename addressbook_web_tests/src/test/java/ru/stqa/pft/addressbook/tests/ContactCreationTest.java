package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        app.goToHomePage();
        Set<ContactData> before = app.contact().all();
        app.goTo().addNewPage();
        ContactData contact = new ContactData().withFirstname("Daria")
                .withLastname("Churkina").withPhone("123").withEmail("daria.churkina@inbox.ru").withGroup("Test1");
        app.contact().submit(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}