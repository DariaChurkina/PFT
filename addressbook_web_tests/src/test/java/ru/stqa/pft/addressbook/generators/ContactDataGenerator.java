package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file2 = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file2);
    }

    private static void save(List<ContactData> contacts, File file2) throws IOException {
        Writer writer = new FileWriter(file2);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(),
                    contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(),
                    contact.getEmail3(), contact.getAddress()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("firstname %s", i)).
                    withLastname(String.format("lastname %s", i)).withHomePhone(String.format("home %s", i))
                    .withMobilePhone(String.format("mobile %s", i)).withWorkPhone(String.format("work %s", i))
                    .withEmail(String.format("email %s", i)).withEmail2(String.format("email2 %s", i))
                    .withEmail3(String.format("email3 %s", i)).withAddress(String.format("address %s", i)));
        }
        return contacts;
    }
}
