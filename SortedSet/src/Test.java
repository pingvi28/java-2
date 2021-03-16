import java.util.*;

public class Test {
    public static void main(String[] args) {
        StringComparator stringComparator = new StringComparator();
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Welcome");
        myList.add("To");
        myList.add("4");
        myList.add("Geeks");
        myList.add("Set");

        ArrayList<String> myList1 = new ArrayList<>();
        myList1.add("Welcome");
        myList1.add("To");
        myList1.add("Geeks");

        String[] arr = {"Welcome","Geeks"};

        MySortedSet<String> mySortedSet = new MySortedSet<>(myList, stringComparator);
        mySortedSet.add("Pop");
        mySortedSet.display();

        System.out.println(" ");
        MySortedSet<String> mySortedSet2 = new MySortedSet<> (mySortedSet.subSet("Pop","4"),stringComparator);
        mySortedSet2.display();

        System.out.println(" ");
        MySortedSet<String> mySortedSet3 = new MySortedSet<> (mySortedSet.headSet("Pop"),stringComparator);
        mySortedSet3.add("mu");
        mySortedSet3.display();

        System.out.println(" ");
        MySortedSet<String> mySortedSet4 = new MySortedSet<> (mySortedSet.tailSet("Pop"),stringComparator);
        mySortedSet4.display();
       // mySortedSet2.toString();

        //mySortedSet.add("Sett");
        //mySortedSet.display();
        //mySortedSet.addAll(myList1);
        //mySortedSet.display();
    }
}
