class Fraction implements FractionOperations {
    private int numerator; // числитель
    private int denominator; // знаменатель
    private Double cachedRealValue; // кэшированное вещественное значение
    private boolean isCacheValid; // флаг валидности кэша
    
    // Конструктор
    public Fraction(int numerator, int denominator) {
        validateDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;
        normalizeSign();
        this.isCacheValid = false;
    }
    
    // Конструктор по умолчанию
    public Fraction() {
        this(0, 1);
    }
    
    // Валидация знаменателя
    private void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю!");
        }
    }
    
    // Нормализация знаков (знаменатель всегда положительный)
    private void normalizeSign() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
    
    // Получение вещественного значения с кэшированием
    @Override
    public double getRealValue() {
        if (!isCacheValid || cachedRealValue == null) {
            cachedRealValue = (double) numerator / denominator;
            isCacheValid = true;
        }
        return cachedRealValue;
    }
    
    // Установка числителя
    @Override
    public void setNumerator(int numerator) {
        if (this.numerator != numerator) {
            this.numerator = numerator;
            invalidateCache();
        }
    }
    
    // Установка знаменателя
    @Override
    public void setDenominator(int denominator) {
        validateDenominator(denominator);
        if (this.denominator != denominator) {
            this.denominator = denominator;
            normalizeSign();
            invalidateCache();
        }
    }
    
    // Инвалидация кэша при изменении состояния
    private void invalidateCache() {
        this.isCacheValid = false;
        this.cachedRealValue = null;
    }
    
    // Геттеры
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }
    
    // Строковое представление
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    // Сравнение объектов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }
    
    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }
    
    // Сокращение дроби
    public Fraction simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        return new Fraction(numerator / gcd, denominator / gcd);
    }
    
    // Вычисление НОД (алгоритм Евклида)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}