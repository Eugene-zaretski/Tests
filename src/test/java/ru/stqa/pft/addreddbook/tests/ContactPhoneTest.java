package ru.stqa.pft.addreddbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import ru.stqa.pft.addreddbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactPhoneTest extends TestBase{

    @Test
    public void testContactPhones() {   // в данном тесте проверим наличие записанных телефонов путем разрезания строк
      //  int before = app.contact().getContactCount();
        app.goTo().contactPage("ADD_NEW");
        app.contact().fillContactForm(
                new ContactData()
                        .withFirstname("Phone22").withLastname("test_p22").withMiddlename("test_u22")
                        .withPhone_home("221001").withPhone_work("21777"));
        app.contact().submitContactCreation("submit");
        app.goTo().homePage("home page");
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
       // MatcherAssert.assertThat(contact.getPhone_work(), equalTo(contactInfoFromEditForm.getPhone_work()));
        assertThat(contact.getPhone_home(), equalTo(contactInfoFromEditForm.getPhone_home()));
        assertThat(contact.getPhone_mobile(), equalTo(contactInfoFromEditForm.getPhone_mobile()));
        assertThat(contact.getPhone_work(), equalTo(contactInfoFromEditForm.getPhone_work()));
        // int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after,before + 1);
        // app.getGroupHelper().returnToGroupPage("group page");
        // app.logout("LOGOUT");*/
       /* ContactData contact;
        assertThat(contact.getPhone_home(), Matchers.equalTo(fillContactForm.getPhone_home()));
        assertThat(contact.getPhone_mobile(), Matchers.equalTo(cleaned(fillContactForm.getPhone_mobile())));*/
    }
    

    
    @Test
    public void testContactPhones1() {   // в данном тесте проверим наличие записанных телефонов путем обратных проверок, склеиванием известных кусков
      /*  app.goTo().contactPage("ADD_NEW");
        app.contact().fillContactForm(
                new ContactData()
                        .withFirstname("Phone_test").withLastname("test").withMiddlename("test")
                        .withPhone_home("123").withPhone_work("999"));
        app.contact().submitContactCreation("submit");*/
        app.goTo().homePage("home page");
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        /*MatcherAssert.assertThat(contact.getPhone_home(), equalTo(contactInfoFromEditForm.getPhone_home()));
        assertThat(contact.getPhone_home(), equalTo(contactInfoFromEditForm.getPhone_home()));
        assertThat(contact.getPhone_mobile(),equalTo(cleaned(contactInfoFromEditForm.getPhone_mobile())));*/
    }
    
    public String mergePhones(ContactData contact){
        return Arrays.asList(contact.getPhone_home(),contact.getPhone_mobile(),contact.getPhone_work())
                .stream().filter((s) -> ! s.equals("")) // фильтруем строки
                .map(ContactPhoneTest::cleaned)         // применяем функцию очистки
                .collect(Collectors.joining("\n"));  // собираем все в одну строку
    }

    public static String cleaned(String phone){  // метод для отчистки номеров телефонов от символов
        return phone.replaceAll("\\s", "").replaceAll("[-()]", ""); // регулярное выражение для замены замены, игнора символов 
    }





}
