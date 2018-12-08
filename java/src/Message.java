import java.util.Date;

public abstract class Message {

    String content;
    Date date;

    //parameterized constructor
    Message(String aContent, Date aDate) {
        content = aContent;
        date = aDate;
    }

    //getters
    abstract String getContent();
    abstract Date getDate();

    //setter
    abstract void setContent(String aContent);
}
