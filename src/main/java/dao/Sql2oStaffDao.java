package dao;

import models.user;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oStaffDao implements userDao,StaffDao{

    private final Sql2o sql2o;
    public Sql2oStaffDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(user user) {
        String sql = "INSERT INTO users (name, age, email,department,phoneNumber,role) VALUES (:name, :age, :email,:department,:phoneNumber,:role)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
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
    public user findById(int id) {
        try (Connection con=sql2o.open()) {
            return con.createQuery("SELECT FROM users WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(user.class);
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
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
