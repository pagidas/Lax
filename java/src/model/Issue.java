package model;

import java.util.Date;

public class Issue {

    private int id;
    private String content;
    private Date date;
    private int userId;

    /*
     *  Parameterized constructor when creating a new Issue and the ID and Date is updated by the Database
     */
    private Issue(String content, int userId) {
        setContent(content);
        setDate(date);
        setUserId(userId);
    }

    /*
     *  Parameterized constructor when fetching Issue's data from a Database
     */
    private Issue(int id, String content, Date date, int userId) {
        setId(id);
        setContent(content);
        setDate(date);
        setUserId(userId);
    }

    /*
     *  This method is needed to create an object in the back-end,
     *  and the ID and Date is updated when it is inserted into the database.
     */
    public static Issue createIssue(String content, int userId) {
        Issue i = new Issue(content,  userId);

        return i;
    }

    /*
     *  This method is needed to create an object when fetching
     *  issue's info from database, thus the ID.
     */
    public static Issue createIssue(int id, String content, Date date, int userId) {
        Issue i = new Issue(id, content, date, userId);

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

    public int getUserId() {
        return userId;
    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setDate(Date aDate) { this.date = aDate; }

    private void setId(int id) { this.id = id; }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
