package org.example.lesson_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreatePerson {

    /**
     * метод парсит строку с данными от пользователя и определяет корректное ли количество данных
     * @return Strint[]
     * @throws IOException
     */
    public String[] getPersonalInformation() {
        try {
            boolean correctCount = false;
            String[] array = new String[6];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (!correctCount) {
                System.out.println("Пожалуйста, введите Ваши персональные данные.");
                System.out.println(("Данные следует ввести одной строкой через пробел"));
                System.out.println("Фамилия Имя Отчество, дату рождения в формате 01.01.2001, номер телефона (только цифры)," +
                        " пол в формате \"m\" или \"f\"");
                String personalInformation = reader.readLine();
                array = personalInformation.split(" "); // парсим строку
                int errorCod = 0;
                if (array.length < 6) {
                    errorCod = -2;
                } else if (array.length > 6) {
                    errorCod = -1;
                } else {
                    correctCount = true;
                }
                switch (errorCod) {
                    case -2 -> System.out.println("Вы ввели меньше данных, чем требуется.\n");
                    case -1 -> System.out.println("Вы ввели больше данных, чем требуется.\n");
                }
            }
            return array;
        } catch (IOException ex) {
            System.out.println("Ошибка ввода данных. " + ex.getMessage());
        }
        return null;
    }

    /**
     * метод проверяет является ли строка телефонным номером.
     * @param str
     * @return boolean
     */
    public boolean isPhoneNumber(String str) {
        boolean isPhone = false;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                flag = false;
            }
        }
        if (flag) isPhone = true;
        return isPhone;
    }

    /**
     * метода проверяет, является ли строка обозначением пола.
     * @param str
     * @return boolean
     */
    public boolean isMale(String str) {
        boolean isMale = false;
        if (str.length() == 1) {
            if (str.equals("m")) {
                isMale = true;
            }
            if (str.equals("f")) {
                isMale = true;
            }
        }
        return isMale;
    }

    /**
     * метод проверяет, является ли строка датой рождения.
     * @param str
     * @return boolean
     */
    public boolean isBirthday(String str) {
        boolean isBirthday = false;
        String[] array = str.split("\\.");
        if (array.length == 3) isBirthday = true;
        return isBirthday;
    }

    /**
     * метод проверяет является ли строка ФИО
     * @param str
     * @return boolean
     */
    public boolean isFio(String str) {
        boolean isFio = false;
        boolean onlyLetter = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                onlyLetter = false;
            }
        }
        if (str.length() > 1 && onlyLetter) isFio = true;
        return isFio;
    }

    /**
     * Метод создает новую персону
     * @param  data
     * @return Person
     */
    public Person createPerson(String[] data) {
        Person p = new Person();
        int checkCountName = 0;
        boolean isFio = false;
        boolean isBirthday = false;
        boolean isPhoneNumber = false;
        boolean isMale = false;

        for (String s : data) {
            isFio = isFio(s);
            if (isFio) checkCountName += 1;
            isBirthday = isBirthday(s);
            isPhoneNumber = isPhoneNumber(s);
            isMale = isMale(s);
            if (isFio && checkCountName == 1) p.lastName = s;
            if (isFio && checkCountName == 2) p.name = s;
            if (isFio && checkCountName == 3) p.middleName = s;
            if (isBirthday) p.birthday = s;
            if (isPhoneNumber) p.phoneNumber = s;
            if (isMale) p.male = s;
        }
        try {
        if (p.lastName != null && p.name != null && p.middleName != null && p.birthday != null
                && p.phoneNumber != null && p.male != null) {
            return p;
        }
        else {
            throw new CorrectDataException("Вы ввели некорректные данные.");
        }
    }
        catch (CorrectDataException e) {
            System.out.println(e.getMessage());
        }
    return null;
    }
}

