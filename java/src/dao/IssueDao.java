package dao;

import database.MyDB;
import model.Issue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class IssueDao {

    public static boolean insertIssue(Issue issue) {
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO `lax_db`.`issues` (`content`, `user_id`) ")
                .append("VALUES ('"+issue.getContent()+"', '"+issue.getUserId()+"');");

        int affectedRow = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)1);

        if(affectedRow == 1) {
            System.out.println("ISSUE HAS BEEN SUCCESSFULLY INSERTED INTO THE DATABASE");
            return true;
        }

        return false;
    }

    public static Set<Issue> getIssuesByUserID(int user_id) {
        Set<Issue> issuesByUser = new HashSet();
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM `lax_db`.`issues` WHERE user_id="+user_id+";");

        ResultSet result = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)0);

        try {
            while(result.next()) {
                Issue i = extractIssueFromResultSet(result);

                issuesByUser.add(i);
            }

            return issuesByUser;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Set<Issue> getAllIssues() {
        Set<Issue> issues = new HashSet();
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM `lax_db`.`issues`;");

        ResultSet result = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)0);

        try {
            while(result.next()) {
                Issue i = extractIssueFromResultSet(result);

                issues.add(i);
            }

            return issues;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /*
     *  This method fetches data from ResultSet and creates a Issue(object)
     */
    public static Issue extractIssueFromResultSet(ResultSet result) throws SQLException {

        return Issue.createIssue(result.getInt("id"),
                 result.getString("content"),
                 result.getDate("date"),
                 result.getInt("user_id"));
    }
}
