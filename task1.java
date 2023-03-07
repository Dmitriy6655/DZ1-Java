// Вычислить [n-ое треугольного число](сумма чисел от 1 до n), n! 
// (произведение чисел от 1 до n)

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.print("Введите число: ");
        // Scanner num = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.print("n-ое треугольного число: ");
        System.out.println(triangularNumber(num));

        System.out.print("сумма чисел = ");
        System.out.println(sumNum(num));

        System.out.print("Факториал = ");
        System.out.println(factorial(num));

    }

    public static int triangularNumber(int f) {

        return (f * (f + 1)) / 2;

    }

    public static int sumNum(int x) {
        if (x == 1) {

            return 1;
        }
        return x + sumNum(x - 1);

    }

    static int factorial(int x) {

        if (x == 1) {

            return 1;
        }
        return x * factorial(x - 1);
    }
}
