import java.util.*;
import java.util.Comparator;
class TestingDemo {
    public static void demo() {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ПРОГРАММЫ ===");
        
        // Создаем тестовые данные
        String[] testData = {
            "Ветров Роман 68 59",
            "Анисимова Екатерина 64 88", 
            "Петров Алексей 25 45",
            "Сидорова Мария 35 28",
            "Козлов Дмитрий 20 15",
            "Иванова Анна 75 90",
            "Смирнов Павел 29 31",
            "Фролова Ольга 45 25"
        };
        
        TestingResultsProcessor processor = new TestingResultsProcessor();
        
        System.out.println("Тестовые данные:");
        for (String line : testData) {
            try {
                Applicant applicant = TestingResultsProcessor.parseApplicant(line);
                processor.addApplicant(applicant);
                System.out.println("  " + applicant);
            } catch (Exception e) {
                System.out.println("  Ошибка: " + e.getMessage());
            }
        }
        
        // Теперь этот вызов будет работать
        Main.printResults(processor);
    }
}