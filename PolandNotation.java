package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {//逆波兰表达式
    public static void main(String[] args) {
        //先定义逆波兰表达式(后缀表达式)
        //（3+4）*5-6=>3 4 + 5 * 6 -
        String suff = "3 4 + 5 * 6 -";
        List<String> getlist = getlist(suff);
        int calculate = calculate(getlist);
        System.out.println(calculate);

    }
//传进字符串，返回list
    public static List<String> getlist(String suff) {
        String[] s = suff.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        return list;

    }
    //传进list，返回计算结果
    //（3+4）*5-6=>3 4 + 5 * 6 -
    public static int calculate(List<String> list){
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            if(s.matches("\\d+")){  //如果是数字
                stack.push(Integer.parseInt(s));//入栈
            }else {
                //出栈两个数字进行计算，判断该s是什么符号
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                if(s.equals("+")){
                     res = num2 + num1;
                } else if (s.equals("-")) {
                    res = num2 - num1;
                } else if (s.equals("*")) {
                    res = num2 * num1;
                } else if (s.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res);
            }


        }
        return stack.pop();



    }



}