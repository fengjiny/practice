package demo;



import java.io.*;
import java.util.Date;

public class TransientTest {


    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("Mike", "123456");
        System.out.println(userInfo);

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("userinfo.txt"));
            os.writeObject(userInfo);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("userinfo.txt"));
            UserInfo userInfo1 = (UserInfo) is.readObject();
            System.out.println(userInfo1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class UserInfo implements Serializable{
    private String name;
    private transient String password;
    private Date registerTime = new Date();

    public UserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        String pwd = password == null ? "not set" : password;
        return "UserInfo: \nname : " + name + "\npassword : " + pwd + "\nloginDate : " + registerTime;
    }
}
