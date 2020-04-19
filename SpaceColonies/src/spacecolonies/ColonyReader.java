package spacecolonies;

import java.util.ArrayList;
import java.util.Scanner;
import bsh.ParseException;

public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    public ColonyReader(String applicantFileName, String planetFileName)
        throws ParseException,
        SpaceColonyDataException {
        this.planets = this.readPlanetFile(planetFileName);
        this.queue = this.readQueueFile(applicantFileName);
        new SpaceWindow(new ColonyCalculator(queue, planets));
    }


    private Planet[] readPlanetFile(String fileName)
        throws ParseException,
        SpaceColonyDataException {
        ArrayList<Planet> temp = new ArrayList<Planet>();
        Scanner scanner = new Scanner(fileName);
        int count = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            try {
                String name = split[0];
                int ag = Integer.parseInt(split[1]);
                int med = Integer.parseInt(split[2]);
                int tech = Integer.parseInt(split[3]);
                int cap = Integer.parseInt(split[4]);
                if (!isInSkillRange(ag, med, tech)) {
                    throw new SpaceColonyDataException("");
                }
                temp.add(new Planet(name, ag, med, tech, cap));
            }
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new ParseException("Invalid Planet text Formatting");
            }
            catch (SpaceColonyDataException e) {
                throw new SpaceColonyDataException("Skills not in range (1,5)");
            }
            count++;
        }
        if (count != ColonyCalculator.NUM_PLANETS) {
            throw new SpaceColonyDataException(
                "Does not meet required Planets");
        }
        scanner.close();
        return (Planet[])temp.toArray();
    }


    private ArrayQueue<Person> readQueueFile(String fileName)
        throws ParseException,
        SpaceColonyDataException {
        ArrayQueue<Person> temp = new ArrayQueue<Person>();
        Scanner scanner = new Scanner(fileName);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            try {
                String name = split[0];
                int ag = Integer.parseInt(split[1]);
                int med = Integer.parseInt(split[2]);
                int tech = Integer.parseInt(split[3]);
                String pref = split[4];
                if (!isInSkillRange(ag, med, tech)) {
                    throw new SpaceColonyDataException("");
                }
                temp.enqueue(new Person(name, ag, med, tech, pref));
            }
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new ParseException("Invalid Person text Formatting");
            }
            catch (SpaceColonyDataException e) {
                throw new SpaceColonyDataException("Skills not in range (1,5)");
            }
        }
        scanner.close();
        return temp;
    }


    private boolean isInSkillRange(int num1, int num2, int num3) {
        int[] nums = { num1, num2, num3 };
        for (int num : nums) {
            if (num < ColonyCalculator.MIN_SKILL_LEVEL
                || num > ColonyCalculator.MAX_SKILL_LEVEL) {
                return false;
            }
        }
        return true;
    }
}
