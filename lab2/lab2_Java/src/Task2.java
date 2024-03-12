
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static class Triple {
        double first;
        double second;
        double third;

        public Triple(double first, double second, double third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public double getThird() {
            return third;
        }
    }

    public static void inequality() {
        Triple[] coefficients = {
                new Triple(1.0, 1.0, 1.0),
                new Triple(1.0, -4.0, 4.0),
                new Triple(2.0, -4.0, 4.0),
                new Triple(3.0, -4.0, 4.0),
                new Triple(1.0, -5.0, 6.0),
                new Triple(2.0, -5.0, 6.0),
                new Triple(5.0, -5.0, 6.0)
        };

        for (int i = 0; i < coefficients.length; i++) {
            Triple coefficient = coefficients[i];
            System.out.println("Результат для випадку " + (i + 1) + ":");

            double a = coefficient.getFirst();
            double b = coefficient.getSecond();
            double c = coefficient.getThird();

            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0 || a == 0.0) {
                System.out.println("Нерівність не має розв'язків");
            } else if (discriminant == 0.0) {
                double x = -b / (2 * a);
                if (a * x * x - b * x + c >= 0) {
                    System.out.println("Розв'язок: x є розв'язком нерівності для всіх x");
                } else {
                    System.out.println("Нерівність не має розв'язків");
                }
            } else {
                double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);

                List<Double> roots = new ArrayList<>();
                roots.add(x1);
                roots.add(x2);
                roots.sort(Double::compareTo);

                List<String> intervals = new ArrayList<>();

                if (a * roots.get(0) * roots.get(0) - b * roots.get(0) + c >= 0) {
                    intervals.add("(-∞; " + roots.get(0) + "]");
                }

                for (int j = 0; j < roots.size() - 1; j++) {
                    if (a * roots.get(j + 1) * roots.get(j + 1) - b * roots.get(j + 1) + c >= 0) {
                        intervals.add("(" + roots.get(j) + "; " + roots.get(j + 1) + "]");
                    }
                }

                if (a * roots.get(1) * roots.get(1) - b * roots.get(1) + c >= 0) {
                    intervals.add("(" + roots.get(1) + "; +∞)");
                }

                if (intervals.isEmpty()) {
                    System.out.println("Нерівність не має розв'язків");
                } else {
                    System.out.println("Розв'язок:");
                    for (String interval : intervals) {
                        System.out.println(interval);
                    }
                }
            }
            System.out.println(); // Друкуємо порожній рядок для читабельності
        }
    }
}