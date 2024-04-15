package v4_prog_pt1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Login {
    static String myPassword = App.userPassword;
    static String myUsername = App.userName;

    /*
    public static boolean checkUserName(String user) {
        user = myUsername;
        // Testing Length of Username as well as if it contains and underscore
        if (user.length() < 5 && user.contains("_")) {
            return true;
        } else {
            registerUser_Name();
            return false;
           
        }

    }*/
    public static boolean checkUserName(String user) {
        boolean hasUnder = false,meetsLength = false;
        user = myUsername;
        Pattern sPattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher sMatcher = sPattern.matcher(user);
        char c;

        for (int i = 0; i < user.length(); i++) {
            c = user.charAt(i); 

            if (!sMatcher.matches()) {
                hasUnder = true;
            } else {
                // Checking length
                if (!(user.length() <= 4)) {
                    meetsLength = true;
                }
            }

        }
        registerUser_Name();
        return false;
    }

    public static boolean checkPasswordComplexity(String password) {
        // checking for number,Capital letter and Lowercase
        // password = App.userPassword;
        password = myPassword;
        boolean hasNum = false, hasCap = false, hasSpecial = false, meetsLength = false;
        char c; // used to check every character in string as we loop through

        // checking for special characters
        Pattern sPattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher sMatcher = sPattern.matcher(password);

        for (int i = 0; i < password.length(); i++) { // looping through each character
            c = password.charAt(i); // start of each loop c is assigned to new character being looked at

            // checking for a number
            if (Character.isDigit(c)) {
                hasNum = true;
            } else {
                // checking for an Uppercase
                if (Character.isUpperCase(c)) {
                    hasCap = true;
                } else {

                    if (!sMatcher.matches()) {
                        hasSpecial = true;
                    } else {
                        // Checking length
                        if (!(password.length() <= 7)) {
                            meetsLength = true;
                        }
                    }

                }
            }
            // if all four requirements met
            if (!(hasNum && hasCap && hasSpecial && meetsLength)) {
                registerUser_Password();
                return false;

            } else {
                JOptionPane.showMessageDialog(null, "You have been successfully registered");
                return true;
            }

        }
        return false; // if all loops dont return a true,means password didnt meet requirement thus
        // returns false

    }

    public static Boolean registerUser_Name() {

        JOptionPane.showMessageDialog(null,
                "Username is not correctly formatted,please ensure that your username contains" + "\n" +
                        "an underscore and " + "\n" + "is no more than 5 characters in length");
        return false;

    }

    public static Boolean registerUser_Password() {

        JOptionPane.showMessageDialog(null,
                "Password is not correctly formatted,please ensure that the password contains: " + "\n"
                        + "- At least 8 characters" + "\n" +
                        "- A capital letter" + "\n" +
                        "- A number" + "\n" +
                        "-A special character");
        return false;

    }

    public static Boolean registerUser_SuccessUsername() {
        if (registerUser_Name()) {
            JOptionPane.showMessageDialog(null,
                    "Username successfully captured");
            return true;
        }
        return false;

    }

    public static Boolean registerUser_SuccessPassword() {
        if (registerUser_Password()) {
            JOptionPane.showMessageDialog(null,
                    "password successfully captured");
            return true;
        }return false;
    }

    public static Boolean registerUser_Success() {
        if (registerUser_Name() && registerUser_Password()) {
            JOptionPane.showMessageDialog(null,
                    "Successfuly Login");
            return true;
        }
        return false;

    }

    public static Boolean loginUser(String username, String Password) {
        username = App.userName;
        Password = App.userPassword;

        if (username.equals(myUsername) && Password.equals(myPassword)) {
            return true;
        }
        return false;
    }

    public static String returnLoginStatus() {
        if (loginUser(myUsername, myPassword) == true) {
            JOptionPane.showMessageDialog(null,
                    "Welcome" + ",it is great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Username or Password incorrect, please try again");
        }
        return myUsername;
    }
}
