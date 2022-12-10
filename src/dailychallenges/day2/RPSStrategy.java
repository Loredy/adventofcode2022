package dailychallenges.day2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RPSStrategy {
    private int score;
    private final List<Strategy> strategies = new ArrayList<>();

    public RPSStrategy(String path) {
        readStrategyFromFile(path);
        countTotalScore();
    }

    /*
     * X -> lose
     * Y -> draw
     * Z -> win
     * */
    private void readStrategyFromFile(String path) {
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Strategy s = new Strategy();
                s.setElfChoice(line.split(" ")[0]);
                String self = line.split(" ")[1];
                switch (self) {
                    case "X" -> {
                        switch (s.getElfChoice()) {
                            case "A" -> s.setUserChoice("Z");
                            case "B" -> s.setUserChoice("X");
                            case "C" -> s.setUserChoice("Y");
                        }
                    }
                    case "Y" -> {
                        switch (s.getElfChoice()) {
                            case "A" -> s.setUserChoice("X");
                            case "B" -> s.setUserChoice("Y");
                            case "C" -> s.setUserChoice("Z");
                        }
                    }
                    case "Z" -> {
                        switch (s.getElfChoice()) {
                            case "A" -> s.setUserChoice("Y");
                            case "B" -> s.setUserChoice("Z");
                            case "C" -> s.setUserChoice("X");
                        }
                    }
                }
                strategies.add(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void countTotalScore() {
        for (Strategy s : strategies) {
            score += countScore(s.getElfChoice(), s.getUserChoice());
        }
    }

    /*
     * Rock (A) - Rock (X) - 1p
     * Paper (B) - Paper (Y) - 2p
     * Scissor (C) - Scissor (Z) - 3p
     *
     * win: 6p
     * draw: 3p
     * lose: 0p
     * */
    private int countScore(String elfChoice, String userChoice) {
        int score = 0;
        switch (userChoice) {
            case "X" -> score += 1;
            case "Y" -> score += 2;
            case "Z" -> score += 3;
        }
        switch (elfChoice) {
            case "A" -> {
                switch (userChoice) {
                    case "X" -> score += 3;
                    case "Y" -> score += 6;
                }
            }
            case "B" -> {
                switch (userChoice) {
                    case "Y" -> score += 3;
                    case "Z" -> score += 6;
                }
            }
            case "C" -> {
                switch (userChoice) {
                    case "X" -> score += 6;
                    case "Z" -> score += 3;
                }
            }
        }
        return score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
