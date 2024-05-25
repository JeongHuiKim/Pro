import java.util.*;
import java.io.*;

class Solution
{
    public static int N, score;
    public static int[][] map;
    public static boolean[][] check;
    public static int[] dx = {-1,-1,-1,0,1,1,1,0};
    public static int[] dy = {-1,0,1,1,1,0,-1,-1};

    public static void main(String args[]) throws Exception
    {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");
            init(in);

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(map[i][j] == 0 && !check[i][j]) {
                        play(i, j);
                        score++;
                    }
                }
            }

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(map[i][j] != -1 && !check[i][j]) {
                        score++;
                    }
                }
            }

            sb.append(score).append("\n");
        }
        System.out.print(sb);
    }

    public static void play(int i, int j) {

        check[i][j] = true;

        if(map[i][j] != 0) return;

        for(int k = 0 ; k < 8 ; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && x < N && y >= 0 && y < N && !check[x][y]) {
                play(x, y);
            }
        }
    }

    public static void init(BufferedReader in) throws Exception{
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        score = 0;

        for(int i = 0 ; i < N ; i++) {
            char[] data = in.readLine().toCharArray();
            for(int j = 0 ; j < N ; j++) {
                if(data[j] == '.') map[i][j] = 0;
                else map[i][j] = -1;
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(map[i][j] == -1) continue;
                int count = 0;
                for(int k = 0 ; k < 8 ; k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] == -1) count++;
                }
                map[i][j] = count;
            }
        }
    }
}