package dailychallenges.day1;

public class Elf {
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;
    private Integer calories = 0;

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "calories=" + calories +
                '}';
    }
}
