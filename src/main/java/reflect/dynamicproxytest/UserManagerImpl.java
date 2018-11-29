package reflect.dynamicproxytest;

public class UserManagerImpl implements UserManager {
    @Override
    public void add(String userName, String password) {
        System.out.println("add(), userName: " + userName + ", password: " + password);
    }

    @Override
    public final void delete(String userName) {
        System.out.println("delete(), userName: " + userName);
    }
}
