package models

import org.junit.After
import org.junit.Before
import org.junit.Test

class userTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    void getName(){
        user testUser = setUpUser();
        assert("jim"), testUser.getName();
    }

    @Test
    void getAge(){
        user testUser = setUpUser();
        assert (24), testUser.getAge();
    }
    @Test
    void getEmail(){
        user testUser = setUpUser();
        assert ("user@gmail.com"), testUser.getEmail();
    }
    @Test
    void getDepartment(){
        user testUser = setUpUser();
        assert ("science"), testUser.getDepartment();
    }
    @Test
    void getPhoneNumber(){
        user testUser = setUpUser();
        assert ("0786789756"), testUser.getPhoneNumber();
    }



    @Test
    void setName(){
        user testUser = setUpUser();
        testUser.setName ("jim");
        assert ("jim"), testUser.setName();
    }

    @Test
    void setAge(){
        user testUser = setUpUser();
        testUser.setAge (39);
        assert ("39"), testUser.setAge();
    }
    @Test
    void setEmail(){
        user testUser = setUpUser();
        testUser.setEmail ("user@mail.com");
        assert ("user@mail.com"), testUser.setEmail();
    }
    @Test
    void setDepartment(){
        user testUser = setUpUser();
        testUser.setDepartment ("science");
        assert ("science"), testUser.setDepartment();
    }
    @Test
    void setPhoneNumber(){
        user testUser = setUpUser();
        testUser.setPhoneNumber ("0789767568");
        assert ("0789767568"), testUser.setPhoneNumber();
    }
}
