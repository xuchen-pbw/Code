package accumulate.Netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author non
 * @version 1.0
 * @date 2019/8/26 11:22
 */
/*俄罗斯方块
        小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块。因为它比较古老，所以规则和一般的俄罗斯方块不同。
        荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，在同一列中，后落下的方块会叠在先前的方块之上，当一整行方块都被占满时，这一行会被消去，并得到1分。
        有一天，小易又开了一局游戏，当玩到第 m 个方块落下时他觉得太无聊就关掉了，小易希望你告诉他这局游戏他获得的分数。
        输入描述:
        第一行两个数 n, m
        第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
        其中 1 <= n, m <= 1000, 1 <= ci <= n
        输出描述:
        小易这局游戏获得的分数

        输入例子1:
        3 9
        1 1 2 2 2 3 1 2 3
        输出例子1:
        2*/
public class Tetris {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<m; ++i){
            arr[scanner.nextInt()-1]++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
