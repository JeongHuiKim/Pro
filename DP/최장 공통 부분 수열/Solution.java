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

            StringTokenizer st = new StringTokenizer(in.readLine().trim());

            char[] string1 = st.nextToken().toCharArray();
            char[] string2 = st.nextToken().toCharArray();

            int[][] dp = new int[string1.length + 1][string2.length + 1];

            for(int i = 0 ; i < string1.length ; i++) {
                for(int j = 0 ; j < string2.length ; j++) {
                    if(string1[i] == string2[j]) {
                        dp[i+1][j+1] = dp[i][j] + 1;
                    }
                    else {
                        dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }

            sb.append(dp[string1.length][string2.length]).append("\n");
        }
        System.out.print(sb);
    }
}