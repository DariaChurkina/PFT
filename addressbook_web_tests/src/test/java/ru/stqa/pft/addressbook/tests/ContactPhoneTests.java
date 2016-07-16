package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goToHomePage();
        if (app.contact().all().size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(new ContactData()
                    .withFirstname("Daria").withLastname("Churkina").withPhone("123").withEmail("daria.churkina@inbox.ru").withGroup("Test1"));
            app.goToHomePage();
        }
    }

    @Test
    public void testContactPhones() {
        app.goToHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
