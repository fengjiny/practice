package 图解java多线程.active_object;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillChar);
    public abstract void disPlayString(String string);
}
