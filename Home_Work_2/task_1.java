//  Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//  входные данные находятся в файле input.txt в виде
//  b 3
//  a 10
//  Результат нужно сохранить в файле output.txt
//  1000

import java.io.*;

public class task_1 {
    public static double calculate(double a, int b) {
        if (a == 0) {
            if (b == 0) {
                throw new IllegalArgumentException("Undefined: 0^0");
            } else {
                return 0;
            }
        }
        if (b == 0) {
            return 1;
        }
        if (b < 0) {
            b = -b;
            a = 1 / a;
        }
        double result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= a;
            }
            a *= a;
            b >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int a, b;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String[] line = br.readLine().split(" ");
            b = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            a = Integer.parseInt(line[1]);
        }

        double result = calculate(a, b);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(Double.toString(result));
            System.out.println("Calculation complete");
        }
    }
}
