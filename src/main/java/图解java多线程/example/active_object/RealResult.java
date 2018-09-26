package 图解java多线程.example.active_object;

public class RealResult<T> extends Result {
    private final T resultValue;
    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }
}
