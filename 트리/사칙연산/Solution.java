import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public static int N;
    public static LinkedList<Integer>[] graph;
    public static String[] value;


    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int testCase = 1 ; testCase <= 10 ; testCase++) {

            N = Integer.parseInt(in.readLine());
            graph = new LinkedList[N+1];
            for(int i = 0 ; i < N + 1 ; i++) {
                graph[i] = new LinkedList<>();
            }
            value = new String[N+1];

            for(int i = 0 ; i < N ; i++) {
                String[] input = in.readLine().split(" ");
                value[Integer.parseInt(input[0])] = input[1];
                for(int j = 2 ; j < input.length ; j++) {
                    graph[Integer.parseInt(input[0])].add(Integer.parseInt(input[j]));
                }
            }

            sb.append("#").append(testCase).append(" ").append(cal()).append("\n");
        }

        System.out.println(sb);
    }

    public static int cal() {

        for(int idx = N ; idx >= 1 ; idx--) {
            switch(value[idx]) {
                case "+":
                    value[idx] = String.valueOf(Float.parseFloat(value[graph[idx].get(0)]) + Float.parseFloat(value[graph[idx].get(1)]));
                    break;
                case "-":
                    value[idx] = String.valueOf(Float.parseFloat(value[graph[idx].get(0)]) - Float.parseFloat(value[graph[idx].get(1)]));
                    break;
                case "/":
                    value[idx] = String.valueOf(Float.parseFloat(value[graph[idx].get(0)]) / Float.parseFloat(value[graph[idx].get(1)]));
                    break;
                case "*":
                    value[idx] = String.valueOf(Float.parseFloat(value[graph[idx].get(0)]) * Float.parseFloat(value[graph[idx].get(1)]));
                    break;
            }
        }

        return (int) Float.parseFloat(value[1]);

    }
}