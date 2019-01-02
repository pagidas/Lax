package handler;

import dao.IssueDao;
import dao.UserDao;
import model.Issue;

import java.util.Scanner;
import java.util.Set;

public class IssueHandler {

    private static Scanner input;

    public static void postIssue(int userId) {
        input = new Scanner(System.in);
        String content;

        System.out.print("(____WRITE____) > ");
        content = input.nextLine();

        if(IssueDao.insertIssue(Issue.createIssue(content, userId)))
            System.out.println("ISSUE HAS BEEN SUCCESSFULLY INSERTED INTO THE DATABASE");
    }

    public static void showAllIssues() {
        Set<Issue> issues = IssueDao.getAllIssues();

        System.out.println("ID\t\t\tUser\t\t\t\t\t\tIssue");
        for(Issue anIssue : issues) {
            // Taking the Full Name of the User with that Issue userId, and content of that Issue
            System.out.println(anIssue.getId()+"\t\t\t"+getUserFullName(anIssue.getUserId())+"\t\t\t\t"+anIssue.getContent());
        }
    }

    public static void editAnIssue() {
        input = new Scanner(System.in);
        String content;
        int id;

        System.out.print("Update by ID > ");
        try {
            id = Integer.parseInt(input.nextLine());

            System.out.print("Update content > ");
            content = input.nextLine();

            if(IssueDao.updateIssue(id, content))
                System.out.println("ISSUE HAS BEEN SUCCESSFULLY UPDATED");

        } catch (NumberFormatException ex) { ex.printStackTrace(); }
    }

    public static void deleteIssue() {
        input = new Scanner(System.in);
        int id;

        System.out.print("Delete by ID > ");
        id = input.nextInt();

        if(IssueDao.deleteIssue(id))
            System.out.println("ISSUE HAS BEEN SUCCESSFULLY DELETED");
    }

    public static void viewIssuesByUser() {
        Set<Issue> issues;
        input = new Scanner(System.in);
        int id;

        System.out.print("View all issues by USER_ID > ");
        id = input.nextInt();
        if(UserDao.getUser(id).getUserRole().equalsIgnoreCase("MANAGER")) {
            System.out.println("Wrong input!\nMANAGER can't post any Issue!");
            return;
        }

        issues = IssueDao.getIssuesByUserID(id);

        System.out.println("Full Name\t\t\t\tIssues");
        for(Issue anIssue : issues) {
            System.out.println(getUserFullName(id)+"\t\t\t"+anIssue.getContent());
        }
    }

    public static void viewAllUsers() {
        UserHandler.showAllUsers();
    }

    public static String getUserFullName(int userId) {
        return UserDao.getUser(userId).getFullname();
    }
}
