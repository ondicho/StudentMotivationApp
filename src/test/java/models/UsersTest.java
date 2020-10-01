//package models;
//
//import junit.framework.TestCase;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class UsersTest  {
//    @Test
//    public void getCorrectName_String() {
//        Users users = new Users("Trevor", 20, 1, "trevor@mail.com","male");
//        assertEquals("Trevor", users.getName());
//    }
//
//    @Test
//    public void getCorrectAge_Int() {
//        Users users = new Users("Trevor", 20, 1, "trevor@mail.com","male");
//        assertEquals(20, users.getAge());
//    }
//
//    @Test
//    public void getCorrectEmail_String() {
//        Users users = new Users("Trevor", 20, 1, "trevor@mail.com","male");
//        assertEquals("trevor@mail.com", users.getEmail());
//    }
//
//    @Test
//    public void getCorrectGender_String() {
//        Users users = new Users("Trevor", 20, 1, "trevor@mail.com","male");
//        assertEquals("male", users.getGender());
//    }
//
//    @Test
//    public void getCorrectId_Int() {
//        Users users = new Users("Trevor", 20, 1, "trevor@mail.com","male");
//        assertEquals(1, users.getId());
//    }
//
//}