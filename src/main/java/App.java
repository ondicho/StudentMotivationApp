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

        String connectionString = "jdbc:postgresql://localhost:5432/student_motivation_app";
        Sql2o sql2o = new Sql2o(connectionString, "ondicho", "1234");
        userDao=new Sql2oUserDao(sql2o);
        adminDao=new Sql2oAdminDao(sql2o);
        conn = sql2o.open();

        //user
        post("/users/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
            user user= gson.fromJson(req.body(), user.class);//make java from JSON with GSON
            userDao.add(user);//Do our thing with our DAO
            res.status(201);//A-OK! But why 201??
            return gson.toJson(user);//send it back to be displayed
        });

        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(userDao.getAll());//send it back to be displayed
        });

//        get("/users/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            res.type("application/json");
//            int id= Integer.parseInt(req.params("id"));
//            res.type("application/json");
//            return gson.toJson(userDao.findById(id));
//        });

//        post("/admin/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            Admin admin= gson.fromJson(req.body(), Admin.class);//make java from JSON with GSON
//            adminDao.add(user);//Do our thing with our DAO
//            res.status(201);//A-OK! But why 201??
//            return gson.toJson(admin);//send it back to be displayed
//        });
//
//        get("/users", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            return gson.toJson(userDao.getAll());//send it back to be displayed
//        });

    }
}
