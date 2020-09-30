import com.google.gson.Gson;
import dao.Sql2oUsersDao;
import dao.UsersDao;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import models.*;
import static spark.Spark.*;
import static spark.Spark.post;
import static spark.route.HttpMethod.post;


public class App{
    public static void main(String[]args){
        Sql2oUsersDao usersDao;
        Connection connection;
        Gson gson = new Gson();
        String connectionString = "jdbc:postgresql://localhost:5432/motivation";
        Sql2o sql2o = new Sql2o(connectionString, "makena", "barbie");
        usersDao = new Sql2oUsersDao(sql2o);

        post("/user/new", "application/json", (request, response) -> {
            Users users = gson.fromJson(request.body(), Users.class);
            usersDao.save(users);
            response.status(201);
            return gson.toJson(users);
        });
        get("user/:id","application/json", (request, response) -> {
            int userId = Integer.parseInt(request.params("id"));
            return gson.toJson(usersDao.findById(userId));
        });

        //READ: Display all users
        get("/users", "application/json", (request, response) -> {
            return gson.toJson(usersDao.getAll());
        });
    }
}
