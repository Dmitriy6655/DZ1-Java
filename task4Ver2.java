// Задано уравнение вида q + w = e, q, w, e >= 0.
//  Некоторые цифры могут быть заменены знаком вопроса, 
//  например 2? + ?5 = 69. Требуется восстановить выражение 
//  до верного равенства. Предложить хотя бы одно 
// решение или сообщить, что его нет.

public class task4Ver2 {
    public static void main(String[] args) {

        System.out.println("Введите уравнение q + w = e:" + "\n" +
        "Примечание: q,w,e - двузначные числа"+ "\n" +
        "Пример ввода: 2?+?5=29");
        String str = System.console().readLine().replace(" ", "");
        // String str = "2?+?5=29";
        System.out.println(str);
        calculation(str);
    }

    public static void calculation(String st) {

        // проверка длины строки
        // int length = st.length();
        // if (length > 8) {
        // System.out.print("Повторите ввод.");
        // System.exit(0);
        // }

        // получение числа из первого слагаемого
        int end = st.indexOf('+');
        int start = 0;
        char[] dst1 = new char[end - start];

        st.getChars(start, end, dst1, 0);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < dst1.length; i++) {

            if (dst1[i] != '?' && dst1[i] != '+') {
                // добавляем в builder цифру первого слагаемого
                builder.append(dst1[i]);

            }
        }
        int Slag1 = Integer.parseInt(builder.toString());// переводит строку в целое число

        // получение числа из второго слагаемого
        int end1 = st.indexOf('=');
        int start1 = 3;
        char[] dst2 = new char[end1 - start1];

        st.getChars(start1, end1, dst2, 0);
        StringBuilder builder2 = new StringBuilder();

        for (int i = 0; i < dst2.length; i++) {

            if (dst2[i] != '?' && dst2[i] != '=') {
                // добавляем в builder цифру первого слагаемого
                builder2.append(dst2[i]);
            }
        }
        int Slag2 = Integer.parseInt(builder2.toString());// переводит строку в целое число

        // преобразуем сумму примера из строки в int

        char[] res = new char[2];
        st.getChars(6, 8, res, 0);

        StringBuilder builderRes = new StringBuilder();
        for (int i = 0; i < res.length; i++) {

            builderRes.append(res[i]);
        }

        int result = Integer.parseInt(builderRes.toString());// переводит строку в целое число
       

        // подбор остальных цифр в примере
        // создаем массив и 4 цифр
        int[] arr = new int[4];

        int end3 = st.indexOf('=');
        int start3 = 0;
        char[] dstForArray = new char[end3 - start3];

        st.getChars(start3, end3, dstForArray, 0);
        

        // заполняем массив(там где знак вопроса ставим 0)

        if (dstForArray[0] == '?') {
            arr[0] = 0;
            arr[1] = Slag1;
        } else if (dstForArray[1] == '?') {
            arr[0] = Slag1;
            arr[1] = 0;
        }
        if (dstForArray[3] == '?') {
            arr[2] = 0;
            arr[3] = Slag2;
        } else if (dstForArray[4] == '?') {
            arr[2] = Slag2;
            arr[3] = 0;
        }
                

        int j = 0;
        int k = 1;

        while (k < 10) {

            j++;

            // когда j достигает 10 прибавляем k на 1
            if (j == 10) {

                k++;
                j = 0;

            }

            // подставляем j в 1-е слагаемое
            if (arr[0] == 0) {

                int slAGA1 = preobrInNum1(arr, j);
                int slAGA2 = preobrInNum2(arr, k);

                if (slAGA1 + slAGA2 == result) {
                    printRes(slAGA1, slAGA2, result);
                    break;
                }

            } else if (arr[1] == 0) {

                int slAGA1 = preobrInNum1(arr, j);
                int slAGA2 = preobrInNum2(arr, k);

                if (slAGA1 + slAGA2 == result) {
                    printRes(slAGA1, slAGA2, result);
                    break;
                }

            }
            // подставляем k во 2-е слагаемое
            else if (arr[2] == 0) {

                int slAGA1 = preobrInNum1(arr, j);
                int slAGA2 = preobrInNum2(arr, k);

                if (slAGA1 + slAGA2 == result) {
                    printRes(slAGA1, slAGA2, result);
                    break;
                }

            } else if (arr[3] == 0) {

                int slAGA1 = preobrInNum1(arr, j);
                int slAGA2 = preobrInNum2(arr, k);

                if (slAGA1 + slAGA2 == result) {

                    printRes(slAGA1, slAGA2, result);
                    break;

                }

            }

            // если нет решений
            if (k == 9) {
                System.out.print("Решений нет!");
                break;
            }

        }

    }

    public static int preobrInNum1(int[] array, int l) {

        // преобразование числа в строку

        if (array[1] == 0) {

            String str1 = String.valueOf(array[0]);
            String str2 = String.valueOf(l);
            String strNum1 = str1 + str2;

            // преобразование строки в число
            int slagaemoe1 = Integer.parseInt(strNum1);
            return slagaemoe1;
        }

        else if (array[0] == 0) {

            String str2 = String.valueOf(array[1]);
            String str1 = String.valueOf(l);
            String strNum1 = str1 + str2;

            // преобразование строки в число
            int slagaemoe1 = Integer.parseInt(strNum1);
            return slagaemoe1;
        }

        else {
            return 1;
        }
   
    }

    public static int preobrInNum2(int[] array, int l) {

        // преобразование числа в строку

        if (array[2] == 0) {

            String str2 = String.valueOf(array[3]);
            String str1 = String.valueOf(l);
            String strNum2 = str1 + str2;

            // преобразование строки в число
            int slagaemoe2 = Integer.parseInt(strNum2);
            return slagaemoe2;
        }

        else if (array[3] == 0) {

            String str1 = String.valueOf(array[2]);
            String str2 = String.valueOf(l);
            String strNum2 = str1 + str2;

            // преобразование строки в число
            int slagaemoe2 = Integer.parseInt(strNum2);
            return slagaemoe2;
        }

        else {
            return 1;

        }
    }

    public static void printRes(int k, int n, int sum) {

        System.out.println("Решение найдено!");
        String str1 = String.valueOf(k);
        String str2 = String.valueOf(n);
        String summa = String.valueOf(sum);
        System.out.print(str1 + " + " + str2 + " = " + summa);

    }

}
