package Queue;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue Queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个指令");
        //输出一个菜单
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("p(peet)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    Queue.addqueue(i);
                    break;
                case 's':
                    Queue.show();
                    break;
                case 'g':
                    try {
                        int val = Queue.getqueue();//*
                        System.out.printf("取出的数据是：%d\n", val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());//*
                    }
                    break;
                case 'p':
                    try {
                        int val = Queue.peek();//*
                        System.out.printf("队头的数据是：%d\n", val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }



        }

        System.out.println("程序退出");
    }

    }
//使用数组模拟队列——编写一个ArrayQueue类
    //最大容量，队头队尾，数组存数据
class ArrayQueue {
        private int MaxSize;//最大容量
        private int front;//队头
        private int rear;//队尾
        private int[] arr;//存放数据
    //创建队列的构造器
        public ArrayQueue(int ArrMaxSize){
            MaxSize = ArrMaxSize;
            arr = new int[MaxSize];
            front = -1;//指向队列头
            rear = -1;//指向队列尾
        }
    //判断队列是否满
    public boolean isfull(){
            return rear == MaxSize-1;
    }
    //判断队列是否空
    public boolean isempty(){
            return front == rear;
    }
    //添加数据到队列
    public void addqueue(int i){
            if(isfull()){
                System.out.println("该队列已满");
                return;
            }
            rear ++;
             arr[rear] = i;
    }
    //获取队列的数据，出队列
    public int getqueue(){
            if(isempty()){
                throw new RuntimeException("该队列为空");
            }
            front++;
            return arr[front];
    }

    //显示队列所有数据
        public void show(){
            if(isempty()){
                System.out.println("该队列已满");
                return ;
            }
            for(int i = 0;i<arr.length;i++){
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        public int peek(){
            if(isempty()){
                throw new RuntimeException("该队列为空");
            }
            return arr[front];
        }



}











