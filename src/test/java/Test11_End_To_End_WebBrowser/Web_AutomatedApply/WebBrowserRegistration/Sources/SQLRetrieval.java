package Test11_End_To_End_WebBrowser.Web_AutomatedApply.WebBrowserRegistration.Sources;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;

public class SQLRetrieval{
    @Test
    @Parameters({"firstName"})
        public ArrayList<String> SQLCredentials(String firstName) throws SQLException {
            //Setting up SQL connection to Selenium Webdriver:
            String host = "localhost";
            String port = "3306";

            Connection connectionMethod = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/UserCredentials", "root", "King1234!");
            Statement filePath = connectionMethod.createStatement();
            //Execute
            ResultSet setResult = filePath.executeQuery("select * from UserCredentials where firstName = '" + firstName + "'");

            ArrayList<String> userInformation = new ArrayList<>();

            while (setResult.next()) {
                //without .next, you are in "-1" index, with next you are in "0" index.
                //Traverses through each element, without next there is no initiation or going into the Array.
                userInformation.add(setResult.getString("firstName"));
                userInformation.add(setResult.getString("lastName"));
                userInformation.add(setResult.getString("email"));
                userInformation.add(setResult.getString("password"));
            }
            return userInformation; //Returns ArrayList Credentials
        }
}

