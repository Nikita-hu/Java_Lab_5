import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueArrayStack {
    // Внутренний класс, содержащий основную логику
    public static class QueueReverser {
        private Queue<Integer> queue;
        
        // Конструктор принимает очередь
        public QueueReverser(Queue<Integer> queue) {
            this.queue = queue;
        }
        
        // Метод для печати очереди в обратном порядке
        public void printInReverse() {
            if (queue.isEmpty()) {
                System.out.println("Очередь пуста!");
                return;
            }
            
            // 1. Создаем массив из очереди
            int size = queue.size();
            int[] array = new int[size];
            
            // Копируем элементы в массив
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            for (int i = 0; i < size; i++) {
                array[i] = tempQueue.poll();
            }
            
            // 2. Помещаем массив в стек
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < size; i++) {
                stack.push(array[i]);
            }
            
            // 3. Выводим из стека
            System.out.println("Элементы в обратном порядке:");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
        
        // Дополнительный метод для получения очереди
        public Queue<Integer> getQueue() {
            return new LinkedList<>(queue); // Возвращаем копию
        }
    }
}