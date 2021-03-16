import java.util.Iterator;

public class RandomIterator implements Iterator<Integer> {

    @Override
    public boolean hasNext() { return true; }

    @Override
    public Integer next() {
        return (int)(Math.round(Math.random()* 65));
    }
}
