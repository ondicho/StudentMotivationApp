package models;

import java.util.Objects;

public class Motivation {
    private int id;
    private String content;
    private int userId;

    public Motivation(String Content,int userId){
        this.content=content;
        this.userId=userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motivation that = (Motivation) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, userId);
    }
}
