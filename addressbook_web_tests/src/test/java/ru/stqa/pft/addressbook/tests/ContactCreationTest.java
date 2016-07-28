package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/helena.jpg");
        list.add(new Object[] {new ContactData().withFirstname("Daria").withLastname("Churkina")
                .withPhone("123").withEmail("daria@gmail.com").withGroup("Test1").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstname("Maria").withLastname("Turkina")
                .withPhone("456").withEmail("maria@gmail.com").withGroup("Test1").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withFirstname("Antonina").withLastname("Chekhova")
                .withPhone("789").withEmail("antonina@gmail.com").withGroup("Test1").withPhoto(photo)});
        return list.iterator();
    }


    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goToHomePage();
        Contacts before = app.contact().all();
        app.goTo().addNewPage();
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