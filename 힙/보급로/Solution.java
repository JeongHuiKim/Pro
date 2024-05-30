import java.util.*;
import java.io.*;

class Solution
{
    public static int N;
    public static int[][] map;
    public static int min;
    public static int[][] pathCost;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");

            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            pathCost = new int[N][N];
            min = Integer.MAX_VALUE;

            for(int i = 0 ; i < N ; i++){
                char[] input = in.readLine().toCharArray();
                for(int j = 0 ; j < N ; j++){
                    map[i][j] = input[j] - '0';
                }
            }

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    pathCost[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> queue = new PriorityQueue<Node>();
            queue.add(new Node(0,0,0));
            pathCost[0][0] = 0;

            while(!queue.isEmpty()) {
                Node curr = queue.poll();

                for(int i = 0 ; i < 4 ; i++) {
                    int x = curr.x + dx[i];
                    int y = curr.y + dy[i];
                    if(x >= 0 && x < N && y >= 0 && y < N) {
                        int nextCost = pathCost[curr.x][curr.y] + map[x][y];
                        if(pathCost[x][y] > nextCost) {
                            queue.add(new Node(x, y, nextCost));
                            pathCost[x][y] = nextCost;
                        }
                    }
                }
            }

            sb.append(pathCost[N-1][N-1]).append("\n");
        }
        System.out.print(sb);
    }

    public static class Node implements Comparable<Node>{

        int x;
        int y;
        int cost;


        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


}