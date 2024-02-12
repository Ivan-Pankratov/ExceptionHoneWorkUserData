package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Long.parseLong;


public class Main {
    public static void main(String[] args) {
/*
Переменная int alternative = 1 активизирует решение ввода строки
с выбросом исключений
Переменная int alternative = 2 активизирует решение ввода строки
с возможностью дополнительного ввода данных.
 */
        //int alternative = 1;
        int alternative = 2;
        String[] split = new String[0];
        switch (alternative) {
            case 1:

                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите данные строго в формате: \n" +
                        "Фамилия Имя Отчество дата_рождения номер телефона пол");
                System.out.println("Например: Иванов Иван Иваныч 31.01.1991 89999999 f");
                split = scanner.nextLine().split(" ");
                if (split.length < 6) {
                    throw new InputDataException("Недостаточно данных");
                } else if (split.length > 6) {
                    throw new InputDataException("Введены лишние данные");
                }
                break;
            case 2:
                InputData inputData = new InputData();
                inputData.setData();
                split = inputData.getData().split(" ");
                break;
        }

        if (nameTest(split[0])) {
            throw new InputDataException("Не корректно указана фамилия.");
        }

        if (nameTest(split[1])) {
            throw new InputDataException("Не корректно указано имя.");
        }

        if (nameTest(split[2])) {
            throw new InputDataException("Не корректно указано отчество.");
        }

        if (birthdateTest(split[3])) {
            throw new InputDataException("Не корректно указана дата рождения.");
        }

        if (phoneNumberTest(split[4])) {
            throw new InputDataException("Не корректно указан номер телефона.");
        }

        if (!genderTest(split[5])) {
            throw new InputDataException("Не корректно указан пол.");
        }

        UserData user;
        try {
            user = new UserData(split[0], split[1],
                    split[2], split[3], parseLong(split[4]), split[5].charAt(0));
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        String filename = user.surname+".txt";
        try (WriteFile writeFile = new WriteFile(filename) ){
            writeFile.getUser(user);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    private static boolean nameTest(String name){
        Pattern pattern = Pattern.compile("[A-Z[А-Я]][a-z[а-я]]{1,}");
        Matcher matcher = pattern.matcher(name);
        return !matcher.matches();
    }

    private static boolean birthdateTest(String birthdate){
        Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        Matcher matcher = pattern.matcher(birthdate);
        return !matcher.matches();
    }

    private static boolean phoneNumberTest(String phoneNumber){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(phoneNumber);
        return !matcher.matches();
    }

    private static boolean genderTest(String gender){
        return (gender.equalsIgnoreCase("f")||gender.equalsIgnoreCase("m"));
    }

}
