package model;

import java.util.Date;

public class Issue {

    private int id;
    private String content;
    private Date date;
    private int user_id;

    /*
     *  Parameterized constructor when creating a new User and the ID is updated by the Database
     */
    private Issue(String content, Date date, int user_id) {
        setContent(content);
        setDate(date);
        setUser_id(user_id);
    }

    /*
     *  Parameterized constructor when fetching Issue's data from a Database
     */
    private Issue(int id, String content, Date date, int user_id) {
        setId(id);
        setContent(content);
        setDate(date);
        setUser_id(user_id);
    }

    /*
     *  This method is needed to create an object in the back-end,
     *  and the ID is updated when it is inserted into the database.
     */
    public static Issue createIssue(String content, Date date, int user_id) {
        Issue i = new Issue(content, date, user_id);

        return i;
    }

    /*
     *  This method is needed to create an object when fetching
     *  user's info from database, thus the ID.
     */
    public static Issue createIssue(int id, String content, Date date, int user_id) {
        Issue i = new Issue(id, content, date, user_id);

        return i;
    }

    public Issue() {}

    public int getId() { return id; }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public int getUser_id() {
        return user_id;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setDate(Date aDate) { this.date = aDate; }

    private void setId(int id) { this.id = id; }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
