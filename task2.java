
// Вывести все простые числа от 1 до 1000

public class task2 {

    public static void main(String[] args) {

        int n = 1000;
        System.out.println("Простые числа от 1 до " + n + ":");
        for (int k = 2; k < n; k++) {

            boolean number = true;

            for (int j = 2; j < k; j++) {
                if (k % j == 0) {
                    number = false;
                    break;
                }
            }

            StringBuffer strBuffer = new StringBuffer("");

            if (number) {

                strBuffer.append(k);
                System.out.println(strBuffer.toString());

            }

        }

    }
}
