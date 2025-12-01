import java.util.*;
import java.util.Comparator;

class Applicant {
    private String lastName;
    private String firstName;
    private int subject1Score;
    private int subject2Score;
    
    // Конструктор
    public Applicant(String lastName, String firstName, int subject1Score, int subject2Score) {
        validateInput(lastName, firstName, subject1Score, subject2Score);
        
        this.lastName = lastName;
        this.firstName = firstName;
        this.subject1Score = subject1Score;
        this.subject2Score = subject2Score;
    }
    
    // Валидация входных данных
    private void validateInput(String lastName, String firstName, int score1, int score2) {
        if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 20) {
            throw new IllegalArgumentException("Фамилия должна быть не пустой и не более 20 символов");
        }
        if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 15) {
            throw new IllegalArgumentException("Имя должно быть не пустым и не более 15 символов");
        }
        if (score1 < 0 || score1 > 100 || score2 < 0 || score2 > 100) {
            throw new IllegalArgumentException("Баллы должны быть в диапазоне от 0 до 100");
        }
    }
    
    // Проверка, прошел ли абитуриент тестирование
    public boolean isPassed() {
        return subject1Score >= 30 && subject2Score >= 30;
    }
    
    // Проверка, не прошел ли абитуриент тестирование
    public boolean isFailed() {
        return !isPassed();
    }
    
    // Геттеры
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int getSubject1Score() { return subject1Score; }
    public int getSubject2Score() { return subject2Score; }
    
    // Строковое представление
    @Override
    public String toString() {
        return String.format("%s %s (%d, %d)", lastName, firstName, subject1Score, subject2Score);
    }
    
    // Краткое представление (только имя и фамилия)
    public String toShortString() {
        return lastName + " " + firstName;
    }
}



// Дополнительный класс для демонстрации с готовыми данными
