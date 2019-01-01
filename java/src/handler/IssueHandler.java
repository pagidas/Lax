package handler;

import dao.IssueDao;
import model.Issue;

import java.util.Scanner;

public class IssueHandler {

    private static Scanner input;

    public static void postIssue(int userId) {
        input = new Scanner(System.in);
        String content;

        System.out.print("(____WRITE____) > ");
        content = input.nextLine();

        IssueDao.insertIssue(Issue.createIssue(content, userId));
    }

}
