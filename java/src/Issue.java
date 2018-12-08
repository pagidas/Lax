import java.util.Date;

public class Issue extends Message {

    public Issue(String aContent, Date aDate) {
        super(aContent, aDate);
    }

    @Override
    String getContent() {
        return content;
    }

    @Override
    Date getDate() {
        return date;
    }

    @Override
    void setContent(String aContent) {
        content = aContent;
    }
}
