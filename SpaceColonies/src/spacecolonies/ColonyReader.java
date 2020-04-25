// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * Class to read text files of information into planets and people
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * Read a file list of planets and people into an arrayqueue of people and
     * an array of planets
     * 
     * @param applicantFileName
     *            file list of people
     * @param planetFileName
     *            file list of planets
     * @throws ParseException
     *             if the formatting of the lists is incorrect
     * @throws SpaceColonyDataException
     *             if the skills are not between 1 and 5
     * @throws FileNotFoundException
     *             if the file names can not find a file
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        this.planets = this.readPlanetFile(planetFileName);
        this.queue = this.readQueueFile(applicantFileName);
        new SpaceWindow(new ColonyCalculator(queue, planets));
    }


    /**
     * helper method to read the planet file from the file name
     * 
     * @param fileName
     *            file name
     * @return Planet array
     * @throws ParseException
     *             if the formatting is incorrect
     * @throws SpaceColonyDataException
     *             if the skills are not between 1 and 5
     * @throws FileNotFoundException
     *             if the file name can not find a file
     */
    private Planet[] readPlanetFile(String fileName)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        Planet[] temp = new Planet[ColonyCalculator.NUM_PLANETS];
        Scanner scanner = new Scanner(new File(fileName));
        int count = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            try {
                String name = split[0].trim();
                int ag = Integer.parseInt(split[1].trim());
                int med = Integer.parseInt(split[2].trim());
                int tech = Integer.parseInt(split[3].trim());
                int cap = Integer.parseInt(split[4].trim());
                if (!isInSkillRange(ag, med, tech)) {
                    throw new SpaceColonyDataException("");
                }
                temp[count] = new Planet(name, ag, med, tech, cap);
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
        return temp;
    }


    /**
     * helper method to read a list of people from a file and create an
     * ArrayQueue of Person objects from it
     * 
     * @param fileName
     *            file name
     * @return ArrayQueue of Persons
     * @throws ParseException
     *             if the file has invalid formatting
     * @throws SpaceColonyDataException
     *             if the skills are not between 1 and 5
     * @throws FileNotFoundException
     *             if the file can not be founds
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        ArrayQueue<Person> temp = new ArrayQueue<Person>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            try {
                String name = split[0].trim();
                int ag = Integer.parseInt(split[1].trim());
                int med = Integer.parseInt(split[2].trim());
                int tech = Integer.parseInt(split[3].trim());
                String pref = "";
                if (split.length == 5) {
                    pref = split[4].trim();
                }
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


    /**
     * helper method to determine if the numbers are not between 1 and 5
     * 
     * @param num1
     *            first number to check
     * @param num2
     *            second number to check
     * @param num3
     *            third number to check
     * @return if all 3 number are within 1 and 5
     */
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
