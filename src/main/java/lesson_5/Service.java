package lesson_5;

public class Service {
    private final DataHelper dataHelper;

    public Service(DataHelper dataHelper) {
        this.dataHelper = dataHelper;
    }

    public int sum(Integer first, Integer second) {
        System.out.println(">> sum() first  " + first + " second " + second);
        if (first == null) {
            throw new RuntimeException("Первый параметр равен null");
        }

        if (second == null) {
            System.out.println("Обнаружено пустое значение. Берем дефолтное ");
            second = Fetcher.getDefaultValue();
        }

        if (first > second) {
            try {
                System.out.println("Обращение к серверу dataHelper");
                first = dataHelper.checkForInteger(second);
                System.out.println("Получено значение из dataHelper " + first);
            } catch (RuntimeException e) {
                throw new RuntimeException("Произошла ошибка при обращение к dataHelper");
            }
            System.out.println("Прекратили обращение ");
        }

        int result = first + second;
        System.out.println("<< sum() result " + result);
        return result;
    }

    public int sum2(Request request) {
        Integer first = request.getFirst();
        Integer second = request.getSecond();
        System.out.println(">> sum2() first  " + first + " second " + second);
        if (first == null) {
            throw new RuntimeException("Первый параметр равен null");
        }

        if (second == null) {
            System.out.println("Обнаружено пустое значение. Берем дефолтное ");
            second = Fetcher.getDefaultValue();
        }

        if (first > second) {
            try {
                System.out.println("Обращение к серверу dataHelper");
                first = dataHelper.checkForInteger(second);
                System.out.println("Получено значение из dataHelper " + first);
            } catch (RuntimeException e) {
                throw new RuntimeException("Произошла ошибка при обращение к dataHelper");
            }
            System.out.println("Прекратили обращение ");
        }

        int result = first + second;
        System.out.println("<< sum2() result " + result);
        return result;
    }
}
