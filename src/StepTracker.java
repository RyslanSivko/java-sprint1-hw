import java.util.Scanner;

public class StepTracker {
    int aimSteps = 10000;
    Converter converter = new Converter();
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
   static class MonthData {
        public int[] days;
        public MonthData() {
            days = new int[30];
        }
    }

    public void setSteps(Scanner scanner) {//ввод шагов за определенный день
        while (true) {
            System.out.println("введите месяц, день и количество шагов");
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int steps = scanner.nextInt();
            if (steps >= 0 && month > 0 && month <= 12 && day > 0 && day <= 30) {
                monthToData[month - 1].days[day - 1] = steps;
                System.out.println("вы ввели количество шагов");
                break;
            } else if (steps < 0) {
                System.out.println("колчиество шагов должно быть неотрицательным");
            } else if (month <= 0 || month > 12) {
                System.out.println("месяц должен быть в промежутке от 1 до 12");
            } else if (day <= 0 || day > 30) {
                System.out.println("день должен быть в промежутке от 1 до 30 ");
            }
        }
    }
    public void showMonthData(Scanner scanner) {//статистика
        //Количество пройденных шагов по дням
        while (true) {
            System.out.println("за какой месяц");
            int month = scanner.nextInt();
            if (month > 0 && month < 12) {
                for (int i = 0; i < monthToData[month - 1].days.length-1; i++) {
                    System.out.printf((i + 1) + " День: " + monthToData[month - 1].days[i] + ", ");
                }
                System.out.printf(30 + " День: " + monthToData[month - 1].days[29] + ". ");

                //Максимальное пройденное количество шагов в месяце
                int max = monthToData[month - 1].days[0];
                for (int i = 0; i < monthToData[month - 1].days.length; i++) {
                    if (max < monthToData[month - 1].days[i]) {
                        max = monthToData[month - 1].days[i];
                    }
                }
                System.out.println("\nМаксимальное пройденное количество шагов в месяце " + max);

                //Общее количество шагов за месяц
                double summ = 0;//Общее количество шагов за месяц
                for (int i = 0; i < monthToData[month - 1].days.length; i++) {
                    summ += monthToData[month - 1].days[i];
                }
                System.out.println("Общее количество шагов за месяц " + summ);

                //Среднее количество шагов за месяц
                int sum = 0;
                for (int i = 0; i < monthToData[month - 1].days.length; i++) {
                    sum += monthToData[month - 1].days[i];
                }
                System.out.println("Среднее количество шагов за месяц " + sum / 30);

                converter.stepsToKm(summ);
                converter.stepsToKl(summ);

                int streak = 0;
                int maxStreak = 0;
                for (int j = 0; j < monthToData[month - 1].days.length; j++) {
                    if (monthToData[month - 1].days[j] >= aimSteps) {
                        streak++;
                        if (maxStreak < streak) {
                            maxStreak = streak;
                        }
                    } else {
                        streak = 0;
                    }
                }
                System.out.println("максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого = " + maxStreak);
                break;
            } else if (month <= 0 || month > 12) {
                System.out.println("выберите номер месяца от 1 до 12");
            }
        }
    }

        public void stepsChanger (Scanner scanner){
        while(true) {
            System.out.println("введите новое значение цели по шагам");
            aimSteps = scanner.nextInt();
            if (aimSteps >= 0) {
                System.out.println("ваша новая цель по шагам теперь = " + aimSteps);
            break;
            }
            else{
                System.out.println("целевое количество шагов должно быть неотрицательным");
            }
        }
    }
}