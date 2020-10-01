//package dao;
//
//import junit.framework.TestCase;
//
//import models.Users;
//import org.junit.*;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//
//import static org.junit.Assert.*;
//
//public class Sql2oUsersDaoTest {
//    private static Sql2oUsersDao usersDao;
//    private static Connection connection;
//
//    @BeforeClass
//    public static void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/motivational_test";
//        Sql2o sql2o = new Sql2o(connectionString, "makena", "barbie");
//        usersDao = new Sql2oUsersDao(sql2o);
//        connection = sql2o.open();
//    }
//
//
//
//    @AfterClass
//    public static void shutDown(){
//        System.out.println("SHUTTING DOWN DATABASE!");
//        connection.close();
//    }
//
//    @Test
//    public void save_savesUserInformationInTheDatabase() throws Exception {
//        Users users = setUpUser();
//        usersDao.save(users);
//        assertEquals(1, usersDao.getAll().size());
//    }
//
//    @Test
//    public void findAll_ReturnsAllUsers() {
//        Users users = setUpUser();
//        assertEquals(0, usersDao.getAll().size());
//        usersDao.save(users);
//        assertEquals(1, usersDao.getAll().size());
//    }
//    @Test
//    public void findById_returnsExistingUsersBasedOnId() {
//        Users users = setUpUser();
//        usersDao.save(users);
//        Users users1 = usersDao.findById(users.getId());
//        assertEquals(users, users1);
//    }
//    @Test
//    public void delete_deletesUserById(){
//        Users users = setUpUser();
//        usersDao.save(users);
//        assertEquals(1, usersDao.getAll().size());
//        int idOfFoundUser = usersDao.findById(users.getId()).getId();
//        usersDao.deleteById(idOfFoundUser);
//        assertEquals(0, usersDao.getAll().size());
//    }
//    @Test
//    public void clearAll_DeletesEverything(){
//        Users users = setUpUser();
//        usersDao.save(users);
//        Users users1 = setUpUser();
//        usersDao.save(users1);
//        Users users2 = setUpUser();
//        usersDao.save(users2);
//        assertEquals(3, usersDao.getAll().size());
//        usersDao.clearAll();
//        assertEquals(0, usersDao.getAll().size());
//    }
//
//
//    //helpers
//    public Users setUpUser(){
//        return new Users("Trevor",20, 2, "trevor@mail.com","male");
//    }
//
//}
//
//
//
