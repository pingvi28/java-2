import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseIterator<E> implements Iterator<E> {
    private E[] arr;
    private int cur;
    private int index = 0;

    public ReverseIterator(E[] arr){
        this.arr = arr;
        this.cur = this.arr.length;
    }

    @Override
    public E next() {
        this.index++;
        if (0 <= this.cur - index){
            return arr[cur - index];
        }
        throw new NoSuchElementException("I can't find" + (this.cur - this.index) + "element");
    }

    @Override
    public boolean hasNext() {
        return (this.cur - this.index) != 0;
    }
}
