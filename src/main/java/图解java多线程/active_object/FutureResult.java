package 图解java多线程.active_object;

public class FutureResult<T> extends Result {
    private Result<T> result;
    private boolean ready = false;
    public synchronized void setResult(Result<T> result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized T getResultValue() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return result.getResultValue();
    }
}
