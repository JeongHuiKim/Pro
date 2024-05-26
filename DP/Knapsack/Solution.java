import java.util.*;
import java.io.*;

class Solution
{


    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");

            StringTokenizer st = new StringTokenizer(in.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] V = new int[N + 1];
            int[] C = new int[N + 1];

            for(int i = 1 ; i <= N ; i++){
                st = new StringTokenizer(in.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

//            System.out.println("weight : " + Arrays.toString(V));
//            System.out.println("value : " + Arrays.toString(C));

            int[][] dp = new int[N + 1][K + 1];

            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j < K + 1 ; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    if(j - V[i] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V[i]] + C[i]);
                    }
                }
            }

//            printmap(dp, N);

            sb.append(dp[N][K]).append("\n");
        }
        System.out.print(sb);
    }

    public static void printmap(int[][] dp, int N) {
        for(int i = 1 ; i <= N ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

}