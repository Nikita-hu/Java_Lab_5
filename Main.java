import java.util.function.Function;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.Box;

interface FractionOperations {
    double getRealValue(); // получение вещественного значения

    void setNumerator(int numerator); // установка числителя

    void setDenominator(int denominator); // установка знаменателя
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.1 \n3.9 \n4.4 \n5.5 \n6.1 \nВыбери тему задачи: ");
        String theme = scanner.nextLine();

        switch (theme) {
            case "1.1":
                System.out.println("ДРОБИ\n");

                boolean running = true;

                while (running) {
                    System.out.println("\nВыберите задачу для выполнения:");
                    System.out.println("1. Работа с дробями");
                    System.out.println("2. Выход");
                    System.out.print("Ваш выбор: ");

                    try {
                        int choice = Integer.parseInt(scanner.nextLine());

                        switch (choice) {
                            case 1:
                                FractionDemo.demo();
                                break;
                            case 2:
                                running = false;
                                System.out.println("Спасибо за использование приложения! До свидания!");
                                break;
                            default:
                                System.out.println("Ошибка: выберите число от 1 до 5!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: введите корректное число!");
                    }
                }

                break;

            case "3.9":
                System.out.println("=== ПРОГРАММА ДЛЯ ФОРМИРОВАНИЯ СПИСКА L ===");
                System.out.println("L содержит элементы, которые входят в один из списков L1 или L2,");
                System.out.println("но не входят в другой список\n");

                boolean running1 = true;

                while (running1) {
                    System.out.println("\nВыберите действие:");
                    System.out.println("1. Ввести списки вручную");
                    System.out.println("2. Посмотреть примеры работы");
                    System.out.println("3. Выход");
                    System.out.print("Ваш выбор: ");

                    try {
                        int choice = Integer.parseInt(scanner.nextLine());

                        switch (choice) {
                            case 1:
                                processManualInput(scanner);
                                break;
                            case 2:
                                showExamples();
                                break;
                            case 3:
                                running1 = false;
                                System.out.println("Программа завершена. До свидания!");
                                break;
                            default:
                                System.out.println("Ошибка: выберите число от 1 до 3!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: введите корректное число!");
                    }
                }

                scanner.close();

                break;

            case "4.4":
                System.out.println("=== ОБРАБОТКА РЕЗУЛЬТАТОВ ПРЕДВАРИТЕЛЬНОГО ТЕСТИРОВАНИЯ ===");

                System.out.println("Выберите режим:");
                System.out.println("1. Демонстрация с тестовыми данными");
                System.out.println("2. Ручной ввод данных");
                System.out.print("Ваш выбор: ");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            TestingDemo.demo();
                            break;
                        case 2:
                            runManualMode(scanner);
                            break;
                        default:
                            System.out.println("Неверный выбор");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число 1 или 2");
                }
                break;

            case "5.5":
                System.out.println("=== ПОИСК ЗВОНКИХ СОГЛАСНЫХ В ТЕКСТЕ ===");
                System.out.println("Программа находит все звонкие согласные буквы,");
                System.out.println("которые входят более чем в одно слово, и выводит их в алфавитном порядке.\n");

                boolean running2 = true;

                while (running2) {
                    System.out.println("Выберите источник текста:");
                    System.out.println("1. Загрузить из файла");
                    System.out.println("2. Выход");
                    System.out.print("Ваш выбор: ");

                    try {
                        int choice = Integer.parseInt(scanner.nextLine());

                        switch (choice) {
                            case 1:
                                processFileInput(scanner);
                                break;
                            case 2:
                                running2 = false;
                                System.out.println("Программа завершена. До свидания!");
                                break;
                            default:
                                System.out.println("Ошибка: выберите число от 1 до 4!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: введите корректное число!");
                    } catch (Exception e) {
                        System.out.println("Произошла ошибка: " + e.getMessage());
                    }
                }

                break;

            case "6.1":
                // Создаем очередь
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(10);
                queue.offer(20);
                queue.offer(30);
                queue.offer(40);
                queue.offer(50);

                System.out.println("Исходная очередь: " + queue);

                // Создаем объект QueueReverser и используем его
                ReverseQueueArrayStack.QueueReverser reverser = new ReverseQueueArrayStack.QueueReverser(queue);
                reverser.printInReverse();

                break;
            default:
                System.out.println("Нет такой темы!");
        }
        scanner.close();
    }

    private static void processManualInput(Scanner scanner) {
        try {
            System.out.println("\n=== ВВОД ДАННЫХ ===");

            List<Object> list1 = readList(scanner, "L1");
            List<Object> list2 = readList(scanner, "L2");

            SymmetricDifferenceProcessor processor = new SymmetricDifferenceProcessor(list1, list2);

            System.out.println("\n=== РЕЗУЛЬТАТ ===");
            System.out.println(processor);

            // Детальный анализ
            System.out.println("\nЖелаете увидеть детальный анализ? (да/нет): ");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("да") || answer.equals("yes") || answer.equals("y")) {
                processor.printDetailedAnalysis();
            }

        } catch (Exception e) {
            System.out.println("Ошибка при обработке ввода: " + e.getMessage());
        }
    }

    private static List<Object> readList(Scanner scanner, String listName) {
        System.out.println("\nВведите элементы списка " + listName + " через запятую:");
        System.out.print("> ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        // Просто разбиваем по запятой
        String[] elements = input.split(",");
        List<Object> result = new ArrayList<>();

        for (String element : elements) {
            // Убираем пробелы и добавляем как строку
            result.add(element.trim());
        }

        return result;
    }

    private static void showExamples() {
        System.out.println("\n=== ПРИМЕРЫ РАБОТЫ ПРОГРАММЫ ===\n");

        // Пример 1
        System.out.println("Пример 1:");
        List<Object> l1_1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Object> l2_1 = Arrays.asList(4, 5, 6, 7, 8);
        SymmetricDifferenceProcessor p1 = new SymmetricDifferenceProcessor(l1_1, l2_1);
        System.out.println(p1);
        p1.printDetailedAnalysis();

        // Пример 2
        System.out.println("\nПример 2:");
        List<Object> l1_2 = Arrays.asList("яблоко", "банан", "апельсин", "виноград");
        List<Object> l2_2 = Arrays.asList("банан", "виноград", "киви", "манго");
        SymmetricDifferenceProcessor p2 = new SymmetricDifferenceProcessor(l1_2, l2_2);
        System.out.println(p2);

        // Пример 3 (с повторениями)
        System.out.println("\nПример 3 (с повторяющимися элементами):");
        List<Object> l1_3 = Arrays.asList("яблоко", "яблоко", "банан", "банан", "апельсин");
        List<Object> l2_3 = Arrays.asList("банан", "апельсин", "апельсин", "киви", "манго");
        SymmetricDifferenceProcessor p3 = new SymmetricDifferenceProcessor(l1_3, l2_3);
        System.out.println(p3);

        // Пример 4 (один список пустой)
        System.out.println("\nПример 4 (L2 - пустой список):");
        List<Object> l1_4 = Arrays.asList(1, 2, 3);
        List<Object> l2_4 = Arrays.asList();
        SymmetricDifferenceProcessor p4 = new SymmetricDifferenceProcessor(l1_4, l2_4);
        System.out.println(p4);

        // Пример 5 (смешанные типы)
        System.out.println("\nПример 5 (смешанные типы):");
        List<Object> l1_5 = Arrays.asList("1", "2", "3", "4", "5");
        List<Object> l2_5 = Arrays.asList(4, 5, 6, 7, 8);
        SymmetricDifferenceProcessor p5 = new SymmetricDifferenceProcessor(l1_5, l2_5);
        System.out.println(p5);
    }

    private static void runManualMode(Scanner scanner) {
        TestingResultsProcessor processor = new TestingResultsProcessor();

        try {
            // Ввод количества абитуриентов
            System.out.print("Введите количество абитуриентов (N): ");
            int n = Integer.parseInt(scanner.nextLine());

            if (n <= 0 || n > 500) {
                System.out.println("Ошибка: количество абитуриентов должно быть от 1 до 500");
                return;
            }

            // Ввод данных об абитуриентах
            System.out.println("\nВведите данные об абитуриентах (в формате: Фамилия Имя Балл1 Балл2):");

            for (int i = 1; i <= n; i++) {
                System.out.print("Абитуриент " + i + ": ");
                String line = scanner.nextLine();

                try {
                    Applicant applicant = TestingResultsProcessor.parseApplicant(line);
                    processor.addApplicant(applicant);
                    System.out.println("✓ Добавлен: " + applicant);
                } catch (Exception e) {
                    System.out.println("✗ Ошибка: " + e.getMessage() + " - строка пропущена");
                    i--; // Повторяем ввод для этого абитуриента
                }
            }

            // Вывод результатов
            printResults(processor);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректное число абитуриентов");
        }
    }

    // ИЗМЕНЕНИЕ: делаем метод public static
    private static void printResults(TestingResultsProcessor processor) {
        System.out.println("\n=== РЕЗУЛЬТАТЫ ОБРАБОТКИ ===");

        // Вывод всех абитуриентов
        System.out.println("\nВсе абитуриенты:");
        for (Applicant applicant : processor.getAllApplicants()) {
            System.out.println("  " + applicant);
        }

        // Вывод неудачников
        System.out.println("\nНе допущены к экзаменам:");
        List<String> failedNames = processor.getFailedApplicantsNames();
        if (failedNames.isEmpty()) {
            System.out.println("  Все абитуриенты допущены!");
        } else {
            for (String name : failedNames) {
                System.out.println("  " + name);
            }
        }

        // Статистика
        processor.printStatistics();
    }


    private static void processFileInput(Scanner scanner) {
        System.out.println("\n=== ЗАГРУЗКА ИЗ ФАЙЛА ===");

        File file = new File("file_task5.txt");
        if (!file.exists() || !file.isFile()) {
            System.out.println("Ошибка: файл не существует или путь указан неверно!");
            return;
        }

        try {
            VoicedConsonantAnalyzer analyzer = new VoicedConsonantAnalyzer(file);
            System.out.println("Файл успешно загружен!");
            analyzer.printStatistics();
            analyzer.printResult();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
