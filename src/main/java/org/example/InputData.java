package org.example;
/*
  Класс альтернативного ввода данных
  с подсказками пользователю в случае сложностей.
 */

import java.util.Scanner;

public class InputData {
    private String data;

    public void setData() {
        this.data = requestingData();
    }

    public String getData() {
        return data;
    }

    public static String requestingData(){
        String res;
        String res1;
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Введите данные строго в формате: \n" +
                        "Фамилия Имя Отчество дата_рождения номер телефона пол");
        System.out.println("Например: Иванов Иван Иваныч 31.01.1991 89999999 f");
            res  = scanner.nextLine();
            boolean ok = false;
            while (!ok){
                String[] list = res.split(" ");
                int count = list.length;
                if (count>6) count = 7;
                switch (count){
                    case 1, 2, 3, 4, 5:
                        System.out.println("Введено недостаточно данных, " +
                                "проверьте и введите то, что не хватает");
                        System.out.println(res);
                        res1 = scanner.nextLine();
                        res = res + " " + res1;
                        break;
                    case 6: ok = true;
                        break;
                    case 7:
                        System.out.println("Введены лишние данные, " +
                                "проверьте и повторите ввод.");
                        System.out.println(res);
                        res1 = scanner.nextLine();
                        res = res1;
                        break;
                    case 0:
                        System.out.println("Данные не введены, " +
                                "Вижу, вам надоело(.");
                        ok = true;
                        break;
                }
            }
        return res;
    }

    @Override
    public String toString() {
        return  data ;
    }
}
