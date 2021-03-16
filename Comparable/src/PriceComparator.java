import java.util.Comparator;

public class PriceComparator implements  Comparator<Dog> {
    public int compare(Dog d1, Dog d2) {
        if (d1.price == d2.price) {
            return 0;
        }
        if (d1.price > d2.price) {
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public Comparator<Dog> reversed() {
        return null;
    }
}
