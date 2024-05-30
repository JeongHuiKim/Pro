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
            int mid = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> lQueue = new PriorityQueue<>(Collections.reverseOrder());

            PriorityQueue<Integer> rQueue = new PriorityQueue<>();

            int answer = 0;

            for(int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(in.readLine());

                rQueue.add(Integer.parseInt(st.nextToken()));
                rQueue.add(Integer.parseInt(st.nextToken()));

                lQueue.add(mid);
                lQueue.add(rQueue.poll());
                lQueue.add(rQueue.poll());

                rQueue.add(lQueue.poll());
                mid = lQueue.poll();

                answer += mid;
                answer %= 20171109;
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}