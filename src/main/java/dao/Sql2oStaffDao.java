package dao;

import models.Category;
import models.Motivation;
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
    public void add(Motivation motivation) {
        String sql = "INSERT INTO motivation (content,userId) VALUES (:content,:userId)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(motivation)
                    .executeUpdate()
                    .getKey();
            motivation.setId(id);
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
    public List<Motivation> getAllMotivation() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM motivation")
                    .executeAndFetch(Motivation.class);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM categories")
                    .executeAndFetch(Category.class);
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
    public void deleteMotivationByUserId(user user, Motivation motivation) {
        String sql = "DELETE FROM  motivation WHERE userId=:userId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("userId", user.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void add(Category category) {
        String sql = "INSERT INTO categories (categoryName, categoryDescription ) VALUES (:categoryName, :categoryDescription)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(category)
                    .executeUpdate()
                    .getKey();
            category.setId(id);
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
