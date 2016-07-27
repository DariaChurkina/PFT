package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {

        app.goToHomePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/helena.jpg");
        app.goTo().addNewPage();
        ContactData contact = new ContactData().withFirstname("Daria")
                .withLastname("Churkina").withPhone("123").withEmail("daria.churkina@inbox.ru").withGroup("Test1").withPhoto(photo);
        app.contact().submit(contact);
        app.contact().goToHomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    /*@Test (тест на проверку абсолютного адреса фото)
    public void testCurrentdir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/helena.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }*/
}