package lesson_5;

public class DataHelper {
    public int check(Integer value) {
        switch (value) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 100;
            default:
                return 1000;
        }
    }

    public int checkForInteger(Integer value) {
        if (value == null) {
            return Fetcher.getDefaultValue();
        }
        switch (value) {
            case 1:
                return 100;
            case 2:
                return 300;
            case 3:
                return 1000;
            default:
                throw new RuntimeException("Ошибка при работе");
        }
    }

    public int checkForIntegerByString(String data) {
        if (data == null || data.isEmpty()) {
            return Fetcher.getDefaultValue();
        }
        int value = Integer.valueOf(data);
        switch (value) {
            case 1:
                return 100;
            case 2:
                return 300;
            case 3:
                return 1000;
            default:
                throw new RuntimeException("Ошибка при работе");
        }
    }
}
