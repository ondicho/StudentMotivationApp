import dao.Sql2oAdminDao;
import dao.Sql2oUserDao;
import models.user;
import models.Admin;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import com.google.gson.Gson;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oUserDao userDao;
        Sql2oAdminDao adminDao;
        Gson gson = new Gson();
        Connection conn;

        userDao=new Sql2oUserDao(sql2o);
        adminDao=new Sql2oAdminDao(sql2o);
        conn = sql2o.open();
    }
}
