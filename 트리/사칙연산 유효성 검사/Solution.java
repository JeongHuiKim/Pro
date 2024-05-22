import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#" + test_case + " ");
            int N = Integer.parseInt(in.readLine());

            String[] tree = new String[N+1];

            boolean check = false;
            for(int i = 0 ; i < N ; i++){
                String[] input = in.readLine().split(" ");
                //tree[Integer.parseInt(input[0])] = input[1];
                switch(input[1]){
                    case "*":
                    case "/":
                    case "-":
                    case "+":
                        if(input.length <= 2){
                            check = true;
                        }
                        break;
                    default:
                        if(input.length > 2){
                            check = true;
                        }
                        break;
                }
            }

            if(check){
                sb.append("0\n");
            }
            else{
                sb.append("1\n");
            }
        }

        System.out.print(sb);
    }
}