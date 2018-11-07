package test.javatezhongbing.multithread;

public class NoVisiabilityTest {
    private static class ReadThread extends Thread {
        private boolean ready;
        private int number;

        public void run() {
            while (!ready) {
                number++;
                Thread.yield();
            }
            System.out.println(number);
        }

        public void readOn() {
            this.ready = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread readThread = new ReadThread();
        readThread.start();
        Thread.sleep(200);
        readThread.readOn();
        System.out.println(readThread.ready);
    }
}
