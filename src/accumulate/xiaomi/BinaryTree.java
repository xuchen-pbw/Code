package accumulate.xiaomi;

import java.util.Stack;

/**
 * @author non
 * @version 1.0
 * @date 2019/9/6 22:52
 */
//1(2(3,4(,5)),6(7,))
//3245176
public class BinaryTree {
    public static void main(String[] args) {
        System.out.println(solution("1(2(3,4(,5)),6(7,))"));
    }

    private  static String solution(String input) {
        if(input==null||input.length()<2){
            return input;
        }
        Stack<Character> number=new Stack<Character>();
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(c>='0'&&c<='9'){
                char c1=input.charAt(i+1);
                if(c1==','){
                    builder.append(c);
                    builder.append(number.pop());
                    i++;
                    continue;
                }
                number.push(c);
            }
            if(c=='('){
                char c1=input.charAt(i+1);
                if(c1==','){
                    builder.append(number.pop());
                    i++;
                }
            }
            if(c==')'){
                builder.append(number.isEmpty()?"":number.pop());
            }
        }
        return builder.toString();
    }
}
