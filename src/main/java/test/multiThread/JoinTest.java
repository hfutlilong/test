package test.multiThread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread other = new Thread(new OtherThread(), "other");
        other.start();
        other.join();
        System.out.println("其他线程结束了，开始执行我的");
    }

    static class OtherThread implements Runnable {
        @Override
        public void run() {
            System.out.println("a");
            System.out.println("b");
            System.out.println("c");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
