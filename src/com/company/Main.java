package com.company;

import java.util.Scanner;


public class Main {


    static char[][] table = new char[3][3];


    public static void main(String[] argv)
    {


        char done;
        Scanner in = new Scanner(System.in);
        done = ' ';
        init_table();
        double var_double;

        System.out.println("Выберите режим игры: 1) - с компьютером, 2) - с другим игроком");
        while (true) {
            var_double = in.nextInt();
            if ((var_double >= 1) && (var_double <= 2)) {
                break;
            }
            System.out.println("ERROR!!! Такой вариант не существует!");
        }



        if (var_double == 1) {
            do{
                draw();
                player1();
                done = HOW_WIN();
                if(done != ' ') break;
                PC();
                if(done != ' ') break;
            }while(done == ' ');

            if(done == 'X') System.out.println("Поздравляем! Вы победили!");
            else System.out.println("К сожалению, Вы проиграли!");

            return;
        } else if (var_double == 2) {
           // var_Human();
            do{
                draw();
                player1();
                done = HOW_WIN();
                if(done != ' ') break;
                player2();
                if(done != ' ') break;
            }while(done == ' ');

            if(done == 'X') System.out.println("Поздравляем! Вы победили!");
            else System.out.println("К сожалению, Вы проиграли!");

            return;
        }

    }


    public static void init_table()
    {
        int i, j;
        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                table[i][j] = ' ';
            }
        }
    }


    public static void draw()
    {
        int i;
        for(i = 0; i < 3; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            sb.append(table[i][0]);
            sb.append(" |");
            sb.append(' ');
            sb.append(table[i][1]);
            sb.append(" |");
            sb.append(' ');
            sb.append( table[i][2]);
            System.out.println(sb.toString());
            if(i != 2) System.out.println(" - | - | - ");
        }
        System.out.println();
    }


    public static void player1()
    {
        int i, j;
        Scanner in = new Scanner(System.in);
        System.out.println("Игрок 1. Введите координаты x: ");
        i = in.nextInt();
        System.out.println("Игрок 1. Введите координаты y: ");
        j = in.nextInt();

        i--; j--;

        if(table[i][j] != ' '){
            System.out.println("Ячейка занята, Попробуйте еще раз!\n");
            player1();
        }
        else table[i][j] = 'X';
    }

    public static void player2()
    {
        int i, j;
        Scanner in = new Scanner(System.in);
        System.out.println("Игрок 2. Введите координаты x: ");
        i = in.nextInt();
        System.out.println("Игрок 2. Введите координаты y: ");
        j = in.nextInt();

        i--; j--;

        if(table[i][j] != ' '){
            System.out.println("Ячейка занята, Попробуйте еще раз!\n");
            player2();
        }
        else table[i][j] = 'X';
    }


    public static void PC()
    {
        int i  =0 , j = 0;

        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                if(table[i][j] == ' ') break;
            }
            if(table[i][j] == ' ') break;
        }

        if(i*j == 9){
            System.out.println("Ничья!");
            System.exit(0);
        }
        else table[i][j] = 'O';
    }


    public static char HOW_WIN()
    {
        int i;

        for(i = 0; i < 3; i++)
            if(table[i][0] == table[i][1] &&
                    table[i][0] == table[i][2]) return table[i][0];
        for(i = 0; i < 3; i++)
            if(table[0][i] == table[1][i] &&
                    table[0][i] == table[2][i]) return table[0][i];

        if(table[0][0] == table[1][1] &&
                table[1][1] == table[2][2])
            return table[0][0];

        if(table[0][2] == table[1][1] &&
                table[1][1] == table[2][0])
            return table[0][2];

        return ' ';
    }
}