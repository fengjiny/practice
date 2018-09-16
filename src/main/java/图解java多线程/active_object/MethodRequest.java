package 图解java多线程.active_object;


public abstract class MethodRequest<T> {
    protected final Servant servant;
    protected final FutureResult<T> future;
    protected MethodRequest(Servant servant, FutureResult<T> future) {
        this.servant = servant;
        this.future = future;
    }
    public abstract void execute();
}
