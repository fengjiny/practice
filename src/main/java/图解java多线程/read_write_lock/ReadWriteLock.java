package 图解java多线程.read_write_lock;

public final class ReadWriteLock {
    private int readingReaders = 0;         //实际正在读取中的线程个数
    private int waitingWriters = 0;         //正在等待写入的线程个数
    private int writingWriters = 0;         //实际正在写入中的线程个数
    private boolean preferWriter = true;    //若优先写入，则为true

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }
    public synchronized void readUnlock() {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }
}
