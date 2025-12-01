import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

// Класс для обработки текста и поиска звонких согласных
class VoicedConsonantAnalyzer {
    private String text;
    private Set<Character> voicedConsonants;
    private Map<Character, Set<String>> consonantWords;
    
    // Конструктор
    public VoicedConsonantAnalyzer(String text) {
        this.text = text != null ? text : "";
        initializeVoicedConsonants();
        this.consonantWords = new HashMap<>();
        analyzeText();
    }
    
    // Конструктор из файла
    public VoicedConsonantAnalyzer(File file) throws IOException {
        this.text = readFile(file);
        initializeVoicedConsonants();
        this.consonantWords = new HashMap<>();
        analyzeText();
    }
    
    // Инициализация множества звонких согласных русского языка
    private void initializeVoicedConsonants() {
        voicedConsonants = new HashSet<>(Arrays.asList(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
        ));
    }
    
    // Чтение файла с правильной кодировкой
    private String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }
    
    // Анализ текста
    private void analyzeText() {
        // Разбиваем текст на слова
        String[] words = text.toLowerCase().split("[^а-яё]+");
        
        for (String word : words) {
            if (word.length() > 0) {
                processWord(word);
            }
        }
    }
    
    // Обработка одного слова
    private void processWord(String word) {
        Set<Character> consonantsInWord = new HashSet<>();
        
        // Находим все звонкие согласные в слове
        for (char c : word.toCharArray()) {
            if (voicedConsonants.contains(c)) {
                consonantsInWord.add(c);
            }
        }
        
        // Добавляем слово к каждой найденной согласной
        for (char consonant : consonantsInWord) {
            consonantWords.computeIfAbsent(consonant, k -> new HashSet<>()).add(word);
        }
    }
    
    // Получение звонких согласных, которые встречаются более чем в одном слове
    public List<Character> getConsonantsInMultipleWords() {
        List<Character> result = new ArrayList<>();
        
        for (Map.Entry<Character, Set<String>> entry : consonantWords.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getKey());
            }
        }
        
        // Сортируем в алфавитном порядке
        Collections.sort(result);
        return result;
    }
    
    // Получение детальной информации по согласным
    public Map<Character, Set<String>> getConsonantDetails() {
        return new HashMap<>(consonantWords);
    }
    
    // Получение статистики
    public void printStatistics() {
        List<Character> multiWordConsonants = getConsonantsInMultipleWords();
        
        System.out.println("\n=== СТАТИСТИКА АНАЛИЗА ===");
        System.out.println("Всего звонких согласных в русском языке: " + voicedConsonants.size());
        System.out.println("Найдено различных согласных в тексте: " + consonantWords.size());
        System.out.println("Согласные в более чем одном слове: " + multiWordConsonants.size());
    }
    
    // Вывод результата
    public void printResult() {
        List<Character> result = getConsonantsInMultipleWords();
        
        if (result.isEmpty()) {
            System.out.println("Нет звонких согласных, которые входят более чем в одно слово.");
        } else {
            System.out.println("\n=== ЗВОНКИЕ СОГЛАСНЫЕ, ВХОДЯЩИЕ БОЛЕЕ ЧЕМ В ОДНО СЛОВО ===");
            for (char consonant : result) {
                Set<String> words = consonantWords.get(consonant);
                System.out.printf("'%c' - встречается в %d словах: %s%n", 
                    consonant, words.size(), words);
            }
        }
    }
    
    // Геттеры
    public Set<Character> getVoicedConsonants() { return new HashSet<>(voicedConsonants); }
    public String getText() { return text; }
}
// Дополнительный утилитный класс для работы с русским текстом
class RussianTextUtils {
    // Проверка, является ли символ русской буквой
    public static boolean isRussianLetter(char c) {
        return (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'ё' || c == 'Ё';
    }
    
    // Проверка, является ли символ звонкой согласной
    public static boolean isVoicedConsonant(char c) {
        char lower = Character.toLowerCase(c);
        String voicedConsonants = "бвгджзйлмнр";
        return voicedConsonants.indexOf(lower) != -1;
    }
    
    // Получение всех звонких согласных
    public static Set<Character> getAllVoicedConsonants() {
        Set<Character> consonants = new HashSet<>();
        String voiced = "бвгджзйлмнр";
        for (char c : voiced.toCharArray()) {
            consonants.add(c);
        }
        return consonants;
    }
}