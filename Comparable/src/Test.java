import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
 /*2*/  Dog dog1 = new Dog("bulldog", 1.2, 100.5, true);
        Dog dog2 = new Dog("bulldog", 2.3, 200.78, true);
        Dog dog3 = new Dog("bull", 0.8, 15.4, false);
        Dog dog4 = new Dog("bull", 0.7, 19.84, true);
        System.out.println("CompateTo job:\ndog1 with dog2: " + dog1.compareTo(dog2) + " \ndog1 with dog3: " +
                           dog1.compareTo(dog3) + " \ndog1 with dog4: "+ dog1.compareTo(dog4)+ "\n");
/*2*/   System.out.println("Comparator job:\n");
        ArrayList<Dog> dogArrayList = new ArrayList<Dog>();

        Dog first = new Dog("bulldog", 1.6, 84.57, true);
        Dog second = new Dog("samoyed", 0.07, 94.23, true);
        Dog third = new Dog("corgi", 0.7, 120.49, true);
        Dog fourth = new Dog("bulldog", 2.11, 60.82, false);
        Dog fifth = new Dog("poodle", 0.01, 84.23, true);


        dogArrayList.add(first);
        dogArrayList.add(second);
        dogArrayList.add(third);
        dogArrayList.add(fourth);
        dogArrayList.add(fifth);

        for (Dog d: dogArrayList) {
            System.out.println(d);
        }

        PriceComparator myPriceComparator = new PriceComparator();
        dogArrayList.sort(myPriceComparator);

        System.out.println("\nSorted 1 // price: ");
        for (Dog d: dogArrayList) {
            System.out.println(d);
        }


        BreedComparator breedComparator = new  BreedComparator();
        dogArrayList.sort(breedComparator);

        System.out.println("\nSorted 2 // breed: ");
        for (Dog d: dogArrayList) {
            System.out.println(d);
        }
    }
}
