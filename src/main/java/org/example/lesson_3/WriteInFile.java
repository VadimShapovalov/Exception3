package org.example.lesson_3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteInFile {
    /**
     * Метод записывает персональные данные в текстовый файл.
     * @param person
     */
    public static void writerInFile(Person person) {
        try {
            String filename = "C:\\Users\\Vadim\\IdeaProjects\\Exception3\\src\\main\\java\\org\\example\\lesson_3\\data\\" +
                    person.getLastName() + ".txt";

            StringBuilder builder = new StringBuilder("<" + person.getLastName() + ">");
            builder.append("<" + person.getName() + ">");
            builder.append("<" + person.getMiddleName() + ">");
            builder.append("<" + person.getBirthday() + ">");
            builder.append("<" + person.getPhoneNumber() + ">");
            builder.append("<" + person.getMale() + ">\n");
            if (Files.exists(Path.of(filename))) {
                FileWriter writer = new FileWriter(filename, true);
                writer.write(builder.toString());
                System.out.println("Данные успешно записаны в уже существующий файл.");
                System.out.println("Путь файла:" + filename);
                writer.close();
            }
            else {
                FileWriter writer = new FileWriter(filename);
                writer.write(builder.toString());
                System.out.println("Данные успешно записаны в новый файл");
                System.out.println("Путь файла:" + filename);
                writer.close();
            }
            }
        catch (IOException e) {
            System.out.println("Ошибка при записи персональных данных в файл ");
            System.out.println(e.getMessage());
        }
    }
}
