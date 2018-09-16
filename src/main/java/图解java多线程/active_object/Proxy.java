package 图解java多线程.active_object;

public class Proxy implements ActiveObject {
    private final SchedulerThread scheduler;
    private final Servant servant;
    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public Result<String> makeString(int count, char fillChar) {
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(new MakeStringRequest(servant, future, count, fillChar));
        return future;
    }

    @Override
    public void disPlayString(String string) {
        scheduler.invoke(new DisplayStringRequest(servant, string));
    }
}
