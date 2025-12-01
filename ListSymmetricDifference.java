import java.util.*;

class SymmetricDifferenceProcessor {
    private List<Integer> L1;
    private List<Integer> L2;
    private List<Integer> L;
    
    // Конструкторы
    public SymmetricDifferenceProcessor(List<Integer> list1, List<Integer> list2) {
        this.L1 = new ArrayList<>(list1);
        this.L2 = new ArrayList<>(list2);
        this.L = new ArrayList<>();
        calculateSymmetricDifference();
    }
    
    public SymmetricDifferenceProcessor() {
        this.L1 = new ArrayList<>();
        this.L2 = new ArrayList<>();
        this.L = new ArrayList<>();
    }
    
    // Основной метод вычисления симметрической разности
    private void calculateSymmetricDifference() {
        L.clear();
        
        // Элементы из L1, которых нет в L2
        for (Integer element : L1) {
            if (!L2.contains(element) && !L.contains(element)) {
                L.add(element);
            }
        }
        
        // Элементы из L2, которых нет в L1
        for (Integer element : L2) {
            if (!L1.contains(element) && !L.contains(element)) {
                L.add(element);
            }
        }
    }
    
    // Альтернативная реализация с использованием Set
    public void calculateSymmetricDifferenceOptimized() {
        L.clear();
        
        Set<Integer> set1 = new HashSet<>(L1);
        Set<Integer> set2 = new HashSet<>(L2);
        
        // Находим элементы, которые есть только в L1
        Set<Integer> onlyInL1 = new HashSet<>(set1);
        onlyInL1.removeAll(set2);
        
        // Находим элементы, которые есть только в L2
        Set<Integer> onlyInL2 = new HashSet<>(set2);
        onlyInL2.removeAll(set1);
        
        // Объединяем результаты
        L.addAll(onlyInL1);
        L.addAll(onlyInL2);
    }
    
    // Методы для установки списков
    public void setList1(List<Integer> list1) {
        this.L1 = new ArrayList<>(list1);
    }
    
    public void setList2(List<Integer> list2) {
        this.L2 = new ArrayList<>(list2);
    }
    
    public void process() {
        calculateSymmetricDifferenceOptimized();
    }
    
    // Геттеры
    public List<Integer> getL1() { return new ArrayList<>(L1); }
    public List<Integer> getL2() { return new ArrayList<>(L2); }
    public List<Integer> getL() { return new ArrayList<>(L); }
    
    // Строковое представление
    @Override
    public String toString() {
        return String.format("L1: %s\nL2: %s\nL (элементы, которые есть в одном списке, но нет в другом): %s", 
                           L1, L2, L);
    }
    
    // Метод для детального анализа
    public void printDetailedAnalysis() {
        System.out.println("\n=== ДЕТАЛЬНЫЙ АНАЛИЗ ===");
        System.out.println("L1: " + L1);
        System.out.println("L2: " + L2);
        
        List<Integer> onlyInL1 = new ArrayList<>();
        List<Integer> onlyInL2 = new ArrayList<>();
        
        for (Integer element : L1) {
            if (!L2.contains(element) && !onlyInL1.contains(element)) {
                onlyInL1.add(element);
            }
        }
        
        for (Integer element : L2) {
            if (!L1.contains(element) && !onlyInL2.contains(element)) {
                onlyInL2.add(element);
            }
        }
        
        System.out.println("Элементы только в L1: " + onlyInL1);
        System.out.println("Элементы только в L2: " + onlyInL2);
        System.out.println("Итоговый список L: " + L);
    }
}
