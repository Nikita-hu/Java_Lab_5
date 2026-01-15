class Applicant {
    private String lastName;
    private String firstName;
    private int score1;
    private int score2;

    public Applicant(String lastName, String firstName, int score1, int score2) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score1 = score1;
        this.score2 = score2;

        // Проверка валидности баллов
        if (score1 < 0 || score1 > 100 || score2 < 0 || score2 > 100) {
            throw new IllegalArgumentException("Баллы должны быть в диапазоне от 0 до 100");
        }
        if ((lastName.length() <= 20) && (firstName.length() <= 15)) {
            throw new IllegalArgumentException(
                    "Фамилия не должна превышать 20 символов, и имя не должно превышать 15 символов");
        }
    }

    // Проверка, провалил ли абитуриент тестирование
    public boolean isFailed() {
        return score1 < 30 || score2 < 30;
    }

    // Вычисление среднего балла
    public double getAverageScore() {
        return (score1 + score2) / 2.0;
    }

    // Форматированный вывод
    @Override
    public String toString() {
        return String.format("%s %s: баллы %d, %d (средний: %.1f) %s",
                lastName, firstName, score1, score2,
                getAverageScore(), isFailed() ? "[НЕ ДОПУЩЕН]" : "[ДОПУЩЕН]");
    }

    // Короткая строка для вывода
    public String toShortString() {
        return lastName + " " + firstName + " (" + score1 + ", " + score2 + ")";
    }

    // Геттеры
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}