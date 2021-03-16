import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {

        //1
        Integer arr[] = new Integer[5];
        arr[0] = 11;   arr[1] = 52;   arr[2] = 78;   arr[3] = 3;  arr[4] = 9;

        System.out.print("\nOriginal: " );
        for (int i = 0; i < 5; i++){ System.out.print(arr[i] + " "); }

        ReverseIterator<Integer> reverseIterator= new ReverseIterator<Integer>(arr);
        System.out.print("\nReverse Iterator: ");
        while (reverseIterator.hasNext()){
            System.out.print(reverseIterator.next() + " ");
        }

        //2
        RandomIterator randomIterator = new RandomIterator();
        System.out.print("\nRandom: " );
        for (int i = 0; i < 5; i++){
            arr[i] = randomIterator.next();
            System.out.print(arr[i] + " ");
        }

        //3
        OddItemsIterator oddItemsIterator = new OddItemsIterator(arr) ;
        try {
            System.out.println("\nOdd iterator:  " + oddItemsIterator.next() + " " + oddItemsIterator.next());
        } catch (NoSuchElementException|ArrayIndexOutOfBoundsException e) {
            System.out.println("\nOdd iterator: you are out of the array");
        }
    }
}
