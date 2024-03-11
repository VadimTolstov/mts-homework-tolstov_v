package lesson_5;

public class Request {
    private Integer first;
    private Integer second;

    public Request(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Request{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
