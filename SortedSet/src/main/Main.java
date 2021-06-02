package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringComparator stringComparator = new StringComparator();
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Welcome");
        myList.add("To");
        myList.add("Fo");
        myList.add("Geeks");
        
        MySortedSet<String> mySortedSet = new MySortedSet<>(myList, stringComparator);
        mySortedSet.add("Pop");
        mySortedSet.display();

        System.out.println();
        MySortedSet<String> mySortedSet2 = new MySortedSet<>(mySortedSet.subSet("Fo","Pop"),stringComparator);
        mySortedSet2.display();

        System.out.println();
        MySortedSet<String> mySortedSet3 = new MySortedSet<>(mySortedSet.headSet("Pop"),stringComparator);
        mySortedSet3.add("mu");
        mySortedSet3.display();

        System.out.println();
        MySortedSet<String> mySortedSet4 = new MySortedSet<>(mySortedSet.tailSet("Pop"),stringComparator);
        mySortedSet4.display();
    }
}
