import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

    public static BufferedReader in;
    public static int N, max, min;
    public static LinkedList<int[]> maxinos;
    public static int[][] map;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};


    public static void main(String[] args) throws Exception {

        in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine().trim());

        for(int testCase = 1 ; testCase <= T ; testCase++) {
            init();
            dfs(0,0,0);

            sb.append("#").append(testCase).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    public static void init() throws Exception {
        N = Integer.parseInt(in.readLine().trim());
        maxinos = new LinkedList<>();
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        max = 0;

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1 && i > 0 && j > 0) {
                    maxinos.add(new int[] {i, j});
                }
            }
        }

    }

    public static void clone(int[][] temp, int[][] map) {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                temp[i][j] = map[i][j];
            }
        }
    }

    public static void dfs(int idx, int count, int total) {

        int[][] temp = new int[N][N];

        if(idx == maxinos.size()) {
            if(count > max) {
                max = count;
                min = total;
            }
            else if (count == max) {
                min = Math.min(min, total);
            }
            return;
        }

        clone(temp, map);

        for(int i = 0 ; i < 4 ; i++) {
            clone(map, temp);
            int valid = check(idx, i);
            if(valid == -1) continue;
            dfs(idx + 1, count + 1, total + valid);
        }

        dfs(idx + 1, count, total);
    }

    public static int check(int idx, int i) {

        int[] curr = maxinos.get(idx);

        int x = curr[0];
        int y = curr[1];

        int count = 0;

        while(true) {

            x += dx[i];
            y += dy[i];

            if(x < 0 || x >= N || y < 0 || y >= N) break;

            if(map[x][y] > 0) return -1;

            map[x][y] = 2;
            count++;
        }
        return count;
    }

    public static void print(int[][] map) {

        System.out.println("========================");
        for(int i = 0 ; i < N ; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}