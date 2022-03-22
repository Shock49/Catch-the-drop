package ru.home.tusk.tusk2;

import java.util.Scanner;

public class GuessNumber {

    public static Scanner scanner = new Scanner(System.in);

    public static void play(int range){
        System.out.println("Угадайте число от 0 до " + (range-1));
        int rnd = (int)(Math.random()*range);
        System.out.print("Пожалуйста введите число: ");
        while (true) {
           int user = scanner.nextInt();
            if(user == rnd){
                System.out.println("Вы угадали!");
                break;}
            else if(user > rnd) System.out.println("Загаданное число меньше.");
            else System.out.println("Загаданное чило болше.");
        }
    }
    public static void main(String[] args) {
        for (int i=10;i<=30;i+=10){
             play(i);

        }
        System.out.println("Win !!!!");
    }
}
