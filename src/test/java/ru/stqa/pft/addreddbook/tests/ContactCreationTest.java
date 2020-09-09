package ru.stqa.pft.addreddbook.tests;

import org.junit.Assert;
import org.junit.Test;

import ru.stqa.pft.addreddbook.model.ContactData;

import java.io.File;


public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreate() {
        int before = app.contact().getContactCount();
        app.goTo().contactPage("ADD_NEW");
        File photo = new File("D:/Java_testing/Tests/src/test/resources/test.png");
        app.contact().fillContactForm(
                new ContactData()
                        .withFirstname("new test").withLastname("test").withMiddlename("test")
                        .withPhone_home("123").withPhone_mobile("6564035").withPhone_work("999").withPhoto(photo));
        app.contact().submitContactCreation("submit");
        app.goTo().homePage("home page");
        int after = app.contact().getContactCount();
        Assert.assertEquals(after,before + 1);
        // app.getGroupHelper().returnToGroupPage("group page");
        // app.logout("LOGOUT");*/

    }

    /*@Test   //проверяли, существует ли файл в директории и в какой директории
    public  void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("D:/Java_testing/Tests/src/test/resources/test.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }*/

}

