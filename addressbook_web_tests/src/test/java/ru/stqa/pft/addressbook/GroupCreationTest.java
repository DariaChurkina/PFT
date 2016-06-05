package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        startGroupCreation();
        fillGroupForm(new GroupData("Test1", "test2", "test3"));
        submitNewGroup();
        returntoGroupPage();
    }

}
