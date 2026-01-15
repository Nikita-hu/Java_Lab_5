import java.util.*;
import java.util.Comparator;
class TestingDemo {
    public static void demo() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ РАБОТЫ ПРОГРАММЫ ===\n");
        
        TestingResultsProcessor processor = new TestingResultsProcessor();
        
        // Добавляем тестовые данные
        List<Applicant> testData = Arrays.asList(
            new Applicant("Иванов", "Иван", 85, 90),
            new Applicant("Петров", "Петр", 35, 45),
            new Applicant("Сидорова", "Анна", 95, 88),
            new Applicant("Кузнецов", "Алексей", 25, 60),
            new Applicant("Смирнова", "Мария", 70, 75),
            new Applicant("Васильев", "Дмитрий", 40, 39),
            new Applicant("Николаева", "Ольга", 90, 92),
            new Applicant("Алексеев", "Сергей", 38, 42)
        );
        
        for (Applicant applicant : testData) {
            processor.addApplicant(applicant);
        }
        
        // Выводим результаты
        System.out.println("Тестовые данные добавлены\n");
        
        System.out.println("Все абитуриенты:");
        for (Applicant applicant : processor.getAllApplicants()) {
            System.out.println("  " + applicant);
        }
        
        System.out.println("\nНе допущены к экзаменам:");
        List<String> failedNames = processor.getFailedApplicantsNames();
        for (String name : failedNames) {
            System.out.println("  " + name);
        }
        
        processor.printStatistics();
    }
}