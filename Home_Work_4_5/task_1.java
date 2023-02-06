package Home_Work_4_5;

import java.util.ArrayDeque;
import java.util.Queue;

public class task_1 {

    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static int[][] findShortestPath(int[][] map, int startX, int startY, int endX, int endY) {
        int n = map.length;
        int m = map[0].length;

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(startX, startY));
        distance[startX][startY] = 0;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && distance[newX][newY] == Integer.MAX_VALUE) {
                    q.add(new Pair(newX, newY));
                    distance[newX][newY] = distance[x][y] + 1;
                }
            }
        }

        return distance;
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] map = { { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 } };
        int startX = 1;
        int startY = 1;
        int endX = 3;
        int endY = 3;

        int[][] distance = findShortestPath(map, startX, startY, endX, endY);

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
