package dailychallenges.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalorieCounter {

    private List<Elf> elves = new ArrayList<>();

    public void readCalories(String path) {
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Elf elf = new Elf();
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    elf.setCalories(elf.getCalories() + Integer.parseInt(line.trim()));
                } else {
                    elf.setIndex(counter);
                    elves.add(elf);
                    elf = new Elf();
                    counter++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getTopThreeElves(int range) {
        elves.sort(Comparator.comparing(Elf::getCalories).reversed());
        Integer retVal = 0;
        for (int i = 0; i < range; i++) {
            retVal = retVal + elves.get(i).getCalories();
        }
        return retVal;
    }

    public Elf getElfWithMostCalories() {
        Elf elf = new Elf();
        for (Elf e : elves) {
            if (e.getCalories() > elf.getCalories()) {
                elf = e;
            }
        }
        return elf;
    }

    @Override
    public String toString() {
        return "CalorieCounter{" +
                "elves=" + elves +
                '}';
    }

    // region Getters/Setters
    public List<Elf> getElves() {
        return elves;
    }

    public void setElves(List<Elf> elves) {
        this.elves = elves;
    }
    // endregion
}
