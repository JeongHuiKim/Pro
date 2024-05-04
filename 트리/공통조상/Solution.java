import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for(int testCase = 1 ; testCase <= T ; testCase++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            LinkedList<Integer>[] graph = new LinkedList[V+1];
            for(int i = 0 ; i <= V ; i++) {
                graph[i] = new LinkedList<>();
            }
            int[] depth = new int[V+1];
            int[] parents = new int[V+1];

            st = new StringTokenizer(in.readLine());

            for(int i = 0 ; i < E ; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                graph[parent].add(child);
            }

            ArrayDeque<Integer> queue =  new ArrayDeque<>();
            queue.add(1);
            int count = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0 ; i < size ; i++) {
                    int curr = queue.poll();
                    depth[curr] = count;
                    for(int next : graph[curr]) {
                        queue.add(next);
                        parents[next] = curr;
                    }
                }
                count++;
            }

            while(depth[A] != depth[B]) {
                if(depth[A] > depth[B]) {
                    A = parents[A];
                }
                else {
                    B = parents[B];
                }
            }

            while(A != B) {
                A = parents[A];
                B = parents[B];
            }

            queue =  new ArrayDeque<>();
            queue.add(A);
            count = 1;
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                for(int next : graph[curr]) {
                    queue.add(next);
                    count++;
                }
            }

            sb.append("#").append(testCase).append(" ").append(A).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}