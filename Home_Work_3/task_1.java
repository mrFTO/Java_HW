// Дана прямоугольная карта размера MxN (N, M меньше 20)
// На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
// Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку

package Home_Work_3;

public class task_1 {
    public static int countRoutes(int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (x >= m || y >= n) {
            return 0;
        }
        return countRoutes(x + 1, y, m, n) + countRoutes(x, y + 1, m, n);
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 2;
        int m = 5;
        int n = 4;
        int routes = countRoutes(x, y, m, n);
        System.out.println("Number of routes from point (" + x + ", " + y + ") to ("
                + (m - 1) + ", " + (n - 1) + ") on a " + m + "x" + n + " map is: " + routes);
    }
}