import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int test_case = 0 ; test_case < 10 ; test_case++ ) {

            int N = Integer.parseInt(in.readLine());

            Integer[] intArray = Arrays.stream(in.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(intArray));

            int M = Integer.parseInt(in.readLine());

            StringTokenizer st = new StringTokenizer(in.readLine());

            for(int i = 0 ; i < M ; i++) {

                String command = st.nextToken();
                int x, y;
                ArrayList<Integer> temp;

                switch (command) {
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        temp = new ArrayList<>();
                        for(int j = 0 ; j < y ; j++) {
                            temp.add(Integer.parseInt(st.nextToken()));
                        }
                        list.addAll(x, temp);
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0 ; j < y ; j++) {
                            list.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        temp = new ArrayList<>();
                        for(int j = 0 ; j < y ; j++) {
                            temp.add(Integer.parseInt(st.nextToken()));
                        }
                        list.addAll(temp);
                        break;
                }
            }

            sb.append("#").append(test_case + 1);
            for(int i = 0 ; i < 10 ; i++) {
                sb.append(" ").append(list.get(i));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}