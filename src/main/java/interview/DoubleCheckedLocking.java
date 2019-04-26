package interview;

public class DoubleCheckedLocking {
    private volatile static Instance instance;
    public static Instance getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckedLocking.class) {
                if (instance == null)
                    instance = new Instance();
            }
        }
        return instance;
    }


}

class Instance{

}
