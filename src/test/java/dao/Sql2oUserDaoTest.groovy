package dao

import models.user;
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.sql2o.Sql2o

class Sql2oUserDaoTest {

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingUserSetsId() throws Exception {
        user testUser = setupUser();
        assert(1), testUser.getId();
    }

    @Test
    public void getAll() throws Exception {
        user user1 = setupUser();
        user user2 = setupUser();
        assert(2), userDao.getAll().size();
    }

    @Test
    public void deleteById() throws Exception {
        user testUser = setupUser();
        user otherUser = setupUser();
        assertEquals(2, userDao.getAll().size());
        userDao.deleteById(testUser.getId());
        assert(1), userDao.getAll().size();
    }

    @Test
    public void clearAll() throws Exception {
        models.user testUser = setupUser();
        user otheruser = setupUser();
        userDao.clearAll();
        assert(0), userDao.getAll().size();
    }

}
