import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < num ; t++ ) {

            int N = Integer.parseInt(in.readLine());

            int answer = 0;

            int count = 1;
            while(answer != (1 << 10) - 1) {
                int curr = N * count;

                while(curr != 0) {
                    answer |= 1 << (curr % 10);
                    curr /= 10;
                }
                count++;
            }
            sb.append("#").append(t+1).append(" ").append((count - 1) * N).append("\n");
        }

        System.out.println(sb);
    }
}