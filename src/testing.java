import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        recurs(0);
    }

    public static void recurs(int newAct) {
        Scanner scan = new Scanner(System.in);
        int act = newAct;
        System.out.println("Выберите действие");
        System.out.println("1. Зашифровать шифром Цезаря");
        System.out.println("2. Расшифровать шифром Цезаря");
        System.out.println("3. Зашифровать шифром Виженера");
        System.out.println("4. Расшифровать шифром Виженера");
        System.out.println("5. Завершить работу");
        act = scan.nextInt();
        System.out.println("Введите строку");
        String message = scan.next();
        System.out.println("Введите ключ");
        switch (act) {
            case 1 -> {
                int key = scan.nextInt();
                Ceasar ceasar = new Ceasar(key, message);
                System.out.println("Зашифровано шифром Цезаря:");
                System.out.println(ceasar.cipherOrDecipher());
                recurs(0);
            }
            case 2 -> {
                int key = scan.nextInt();
                Ceasar ceasar = new Ceasar(-key, message);
                System.out.println("Расшифровано шифром Цезаря:");
                System.out.println(ceasar.cipherOrDecipher());
                recurs(0);
            }
            case 3 -> {
                String key = scan.next();
                Vijener vijener = new Vijener(key, message, true);
                System.out.println("Зашифровано шифром Виженера:");
                System.out.println(vijener.cipherOrDecipher());
                recurs(0);
            }
            case 4 -> {
                String key = scan.next();
                Vijener vijener = new Vijener(key, message, false);
                System.out.println("Расшифровано шифром Виженера:");
                System.out.println(vijener.cipherOrDecipher());
                recurs(0);
            }
            case 5 -> {
                return;
            }
        }
    }
}
