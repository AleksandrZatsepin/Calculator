import java.util.Scanner;

public class Main {
    private static boolean isRoman = false;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать\nВведите выражение :");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println(calc(userInput));
    }
    public static String calc(String input) {
        String operator = getOperator(input);
        int[] numbers;
        numbers = StringToNumber(input.replace(" ", "").split("[^ivxIVX1234567890]"));
        Calculation(numbers, operator);
        return Calculation(numbers, operator);
    }

    private static String Calculation(int[] numbers, String operator) {
        int result = 0;
        switch (operator)
        {
            case "+":
                result = numbers[0]+numbers[1];
                break;
            case "-":
                result = numbers[0]-numbers[1];
                break;
            case "*":
                result = numbers[0]*numbers[1];
                break;
            case "/":
                    result = numbers[0]/numbers[1];
                break;
        }
        if (isRoman)
        {
            return (RomanArabic.arabicToRoman(result));
        }

        return Integer.toString(result);
    }

    private static int[] StringToNumber(String[] temp) {
        if (temp.length>2){
            throw new IllegalArgumentException(" два положительных числа от 0 до 10, " +
                    "между ними нужный оператор, вы точно понимаете как работает этот калькулятор?");
        }
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
        } catch (IllegalArgumentException e) {
            isRoman = true;

        }
        if (isRoman)
        {
            a = RomanArabic.romanToArabic(temp[0]);
            b = RomanArabic.romanToArabic(temp[1]);
        }
        return new int[]{a, b};
    }

    private static String getOperator(String input) {
        String operatorsLib = "+-*/";
        String operatorVal = null;
        for (char i : operatorsLib.toCharArray()) {
            if (input.indexOf(i) != -1) {
                if (operatorVal==null)
                    operatorVal = String.valueOf(i);
                else
                    throw new IllegalArgumentException(input + " два положительных числа от 0 до 10, " +
                            "между ними нужный оператор, вы точно понимаете как работает этот калькулятор?");
            }
        }
        return operatorVal;
    }
}