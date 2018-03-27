package Lab5;

import java.util.Scanner;

public class App {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz wyrażenie i zatwierdź enterem");
        while (scanner.hasNext()) {
            InfixToPostfixConverter converter = new InfixToPostfixConverter();
            String expresion = scanner.next();

            try {
                String onpExpression = converter.convert(expresion);
                System.out.println(expresion + " <=> " + onpExpression);
                System.out.println(onpExpression + " = " + converter.calculate());
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Wpisz wyrażenie i zatwierdź enterem");
        }
    }
}
