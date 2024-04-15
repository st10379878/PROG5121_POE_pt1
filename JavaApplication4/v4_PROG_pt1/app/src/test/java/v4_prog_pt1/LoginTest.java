package v4_prog_pt1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {
@Test
    public void testCorrectUserName(){
        String userName = "kyl_1";
        String userFirstName = "Kyle";
        String userLastName = "Guess";
        boolean result = Login.checkUserName(userName);
        Assertions.assertEquals( "Welcome" + userFirstName + " " + userLastName + ", it is great to see you",result);
    }
@Test
public void testIncorrectUserName(){
    String userName = "kyle!!!!!!!";
    boolean result = Login.checkUserName(userName);
    Assertions.assertEquals( "Username is not correctly formatted,please ensure that your username contains an underscore and is no more than 5 characters in length",result);

}

@Test
public void testMeetPassComplexity(){
    String userPassword = "Ch&&sec@ke99";
    Boolean result = Login.checkPasswordComplexity(userPassword);
    Assertions.assertEquals("Password successfully captured",result);
}

@Test
public void testDoesNotMeetPassComplexity(){
    String userPassword = "password";
    Boolean result = Login.checkPasswordComplexity(userPassword);
    Assertions.assertEquals("Password is not correctly formatted,please ensure that the password contains at least 8 characters, a capital letter, a number and a special character",result);
}

@Test

public void testSuccessfulLogin(){
    String userName = "Kre_2";
    String userPassword = "Kre&&13san";

    boolean result = Login.loginUser(userName, userPassword);
    Assertions.assertTrue(result);
}

public void testUnsuccessfulLogin(){
    String userName = "Kre_2";
    String userPassword = "Kreesan3";

    boolean result = Login.loginUser(userName, userPassword);
    Assertions.assertFalse(result);
}

}
