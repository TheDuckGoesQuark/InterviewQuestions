package interview.sort5;

public class Horse {
    private final int finishTime;

    public Horse(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    @Override
    public String toString() {
        return String.valueOf(finishTime);
    }
}
