package book.图解java多线程.example.active_object;

public class MakeStringRequest extends MethodRequest<String> {
    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult<String> future,
                             int count, char fillChar) {
        super(servant, future);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {
        Result<String> result = servant.makeString(count, fillChar);
        future.setResult(result);
    }
}
