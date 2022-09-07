
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        System.out.print(Calc.calc(exp));

    }
}
    class Calc {

       public static String calc(String input)  {
           Converter converter = new Converter();
            String[] actions = {"+", "-", "/", "*"};
            String[] regexActions = {"\\+", "-", "/", "\\*"};

            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (input.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }

            if (actionIndex == -1) {
                System.out.println("Некорректное выражение");

            }
            String[] data = input.split(regexActions[actionIndex]);
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;

                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {

                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {

                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if ((a < 0 || a > 10 || b < 0 || b > 10)) {
                    System.out.println("Некорректный ввод, от 0 до 10");

                }
                if (data.length != 2) {
                    System.out.println("Некорректный ввод, введите не более одного выражения");

                }
                int result;
                switch (actions[actionIndex]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        result = a / b;
                        break;
                }

                if (isRoman) {

                    System.out.println(converter.intToRoman(result));
                } else {

                    System.out.println(result);
                }
            } else {
                System.out.println("Числа должны быть в одном формате");
            }
            return "Расчет закончен, калькулятор завершил работу";
        }


    }










