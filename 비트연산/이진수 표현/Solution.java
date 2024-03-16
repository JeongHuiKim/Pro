import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(in.readLine());

        for(int t = 0 ; t < num ; t++ ) {

            String[] input = in.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            boolean check = true;
            for(int i = 0 ; i < N ; i++) {
                if((M & 1 << i) == 0) {
                    check = false;
                    break;
                }
            }

            sb.append("#").append(t + 1).append(" ").append(check ? "ON" : "OFF").append("\n");
        }

        System.out.println(sb);
    }
}


//5
//4 0
//4 30
//4 47
//5 31
//5 62