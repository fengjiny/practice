package book.图解java多线程.example.active_object;

public class DisplayClientThread extends Thread{
    private final ActiveObject activeObject;
    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; ++i) {
                String string = Thread.currentThread().getName() + " " + i;
                activeObject.disPlayString(string);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {

        }
    }
}
