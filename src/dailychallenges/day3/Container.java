package dailychallenges.day3;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private List<Rucksack> rucksackList = new ArrayList<>();
    private List<ElfGroup> groups = new ArrayList<>();

    // region Getters/Setters
    public List<Rucksack> getRucksackList() {
        return rucksackList;
    }

    public void setRucksackList(List<Rucksack> rucksackList) {
        this.rucksackList = rucksackList;
    }

    public List<ElfGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ElfGroup> groups) {
        this.groups = groups;
    }

    //endregion
}
