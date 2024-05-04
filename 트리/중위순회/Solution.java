import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static int N;
    public static String answer;
    public static String[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1 ; test_case <= 10 ; test_case++) {

            N = Integer.parseInt(in.readLine());
            answer = "";
            tree = new String[N+1];

            for (int i = 1; i <= N; i++) {
                String[] input = in.readLine().split(" ");
                tree[i] = input[1];
            }

            inOrder(1);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void inOrder(int curr) {

        if(curr * 2 <= N) inOrder(curr * 2);
        answer += tree[curr];
        if(curr * 2 + 1 <= N) inOrder(curr * 2 + 1);
    }

}