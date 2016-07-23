package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckWholeContactTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goToHomePage();
        if (app.contact().all().size() == 0) {
            app.goTo().addNewPage();
            app.contact().create(new ContactData()
                    .withFirstname("Daria").withLastname("Churkina").withPhone("123").withEmail("daria.churkina@inbox.ru")
                    .withAddress("Moscow, Esenina Str.28"));
            app.goToHomePage();
        }
    }

    @Test
    public void testWholeContactCheck() {
        app.goToHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
        ContactData contactInfoFromEditPage = app.contact().infoFromEditForm(contact);
        assertThat(cleaned(mergeContactDetails(contactInfoFromEditPage)), equalTo(contactInfoFromDetailsPage.getContactDetails()));
    }


    private String mergeContactDetails(ContactData contact) {
        String homePhone = "";
        String mobile = "";
        String work = "";
        if(!contact.getHomePhone().equals("")){
            homePhone = "H: " + contact.getHomePhone();
        }
        if (!contact.getMobilePhone().equals("")){
            mobile = "M: " + contact.getMobilePhone();
        }
        if (!contact.getWorkPhone().equals("")){
            work = "W: " + contact.getWorkPhone();
        }
        return  Arrays.asList(contact.getFirstname() + " " + contact.getLastname(), contact.getAddress() + "\n", homePhone,
                mobile, work,  "\n" + contact.getEmail()).stream().filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String details){
        return details.replace("www.inbox.ru", "");
    }
}