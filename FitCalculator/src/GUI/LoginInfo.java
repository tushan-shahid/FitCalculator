package GUI;

import java.util.HashMap;

//this class stores user id and password in Hashmap
public class LoginInfo {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    LoginInfo(){
        loginInfo.put("admin" , "admin");
        loginInfo.put("admin1" , "admin1");
        loginInfo.put("admin2" , "admin2");
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
