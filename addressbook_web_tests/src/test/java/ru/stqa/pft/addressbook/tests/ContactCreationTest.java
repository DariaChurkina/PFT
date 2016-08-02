package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        File photo = new File("src/test/resources/helena.jpg");
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }


    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goToHomePage();
        Contacts before = app.contact().all();
        app.goTo().addNewPage();
        app.contact().create(contact);
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
