package files;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class myFile {

    private static final DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    private static final File adminCredentials = new File("java/src/files/admin.xml");
    private static Scanner reader;


    public static String readXMLAdminUname() {
        String username = null;
        try{
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document document = docBuilder.parse(adminCredentials);

            username = document.getElementsByTagName("username").item(0).getTextContent();
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            ex.printStackTrace();
        }

        return username;
    }

    public static String readXMLAdminPwd() {
        String password = null;
        try{
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document document = docBuilder.parse(adminCredentials);

            password = document.getElementsByTagName("username").item(0).getTextContent();
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            ex.printStackTrace();
        }

        return password;
    }
}
