package dao;

import models.user;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAdminDao implements AdminDao {
    private final Sql2o sql2o;
    public Sql2oAdminDao(Sql2o sql2o) { this.sql2o = sql2o; }


    @Override
    public void add(user user) {
        String sql = "INSERT INTO users (name, age, id, gender) VALUES (:name, :age, :id, :gender)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println("error while adding new person");
        }
    }

    @Override
    public List<user> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(user.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println("error while deleting person");
        }
    }


}


