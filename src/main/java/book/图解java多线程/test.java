package book.图解java多线程;

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
