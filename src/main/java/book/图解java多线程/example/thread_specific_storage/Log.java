package book.图解java多线程.example.thread_specific_storage;

public class Log {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    //写日志
    public static void println(String s) {
        getTSLog().println(s);
    }
    //关闭日志
    public static void close() {
        getTSLog().close();
    }

    //获取线程特有的日志
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }

}
