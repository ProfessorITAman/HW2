import java.util.Random;

public class HW2_1 {
    public static void main(String[] args) {
            // Вызов метода permission с разными температурами и случайным возрастом
            System.out.println(permission(generateRandomAge(), 10));
            System.out.println(permission(generateRandomAge(), -15));
            System.out.println(permission(generateRandomAge(), 25));
            System.out.println(permission(generateRandomAge(), 5));
            System.out.println(permission(generateRandomAge(), 30));
        }

        // Метод для генерации случайного возраста
        public static int generateRandomAge() {
            Random random = new Random();
            return random.nextInt(100); // Возраст от 0 до 99
        }

        // Метод permission с использованием switch и булевой логики
        public static String permission(int age, int temperature) {
            boolean canGoOut; // Логическая переменная для результата

            // Определение возрастной категории с использованием switch
            switch (getAgeCategory(age)) {
                case "YOUNG" -> // Для возраста до 20 лет, температура от 0 до 28
                        canGoOut = temperature >= 0 && temperature <= 28;
                case "ADULT" -> // Для возраста от 20 до 45, температура от -20 до 30
                        canGoOut = temperature >= -20 && temperature <= 30;
                case "SENIOR" -> // Для возраста старше 45 лет, температура от -10 до 25
                        canGoOut = temperature >= -10 && temperature <= 25;
                default -> canGoOut = false;
            }

            // Возвращаем результат в зависимости от значения canGoOut
            return canGoOut ? "Можно идти гулять" : "Оставайтесь дома";
        }

        // Метод для определения категории возраста
        public static String getAgeCategory(int age) {
            if (age < 20) {
                return "YOUNG";
            } else if (age <= 45) {
                return "ADULT";
            } else {
                return "SENIOR";
            }
        }
    }
