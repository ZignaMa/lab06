package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    /**
     *
     */
    private static final int READS = 1000;
    private static final int ELEMENTS = 100_000;
    private static final long AFRICA_POPULATION = 1_110_635_000;
    private static final long AMERICAS_POPULATION = 972_005_000;
    private static final long ANTARCTICA_POPULATION = 0;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION =742_452_000;
    private static final long OCEANIA_POPULATION = 38_304_000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new al<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> al= new ArrayList<>();
        
        for (int i = 1000; i < 2000; i++) {
            al.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> ll= new LinkedList<>(al);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer a = ll.get(ll.size()-1);
        ll.set(ll.size()-1, ll.get(0));
        ll.set(0, a);
        /*
         * 4) Using a single for-each, print the contents of the al.
         */
        for (Integer integer : al) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            al.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMENTS + " elements as first in an ArrayList took " + timeAsString(time));
        time = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            ll.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMENTS + " elements as first in a LinkedList took " + timeAsString(time));
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for (int i = 0; i < READS; i++) {
            al.get(al.size()/2);
        }
        time1 = System.nanoTime() - time1;
        System.out.println("Reading " + READS + " elements in the middle of an ArrayList took " + timeAsString(time1));
        time1 = System.nanoTime();
        for (int i = 0; i < READS; i++) {
            ll.get(ll.size()/2);
        }
        time1 = System.nanoTime() - time1;
        System.out.println("Reading " + READS + " elements in the middle of a LinkedList took " + timeAsString(time1));
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 4,298,723,000    *
         * Antarctica -> 742,452,000     * Asia ->        *
         * Europe -> 38,304,000    *
         * Oceania ->      */
        Map<String, Long>continentsMap= new HashMap<>();
        continentsMap.put("Africa", AFRICA_POPULATION);
        continentsMap.put("Americas", AMERICAS_POPULATION);
        continentsMap.put("Antarctica", ANTARCTICA_POPULATION);
        continentsMap.put("Asia", ASIA_POPULATION);
        continentsMap.put("Europe", EUROPE_POPULATION);
        continentsMap.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the continentsMap
         */
        long tot=0;
        for (long i : continentsMap.values()) {
            tot+=i;
        }
        System.out.println("We are ~" + tot + " humans beings on this pale blue dot (just enough to overflow integers :D).");
    }

    private static String timeAsString(final long nanoseconds) {
        return nanoseconds + "ns (" + NANOSECONDS.toMillis(nanoseconds) + "ms)";
    }
}
