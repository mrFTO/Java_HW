//1. Написать программу вычисления n-ого треугольного числа.
//Программа вычисляет n-ое треугольное число, используя формулу (n * (n + 1)) / 2. Значение n может быть изменено в методе main, а результат вычисления выводится на экран.

package Home_Work_1;


public class task_1 {
    public static int calculate(int n) {
        return (n * (n + 1)) / 2;
    } // вычисление треугольного числа по формуле

    public static void main(String[] args) {
        int n = 8;
        int result = calculate(n);
        System.out.println("The " + n + "th triangular number is " + result);
    } // определение значение n и вывод на печать в консоль результата расчетов
}