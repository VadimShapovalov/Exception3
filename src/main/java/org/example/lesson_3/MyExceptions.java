package org.example.lesson_3;

public abstract class MyExceptions extends RuntimeException{

    public MyExceptions(String message) {
        super(message);
    }
}
class CorrectDataException extends MyExceptions {
    public CorrectDataException(String message) {
        super(message);
    }
}

