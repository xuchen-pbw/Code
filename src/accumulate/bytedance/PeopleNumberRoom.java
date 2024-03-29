package accumulate.bytedance;

import java.util.Scanner;
/*
房间的人数
        有n个房间，现在i号房间里的人需要被重新分配，分配的规则是这样的：先让i号房间里的人全都出来，
                接下来按照 i+1, i+2, i+3, ... 的顺序依此往这些房间里放一个人，n号房间的的下一个房间是1号房间，
                直到所有的人都被重新分配。现在告诉你分配完后每个房间的人数以及最后一个人被分配的房间号x，
                你需要求出分配前每个房间的人数。数据保证一定有解，若有多解输出任意一个解。
                第一行两个整数n, x (2<=n<=10^5, 1<=x<=n)，代表房间房间数量以及最后一个人被分配的房间号；
                第二行n个整数 a_i(0<=a_i<=10^9) ，代表每个房间分配后的人数。
                输出描述:
                输出n个整数，代表每个房间分配前的人数。
                输入
                3 1
                6 5 1
                输出
                4 4 4*/
public class PeopleNumberRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        long[] room = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextInt();
            if (room[i] < min)
                min = room[i];
        }
        //get min_index
        int minIndex = x;
        while (room[minIndex] != min) {
            minIndex = minIndex > 0 ? minIndex - 1 : n - 1;
        }
        // remove the round number.
        for (int i = 0; i < n; i++) {
            room[i] -= min;
        }
        // remove the tail
        int remain = 0;
        for (int i = x; i != minIndex; i = i > 0 ? i - 1 : n - 1) {
            room[i] -= 1;
            remain += 1;
        }
        room[minIndex] += remain + n * min;
        //print the result
        for (int i = 0; i < n; i++) {
            System.out.print(room[i] + " ");
        }
    }
}
