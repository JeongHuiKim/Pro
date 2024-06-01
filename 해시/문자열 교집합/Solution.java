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
            int M = Integer.parseInt(st.nextToken());

            HashSet<String> set = new HashSet<>();

            st = new StringTokenizer(in.readLine());
            for(int i = 0 ; i < N ; i++){
                set.add(st.nextToken());
            }

            int answer = 0;
            st = new StringTokenizer(in.readLine());
            for(int i = 0 ; i < M ; i++){
                if(set.contains(st.nextToken())) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}