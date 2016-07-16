package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        app.goToHomePage();
        Contacts before = app.contact().all();
        app.goTo().addNewPage();
        ContactData contact = new ContactData().withFirstname("Daria")
                .withLastname("Churkina").withPhone("123").withEmail("daria.churkina@inbox.ru").withGroup("Test1");
        app.contact().submit(contact);
        app.contact().goToHomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}