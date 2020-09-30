package models;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
public class AdminTest {
    @Test
    public void AdminTest_getCorrectName_String() {
        Admin admin = new Admin("Jean", 1, "admin@mail.com");
        assertEquals("Jean", admin.getName());
    }

    @Test
    public void AdminTest_getCorrectId_int() {
        Admin admin = new Admin("Jean",1,"admin@mail.com");
        assertEquals(1, admin.getId());
    }

    @Test
    public void AdminTest_getCorrectEmail_String() {
        Admin admin = new Admin("Jean",1,"admin@mail.com");
        assertEquals("admin@mail.com", admin.getEmail());
    }

}