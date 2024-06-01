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
            sb.append("#").append(test_case).append("\n");

            int N = Integer.parseInt(in.readLine());

            TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() == o2.length()) {
                        for(int i = 0 ; i < o1.length() ; i++) {
                            if(o1.charAt(i) == o2.charAt(i)) continue;
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return o1.length() - o2.length();
                }
            });

            for(int i = 0 ; i < N ; i++) {
                String input = in.readLine();
                if(!set.contains(input)) {
                    set.add(input);
                }
            }

//            System.out.println(set.toString());


            for(String output : set) {
                sb.append(output).append("\n");
            }
        }
        System.out.print(sb);
    }
}