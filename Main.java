import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("Введите строки (напишите 'quit" +
                "' для выхода):");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            list.add(input);
        }

        System.out.println("Ваш список:");
        for (int i = 0; i < list.size(); i++) { // Исправлено length() на size()
            System.out.println(list.get(i));
        }
        scanner.close();
    }
}