package Home_Work_5;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class task_1 {
    private static final int[][] MAZE = {
            { 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1 }
    };

    private static final int ROW = MAZE.length;
    private static final int COL = MAZE[0].length;

    private static final int[] ROW_OFFSETS = { -1, 0, 1, 0 };
    private static final int[] COL_OFFSETS = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Point cat = new Point(new Random().nextInt(ROW), new Random().nextInt(COL));
        int[][] distance = findPath(cat);
        displayMap(cat, distance);
    }

    private static int[][] findPath(Point cat) {
        int[][] distance = new int[ROW][COL];
        Deque<Point> queue = new ArrayDeque<>();
        queue.offer(cat);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int row = point.x;
            int col = point.y;

            for (int i = 0; i < 4; i++) {
                int newRow = row + ROW_OFFSETS[i];
                int newCol = col + COL_OFFSETS[i];

                if (isValid(newRow, newCol) && MAZE[newRow][newCol] == 0 &&
                        distance[newRow][newCol] == 0) {
                    distance[newRow][newCol] = distance[row][col] + 1;
                    queue.offer(new Point(newRow, newCol));
                }
            }
        }

        return distance;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL;
    }

    private static void displayMap(Point cat, int[][] distance) {
        System.out.println("Maze:");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (i == cat.x && j == cat.y) {
                    System.out.print("\033[31mC\033[0m");
                } else if (MAZE[i][j] == 1) {
                    System.out.print("\033[32m#\033[0m");
                } else if (distance[i][j] > 0) {
                    System.out.print("\033[34m.\033[0m");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}