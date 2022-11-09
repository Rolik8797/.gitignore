import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ambitionStep = 1;
        System.out.println("Ваша цель - " + ambitionStep);

        String[] months = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Ноябрь","Декабрь"};

        StepTraker stepTraker = new StepTraker(months);

        while (true) {
        printMenu();
        int command = scanner.nextInt();

        if (command == 1) {
            System.out.println("За какой месяц вы хотите ввести шаги: ");
            for (int month = 0; month < months.length; month++) {
                System.out.println((month + 1) + " - " + months[month]);
            }

            int monthInt = scanner.nextInt();
            String month = months[monthInt - 1];

            System.out.println("За какой день месяца (от 1 до 30) вы хотите ввести шаги" + month);
            int day = scanner.nextInt();

            System.out.println("Количество шагов за " + day + " день месяца " + month);
            int step = scanner.nextInt();

            stepTraker.addSteps(month, day, step);
        } else if (command == 2) {
            System.out.println("За какой месяц вы хотите получить статистику");
            for (int month = 0; month < months.length; month++) {
                System.out.println((month + 1) + " - " + months[month]);
            }

            int monthInt = scanner.nextInt();
            String month = months[monthInt-1];

            stepTraker.goStepsInDay(month);
            stepTraker.sumStepMonth(month);
            stepTraker.maxStepMounth(month);
            stepTraker.averageStepMonth(month);
            stepTraker.distanceCovered(month);
            stepTraker.energySpent(month);
            stepTraker.bestSeries(ambitionStep, month);
        } else if (command == 3) {
            ambitionStep = stepTraker.newAmbitionStep();

            System.out.println("Ваша цель");
            System.out.println("Новая цель - " + ambitionStep);

        } else if (command == 0) {
            System.out.println("Выход");
            break;
        }  else {
            System.out.println("Такой команды пока нет");
        }

        }
        }
        public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день месяца");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
        }
    }