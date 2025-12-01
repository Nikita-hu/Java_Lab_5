import java.util.*;
class FractionDemo {
    public static void demo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ С ДРОБЯМИ ===");
        
        try {
            // Создание дробей
            System.out.println("\nСоздаем дроби:");
            Fraction frac1 = new Fraction(3, 4);
            Fraction frac2 = new Fraction(-2, 5);
            Fraction frac3 = new Fraction(6, -8); // проверка нормализации знаков
            
            System.out.println("Дробь 1: " + frac1);
            System.out.println("Дробь 2: " + frac2);
            System.out.println("Дробь 3: " + frac3 + " (автоматическая нормализация знаков)");
            
            // Демонстрация кэширования
            System.out.println("\n--- Демонстрация кэширования ---");
            System.out.println("Вещественное значение дроби 1:");
            double value1 = frac1.getRealValue();
            System.out.println("Первый вызов: " + value1);
            double value2 = frac1.getRealValue();
            System.out.println("Второй вызов: " + value2);
            System.out.println("Значения одинаковые: " + (value1 == value2));
            
            // Изменение дроби и инвалидация кэша
            System.out.println("\nИзменяем числитель дроби 1 с 3 на 5...");
            frac1.setNumerator(5);
            System.out.println("Дробь 1 после изменения: " + frac1);
            System.out.println("Вещественное значение после изменения: " + frac1.getRealValue());
            
            // Сравнение дробей
            System.out.println("\n--- Сравнение дробей ---");
            Fraction frac4 = new Fraction(3, 4);
            Fraction frac5 = new Fraction(6, 8);
            
            System.out.println("Дробь 1: " + frac1);
            System.out.println("Дробь 4: " + frac4);
            System.out.println("Дробь 5: " + frac5);
            System.out.println("Дробь 1 равна дроби 4: " + frac1.equals(frac4));
            System.out.println("Дробь 4 равна дроби 5: " + frac4.equals(frac5));
            
            // Сокращение дробей
            System.out.println("\n--- Сокращение дробей ---");
            Fraction frac6 = new Fraction(15, 25);
            Fraction simplified = frac6.simplify();
            System.out.println("Исходная дробь: " + frac6);
            System.out.println("Сокращенная дробь: " + simplified);
            
            // Работа с пользовательским вводом
            System.out.println("\n--- Создание своей дроби ---");
            System.out.print("Введите числитель: ");
            int num = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Введите знаменатель: ");
            int denom = Integer.parseInt(scanner.nextLine());
            
            try {
                Fraction userFraction = new Fraction(num, denom);
                System.out.println("Ваша дробь: " + userFraction);
                System.out.println("Вещественное значение: " + userFraction.getRealValue());
                System.out.println("Сокращенная форма: " + userFraction.simplify());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}





