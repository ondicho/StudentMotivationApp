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
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[]args){
        port(getHerokuAssignedPort());
        Sql2oUsersDao usersDao;
        Connection connection;
        Gson gson = new Gson();
//        String connectionString = "jdbc:postgresql://localhost:5432/motivation";
//        Sql2o sql2o = new Sql2o(connectionString, "makena", "barbie");

        String connectionString = "jdbc:postgresql://ec2-3-226-231-4.compute-1.amazonaws.com:5432/d81o3b822e58ua"; //!
        Sql2o sql2o = new Sql2o(connectionString, "vqmvlgmcjnmuwt", "4c7c2c19e3cc50b47044037ae819eaf2eda151282b31557363ff352f62842f5f"); //!
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
