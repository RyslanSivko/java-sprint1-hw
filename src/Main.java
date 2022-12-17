import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
           if (userInput == 1){
               stepTracker.setSteps(scanner);
           }
           else if (userInput == 2){
                stepTracker.showMonthData(scanner);
           }
           else if (userInput == 3){
               stepTracker.stepsChanger(scanner);
           }
           else {
               System.out.println("такой команды нет");
           }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый месяц и день ");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - выход");
    }

}

