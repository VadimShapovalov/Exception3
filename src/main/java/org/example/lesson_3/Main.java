package org.example.lesson_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreatePerson createPerson = new CreatePerson();
        System.out.println("Добро пожаловать! Я программа по сохранению персональных данных.");
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        while (!end) {
            System.out.println("Если Вы хотите ввести данные, нажмите 1.");
            System.out.println("Если Вы хотите выйти из программы, нажмите 2.");
            String num = scanner.nextLine();
            switch (num) {
                case "2" -> end = true;
                case "1" -> {
                    boolean correctData = false;
                    while (!correctData) {
                        String[] arr = createPerson.getPersonalInformation();
                        Person p = createPerson.createPerson(arr);
                        try {
                            if (p.lastName != null && p.name != null && p.middleName != null && p.birthday != null
                                    && p.phoneNumber != null && p.male != null) {
                                WriteInFile.writerInFile(createPerson.createPerson(arr));
                                correctData = true;
                            }
                            }
                        catch (NullPointerException e) {
                            System.out.println("Формат данных неподходящий. Повторите попытку. " + e.getMessage());
                        }
                    }
                }
                default -> System.out.println("Вы ввели некорректные данные. Нажмите 1 или 2.\n");
            }
        }
    }
}
