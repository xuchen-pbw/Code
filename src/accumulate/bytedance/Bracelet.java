package accumulate.bytedance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/*
作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，要么涂了若干种颜色。
        为了使手串的色彩看起来不那么单调，金主要求，手串上的任意一种颜色（不包含无色），在任意连续的m个串珠
        里至多出现一次（注意这里手串是一个环形）。手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，
        每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。即询问有多少种颜色在任意连续m个
        串珠中出现了至少两次。
        输入描述:
        第一行输入n，m，c三个数，用空格隔开。(1 <= n <= 10000, 1 <= m <= 1000, 1 <= c <= 50) 接下来n行每行的第一个数
        num_i(0 <= num_i <= c)表示第i颗珠子有多少种颜色。接下来依次读入num_i个数字，每个数字x表示第i颗柱子上包含第x种颜色
        (1 <= x <= c)
        输出描述:
        一个非负整数，表示该手链上有多少种颜色不符需求。
        输入例子1:
        5 2 3
        3 1 2 3
        0
        2 2 3
        1 2
        1 3
        输出例子1:
        2
        例子说明1:
        第一种颜色出现在第1颗串珠，与规则无冲突。
        第二种颜色分别出现在第 1，3，4颗串珠，第3颗与第4颗串珠相邻，所以不合要求。
        第三种颜色分别出现在第1，3，5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
        总计有2种颜色的分布是有问题的。
        这里第2颗串珠是透明的。
*/
public class Bracelet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// n个手串
        int m = scanner.nextInt();// 间隔为m
        int c = scanner.nextInt();// 有c种颜色
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        for(int i = 1; i <= c; i++) {
            map.put(i, new LinkedList<Integer>());
        }

        int total = 1;
        while(total <= n) {
            int num = scanner.nextInt();// 表示有多少顔色
            for(int i = 0; i < num; i++) {
                int color = scanner.nextInt();
                LinkedList<Integer> linkedList = map.get(color);// 得到某種顔色的位置
                linkedList.add(total);// 再加上此位置
                map.put(color, linkedList);
            }
            total++;
        }

        int error = 0;
        for(int i = 1; i <= c; i++) {
            LinkedList<Integer> linkedList = map.get(i);// 得到某種顔色的位置
            int[] array = new int[linkedList.size()];
            int k = 0;
            for(int j : linkedList) {
                array[k++] = j;
            }

            for(int j = 0; j < array.length; j++) {
                if(j + 1< array.length && array[j + 1] - array[j] < m) {
                    error++;
                    break;
                } else if(j + 1== array.length && array[0] + n - array[j] < m) {
                    error++;
                    break;
                }
            }
        }
        System.out.println(error);
    }
}