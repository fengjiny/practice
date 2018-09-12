package 图解java多线程;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class test {

    class Counter {
        private int count = 0;

        public void increase() {
            ++count;
        }
        public int getCount() {
            return count;
        }
    }
}
