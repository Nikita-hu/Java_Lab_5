import java.util.*;

class SymmetricDifferenceProcessor {
    private List<Object> L1;
    private List<Object> L2;
    private List<Object> L;
    
    // Конструкторы
    public SymmetricDifferenceProcessor(List<Object> list1, List<Object> list2) {
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
        for (Object element : L1) {
            if (!L2.contains(element) && !L.contains(element)) {
                L.add(element);
            }
        }
        
        // Элементы из L2, которых нет в L1
        for (Object element : L2) {
            if (!L1.contains(element) && !L.contains(element)) {
                L.add(element);
            }
        }
    }
    
    // Методы для установки списков
    public void setList1(List<Object> list1) {
        this.L1 = new ArrayList<>(list1);
    }
    
    public void setList2(List<Object> list2) {
        this.L2 = new ArrayList<>(list2);
    }
    
    // Геттеры
    public List<Object> getL1() { return new ArrayList<>(L1); }
    public List<Object> getL2() { return new ArrayList<>(L2); }
    public List<Object> getL() { return new ArrayList<>(L); }
    
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
        
        List<Object> onlyInL1 = new ArrayList<>();
        List<Object> onlyInL2 = new ArrayList<>();
        
        for (Object element : L1) {
            if (!L2.contains(element) && !onlyInL1.contains(element)) {
                onlyInL1.add(element);
            }
        }
        
        for (Object element : L2) {
            if (!L1.contains(element) && !onlyInL2.contains(element)) {
                onlyInL2.add(element);
            }
        }
        
        System.out.println("Элементы только в L1: " + onlyInL1);
        System.out.println("Элементы только в L2: " + onlyInL2);
        System.out.println("Итоговый список L: " + L);
    }
}