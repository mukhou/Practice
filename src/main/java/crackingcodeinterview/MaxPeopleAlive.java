/* 
User: Urmi
Date: 12/21/2019 
Time: 1:10 PM
*/

/**
 * Given a list of people with their birth and death years, implement a method to
 * compute the year with the most number of people alive. You may assume that all people were born
 * between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should
 * be included in that year's count. For example, Person (birth = 1908, death = 1909) is included in the
 * counts for both 1908 and 1909.
 */
package crackingcodeinterview;

import java.util.Arrays;

//SEE EXPLANATION FROM CTCI, PG 496
//time complexity: 0 (P log P)
public class MaxPeopleAlive {

    public static int maxAlive(Person[] people, int min, int max) {
        int[] birthYears = getSortedYears(people, true);
        int[] deathYears = getSortedYears(people, false);

        int birthIndex = 0, deathIndex = 0;
        int currentAlive = 0, maxAlive = 0, maxAliveYear = min;

        /* Walk through arrays. */
        while (birthIndex < birthYears.length) {
            if (birthYears[birthIndex] < deathYears[deathIndex]) {
                currentAlive++;
                if (currentAlive > maxAlive) {
                    maxAlive = currentAlive;
                    maxAliveYear = birthYears[birthIndex];
                }
                //NOTE: the birthIndex should be increased AFTER the max check,
                // otherwise the birthIndex will be incorrect
                birthIndex++;
            } else {
                currentAlive--;
                deathIndex++;
            }
        }
        return maxAliveYear;
    }


    private static int[] getSortedYears(Person[] people, boolean birthYear) {
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            years[i] = birthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;

    }
}
