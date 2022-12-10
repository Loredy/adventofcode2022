package dailychallenges.day3;

public class Item {
    private String value;
    private Character type;
    private Integer priority;

    public Item() {

    }

    public Item(String value, Character type, Integer priority) {
        this.value = value;
        this.type = type;
        this.priority = priority;
    }

    //region Getters/Setters

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    //endregion
}
