package dao;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements UsersDao{
    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void save(Users users){
        String sql = "INSERT INTO users (id, name, email, age, gender) VALUES (:id, :name, :email, :age, :gender)";
        try (Connection connection = sql2o.open()) {
            int id = (int)connection.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex) { System.out.println("Failed to add person to database"); }
    }

      @Override
    public List<Users> getAll(){
        String sql = "SELECT * FROM users";
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .executeAndFetch(Users.class);
        }
    }
    @Override
    public Users findById(int id){
        String sql = "SELECT * FROM users WHERE id = :id";
        try(Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        }
    }



    @Override
    public void deleteById(int id){
        String sql = "DELETE FROM users WHERE id = :id";
        try (Connection connection = sql2o.open()){
            connection.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {System.out.println("Unable to delete user"); }
    }
    @Override
    public void clearAll(){
        String sql = "DELETE FROM users";
        try (Connection connection = sql2o.open()){
            connection.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){ System.out.println("Unable to delete all users");}
    }
}
