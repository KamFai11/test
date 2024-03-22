package stack;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        //创建一个扫描仪
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show" :
                    arrayStack.show();
                    break;
                case "exit" :
                    scanner.close();
                    flag = false;
                    break;
                case "push" :
                    System.out.println("请输入要入栈的数据：");
                    int v = scanner.nextInt();
                    arrayStack.push(v);
                    break;
                case "pop" :
                    try{
                        int a = arrayStack.pop();
                        System.out.printf("出栈的数据为：%d",a);
                        break;
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                }
                default :
                    System.out.println("输入的选项有误！");
                    break;
            }
        }
        System.out.println("程序退出~");

    }
}

//创建一个数组模拟栈类
class ArrayStack{
private int maxsize;
private int[] stack;
private int top = -1;
//构造器
public ArrayStack(int maxsize){
    this.maxsize = maxsize;
    stack = new int[maxsize];
}
    //判断栈满
    public boolean isfull(){
    return top == maxsize - 1;
    }
    //判断栈空
    public boolean isEmpty(){
    return top == -1;
    }
    //入栈-push
    public void push(int value){
    if(isfull()){
        System.out.println("该栈已满");
        return;
    }
    top++;
    stack[top] = value;

    }
    //出栈-pop
    public int pop(){
    if(isEmpty()){
        throw new RuntimeException("栈空，没有数据~");

    }
    int value = stack[top];
    top--;
    return value;

    }
    //显示栈的情况，遍历栈
    public void show(){
    if(isEmpty()){
        System.out.println("该栈为空");
        return;
    }
    int temp = top;
        System.out.printf("栈的元素为: ");
    while(temp != -1){
        System.out.print(stack[temp] + " ");
        temp--;
    }
        System.out.println();

    }






}
