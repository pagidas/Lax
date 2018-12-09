import java.util.Date;

public class Issue {

    private int id;
    private Date date;
    private String content;

    public Issue(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    //getters
    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
