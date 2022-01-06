package GUI;

public class Main {
    public static void main(String[] args) {

        //Initiating login page

        LoginInfo idAndPassword = new LoginInfo();

        LoginPage loginPage = new LoginPage(idAndPassword.getLoginInfo());
        System.out.println(idAndPassword.getLoginInfo());

    }
}
