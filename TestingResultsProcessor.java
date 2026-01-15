import java.util.*;
import java.util.Comparator;
class TestingResultsProcessor {
    private List<Applicant> applicants;
    private List<Applicant> failedApplicants;
    
    // Конструктор
    public TestingResultsProcessor() {
        this.applicants = new ArrayList<>();
        this.failedApplicants = new ArrayList<>();
    }
    
    // Добавление абитуриента
    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
        if (applicant.isFailed()) {
            failedApplicants.add(applicant);
        }
    }
    
    // Парсинг строки с данными абитуриента
    public static Applicant parseApplicant(String line) {
        try {
            // Разделяем строку по пробелам
            String[] parts = line.split(" ");
            
            if (parts.length < 4) {
                throw new IllegalArgumentException("Недостаточно данных в строке: " + line);
            }
            
            // Фамилия - первая часть
            String lastName = parts[0];
            
            // Имя - вторая часть
            String firstName = parts[1];
            
            // Баллы - последние две части
            int score1 = Integer.parseInt(parts[parts.length - 2]);
            int score2 = Integer.parseInt(parts[parts.length - 1]);
            
            return new Applicant(lastName, firstName, score1, score2);
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка парсинга строки: " + line + " - " + e.getMessage());
        }
    }
    
    // Получение списка неудачников
    public List<String> getFailedApplicantsNames() {
        List<String> result = new ArrayList<>();
        for (Applicant applicant : failedApplicants) {
            result.add(applicant.toShortString());
        }
        return result;
    }
    
    // Получение подробной информации о неудачниках
    public List<Applicant> getFailedApplicants() {
        return new ArrayList<>(failedApplicants);
    }
    
    // Получение статистики
    public void printStatistics() {
        int total = applicants.size();
        int passed = total - failedApplicants.size();
        int failed = failedApplicants.size();
        
        System.out.println("\n=== СТАТИСТИКА ТЕСТИРОВАНИЯ ===");
        System.out.println("Всего абитуриентов: " + total);
        System.out.println("Допущено к экзаменам: " + passed);
        System.out.println("Не допущено: " + failed);
    }
    
    // Геттеры
    public List<Applicant> getAllApplicants() { return new ArrayList<>(applicants); }
    public int getTotalCount() { return applicants.size(); }
    public int getFailedCount() { return failedApplicants.size(); }
}
