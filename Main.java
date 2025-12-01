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

            List<Integer> list1 = readList(scanner, "L1");
            List<Integer> list2 = readList(scanner, "L2");

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

    private static List<Integer> readList(Scanner scanner, String listName) {
        System.out.println("\nВведите элементы списка " + listName + ":");
        System.out.println("(числа через пробел, например: 1 2 3 4 5)");
        System.out.print("> ");

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Список " + listName + " будет пустым");
            return new ArrayList<>();
        }

        String[] elements = input.split("\\s+");
        List<Integer> list = new ArrayList<>();

        for (String element : elements) {
            try {
                list.add(Integer.parseInt(element));
            } catch (NumberFormatException e) {
                System.out.println("Предупреждение: '" + element + "' не является целым числом и будет пропущено");
            }
        }

        // Удаляем дубликаты, сохраняя порядок
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer num : list) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }

        System.out.println("Список " + listName + " (без дубликатов): " + uniqueList);
        return uniqueList;
    }

    private static void showExamples() {
        System.out.println("\n=== ПРИМЕРЫ РАБОТЫ ПРОГРАММЫ ===\n");

        // Пример 1
        System.out.println("Пример 1:");
        List<Integer> l1_1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2_1 = Arrays.asList(4, 5, 6, 7, 8);
        SymmetricDifferenceProcessor p1 = new SymmetricDifferenceProcessor(l1_1, l2_1);
        System.out.println(p1);
        p1.printDetailedAnalysis();

        // Пример 2
        System.out.println("\nПример 2:");
        List<Integer> l1_2 = Arrays.asList(10, 20, 30, 40);
        List<Integer> l2_2 = Arrays.asList(20, 40, 60, 80);
        SymmetricDifferenceProcessor p2 = new SymmetricDifferenceProcessor(l1_2, l2_2);
        System.out.println(p2);

        // Пример 3 (с повторениями)
        System.out.println("\nПример 3 (с повторяющимися элементами):");
        List<Integer> l1_3 = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
        List<Integer> l2_3 = Arrays.asList(2, 3, 3, 5, 6, 7);
        SymmetricDifferenceProcessor p3 = new SymmetricDifferenceProcessor(l1_3, l2_3);
        System.out.println(p3);

        // Пример 4 (один список пустой)
        System.out.println("\nПример 4 (L2 - пустой список):");
        List<Integer> l1_4 = Arrays.asList(1, 2, 3);
        List<Integer> l2_4 = Arrays.asList();
        SymmetricDifferenceProcessor p4 = new SymmetricDifferenceProcessor(l1_4, l2_4);
        System.out.println(p4);

        // Пример 5 (отрицательные числа)
        System.out.println("\nПример 5 (с отрицательными числами):");
        List<Integer> l1_5 = Arrays.asList(-5, -3, 0, 1, 3);
        List<Integer> l2_5 = Arrays.asList(-3, 0, 2, 4, 6);
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
    public static void printResults(TestingResultsProcessor processor) {
        // Вывод статистики
        processor.printStatistics();

        // Вывод списка недопущенных абитуриентов
        List<Applicant> failedApplicants = processor.getFailedApplicants();

        if (failedApplicants.isEmpty()) {
            System.out.println("\nВсе абитуриенты допущены к сдаче экзаменов в первом потоке!");
        } else {
            System.out.println("\n=== АБИТУРИЕНТЫ, НЕ ДОПУЩЕННЫЕ К ЭКЗАМЕНАМ В ПЕРВОМ ПОТОКЕ ===");

            // Сортируем по фамилии для удобства чтения
            failedApplicants.sort(Comparator.comparing(Applicant::getLastName));

            for (int i = 0; i < failedApplicants.size(); i++) {
                Applicant applicant = failedApplicants.get(i);
                System.out.println((i + 1) + ". " + applicant.toShortString() +
                        " (баллы: " + applicant.getSubject1Score() + ", " +
                        applicant.getSubject2Score() + ")");
            }

            // Дополнительный анализ причин неудачи
            analyzeFailureReasons(failedApplicants);
        }
    }

    private static void analyzeFailureReasons(List<Applicant> failedApplicants) {
        int failedSubject1 = 0;
        int failedSubject2 = 0;
        int failedBoth = 0;

        for (Applicant applicant : failedApplicants) {
            boolean failed1 = applicant.getSubject1Score() < 30;
            boolean failed2 = applicant.getSubject2Score() < 30;

            if (failed1 && failed2) {
                failedBoth++;
            } else if (failed1) {
                failedSubject1++;
            } else {
                failedSubject2++;
            }
        }

        System.out.println("\n=== АНАЛИЗ ПРИЧИН НЕУДАЧИ ===");
        System.out.println("Не сдали только первый предмет: " + failedSubject1);
        System.out.println("Не сдали только второй предмет: " + failedSubject2);
        System.out.println("Не сдали оба предмета: " + failedBoth);
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
