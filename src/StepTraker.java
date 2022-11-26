import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StepTraker {
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);
    HashMap<String, ArrayList<Integer>> monthOfDay;
    ArrayList<Integer> daysInMonth;

    StepTraker(String[] months) {
        monthOfDay = new HashMap<>();
        for (String month : months) {
            monthOfDay.put(month, new ArrayList<>());
        }

    }

    void addSteps(String month, int day, int step) {
        daysInMonth = new ArrayList<>();
        if (step >=0) {
            daysInMonth.set((day-1), step);
            monthOfDay.put(month, new ArrayList<>());
            System.out.println("Шаги сохранены.");
        } else {
            System.out.println("Количество шагов не может быть отрицательным.");
        }
    }

    void goStepsInDay (String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        for (int i = 0; i < stepsPerDay.size(); i++) {
            System.out.println((i+1) + " день: " + stepsPerDay.get(i));
        }
    }

    void sumStepMonth(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        System.out.println("За месяц вы прошли " + sumStepMonth + " шагов.");
    }

    void maxStepMounth(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int maxStepMonth = 0;
        for (Integer max : stepsPerDay) {
            if (max > maxStepMonth) {
                maxStepMonth = max;
            }
        }
        System.out.println("Максимальное количество шагов за " + month + " - " + maxStepMonth);
    }

    void  averageStepMonth (String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        int avergeStepMonth = sumStepMonth / stepsPerDay.size();
        System.out.println("Среднее количество шагов за " + month + " - " + avergeStepMonth);
    }

    void distanceCovered(String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        System.out.println("Пройденная дистанция за " + month + " - " + converter.distanceInKilometres(sumStepMonth) + " Километров");
    }

    void energySpent (String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        int sumStepMonth = 0;
        for (Integer sumStep : stepsPerDay) {
            sumStepMonth += sumStep;
        }
        System.out.println("Сожжено за " + month + " - " + converter.cCal(sumStepMonth) + " килокалорий");
    }

    void bestSeries(int ambitionStep, String month) {
        ArrayList<Integer> stepsPerDay = monthOfDay.get(month);
        ArrayList<Integer> listBestSeries = new ArrayList<>();
        int dayRow = 0;
        int i = 0;
        while (i < stepsPerDay.size()) {
            if (stepsPerDay.get(i) > ambitionStep) {
                dayRow++;
                System.out.println("серия - " + dayRow + " дней.");

            }
            listBestSeries.add(dayRow);
            i++;
        }

        int bestSeries = 0;
        for (Integer row : listBestSeries) {
            if (bestSeries < row) {
                bestSeries = row;
            }
        }
        System.out.println("Лучшая серия - " + (bestSeries) + " дней.");
    }
    int newAmbitionStep() {
        System.out.println("Введите новую цель по шагам в день");

        return scanner.nextInt();
    }
}
