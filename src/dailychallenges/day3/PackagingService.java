package dailychallenges.day3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PackagingService {

    public List<ElfGroup> getGroups(List<Rucksack> rucksackList) {
        List<ElfGroup> groupList = new ArrayList<>();
        ElfGroup elfGroup;
        String[] group = new String[3];
        for (int i = 0; i < rucksackList.size(); i++) {
            int index = i % 3;
            group[index] = rucksackList.get(i).getItemsString();
            if ((index + 1) % 3 == 0) {
                elfGroup = new ElfGroup();
                Character type = getGroupType(group);
                elfGroup.setType(type);
                elfGroup.setPriority(getPriorityByType(type));
                groupList.add(elfGroup);
            }
        }
        return groupList;
    }

    public Container getRucksacks(String path) {
        File file = new File(path);
        Container container = new Container();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String i1 = line.substring(0, (line.length() / 2));
                String i2 = line.substring(line.length() / 2);

                Character itemType = getItemType(i1, i2);
                Integer priority = getPriorityByType(itemType);

                Item item1 = new Item(i1, itemType, priority);
                Item item2 = new Item(i1, itemType, priority);

                container.getRucksackList().add(new Rucksack(line, item1, item2));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return container;
    }

    private Character getItemType(String item1, String item2) {
        for (int i = 0; i < item1.length(); i++) {
            for (int j = 0; j < item2.length(); j++) {
                if (item1.charAt(i) == item2.charAt(j)) {
                    return item1.charAt(i);
                }
            }
        }
        return null;
    }

    private Character getGroupType(String[] items) {
        for (int i = 0; i < items[0].length(); i++) {
            for (int j = 0; j < items[1].length(); j++) {
                for (int k = 0; k < items[2].length(); k++) {
                    if (items[0].charAt(i) == items[1].charAt(j)
                            && items[0].charAt(i) == items[2].charAt(k)) return items[0].charAt(i);
                }
            }
        }
        return null;
    }

    private Integer getPriorityByType(Character type) {
        Integer counter = 0;
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            counter++;
            if (alphabet == type) return counter;
        }
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            counter++;
            if (alphabet == type) return counter;
        }
        return null;
    }

    public Integer getPrioritySum(List<Rucksack> rucksackList) {
        Integer retVal = 0;
        for (Rucksack rs : rucksackList) {
            retVal += rs.getItem1().getPriority();
        }
        return retVal;
    }

    public Integer getElfGroupPrioritySum(List<ElfGroup> groups) {
        Integer retVal = 0;
        for (ElfGroup rs : groups) {
            retVal += rs.getPriority();
        }
        return retVal;
    }
}
