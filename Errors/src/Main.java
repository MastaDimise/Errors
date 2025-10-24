import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите мин. длину пароля: ");
            int minLength = scanner.nextInt();

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            int maxRepeats = scanner.nextInt();

            PasswordChecker checker = new PasswordChecker();
            checker.setMinLength(minLength);
            checker.setMaxRepeats(maxRepeats);
            scanner.nextLine();

            while (true) {
                System.out.print("Введите пароль или end: ");
                String password = scanner.nextLine();

                if ("end".equalsIgnoreCase(password)) {
                    break;
                }

                boolean isValid = checker.verify(password);
                if (isValid) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в настройках: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Программа завершена");
    }
}