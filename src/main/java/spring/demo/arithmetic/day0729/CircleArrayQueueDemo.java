package spring.demo.arithmetic.day0729;

import java.util.Scanner;

/**
 * @Package: spring.demo.arithmetic.day0729
 * @ClassName: CircleArrayQueueDemo
 * @Description: 数组模拟环形队列
 * @Author: liangxin
 * @CreateDate: 2019/7/29 16:22
 * @UpdateDate: 2019/7/29 16:22
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // 实际有效使用个数为3，约定一个为空
        CircleArray queue = new CircleArray(4);

        char key = ' '; // 接收用户输入的信息
        boolean loop = true;
        while (loop) {
            System.out.println();
            System.out.println("请选择您的操作类型：");
            System.out.println("s ====  显示队列所有数据");
            System.out.println("e ====  退出");
            System.out.println("a ====  往队列添加一个数");
            System.out.println("g ====  取出一个数据");
            System.out.println("h ====  显示头部数据（非取出）");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String input = scanner.nextLine();
                key = input.charAt(0); // 接收第一个字符
            }
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出！");
                    break;
                case 'a':
                    System.out.println("请输入一个数据：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.println("取出的数据是：" + result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    int head = queue.headQueue();
                    System.out.println("取出的头数据是：" + head);
                    break;
                default:
                    break;
            }
        }

    }

}

class CircleArray {

    /**
     * 队列最大容量
     */
    private int maxSize;

    /**
     * 指向队列第一个元素 arr[front] , front 初始值 0
     */
    private int front;

    /**
     * 指向队列最后一个元素 arr[front] , rear 初始值 0
     */
    private int rear;

    /**
     * 存放数据
     */
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // 另外两个变量默认值就是0，不写
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 添加数据
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能加入！");
            return;
        }
        // 直接加入数据
        arr[rear] = n;

        // 将 rear 后移（取模后移）
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出数据
     */
    public int getQueue() {
        if (isEmpty()) {
            System.out.println("无数据");
            throw new RuntimeException("无数据");
        }
        /**
         * 1、先把front对应的值保存到临时变量中
         * 2、front后移一位
         * 3、返回临时值
         * ps: 直接返回 front对应的值的话，没有机会去改变 front 值了
         */
        int tempValue = arr[front];
        front = (front + 1) % maxSize;
        return tempValue;
    }

    /**
     * 显示队列中数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("无数据！");
        }

        for (int i = front; i < front + getSize(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    /**
     * 显示头元素
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("无数据");
//            System.out.println("队列无数据！头部数据为空！");
        }
        return arr[front];
    }

    /**
     * 获取有效数据的个数
     *
     * @return
     */
    private int getSize() {
        return (rear + maxSize - front) % maxSize;
    }


}
