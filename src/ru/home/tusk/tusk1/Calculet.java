package ru.home.tusk.tusk1;

import java.util.Scanner;

public class Calculet {
    public static void main(String[] args) {
        System.out.println("Выбирите математическую операцию: \n1.Сложение  2.Вычитание\n3.Умножение  4.Деление");
        Scanner scanner = new Scanner(System.in);
        int operator = scanner.nextInt();
        System.out.println("Введите 1 и 2-ое число через пробел : >> ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        int result;
        if(operator == 1) result = a+b;
        else if (operator == 2) result = a-b;
        else if (operator == 3) result = a*b;
        else result = a/b;
        System.out.println("Результат операции : " + result);
    }
}
