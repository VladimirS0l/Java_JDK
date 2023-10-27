package philosopher;

import java.util.concurrent.CountDownLatch;

/**
 * Есть пять философов (потоки), которые могут либо обедать либо размышлять.
 * Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
 * После каждого приема пищи философ должен размышлять
 * Не должно возникнуть общей блокировки
 * Философы не должны есть больше одного раза подряд
 */
public class Lesson5App {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Philosopher("Phil" + i, 0).start();
        }
    }
}

class Philosopher extends Thread {
    String name;
    boolean status = true;
    int count;

    public Philosopher(String name, int count) {
        this.name = name;
        this.count = count;
    }


    @Override
    public void run() {

        try {
            while (count < 3) {
                if (status) {
                    System.out.println(name + " " + count + ": eat");
                    Thread.sleep(500);
                }
                System.out.println(name + " think");
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
