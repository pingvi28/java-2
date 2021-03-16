import java.util.*;

class MySortedSet<T> extends AbstractSet<T> implements SortedSet<T> {
    private List<T> data;
    protected Comparator<? super T> comparator;

    /**
     * empty constructor
     * create a new ArrayList and assign a comparable value "null"
     */
    public MySortedSet() {
        data = new ArrayList<>();
        comparator = null;
    }

    /**
     *  constructor with second collection
     * create a new ArrayList and add new collection
     * if new collection "null", we didn't add collection
     *
     * assign a comparable value "null"
     *
     * @param newCollection
     * @throws NullPointerException (if our new collection is empty)
     */
    public MySortedSet(Collection<? extends T> newCollection) {
        if (newCollection != null){
            data = new ArrayList<>();
            data.addAll(newCollection);
            comparator = null;
        }
        else throw new NullPointerException();
    }

    /**
     *  constructor with comparator, which we created
     * create a new ArrayList and add new collection
     *
     * assign a comparable "comparable" from the settings
     *
     * @param comparator
     */
    public MySortedSet(Comparator<? super T> comparator) {
        data = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * constructor with new collection and second collection
     * create a new ArrayList and add new collection
     * if new collection "null", we didn't add collection
     *
     * assign a comparable "comparable" from the settings
     *
     * @param newCollection
     * @param comparator
     * @throws NullPointerException (if our new collection is empty)
     */
    public MySortedSet(Collection<? extends T> newCollection,Comparator<? super T> comparator) {
        if (newCollection != null){
            data = new ArrayList<>();
            data.addAll(newCollection);
            this.comparator = comparator;
            data.sort(this.comparator);
        }
        else throw new NullPointerException();
    }

    @Override
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public int compare(T o1, T o2) {
        int c;
        try {
            if (comparator != null) {
                c = comparator.compare(o1, o2);
            }
            else {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                c = c1.compareTo(c2);
                c *= -1;
            }
            return c;
        }
        catch (Exception e) {
            throw new ClassCastException();
        }
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) throws ClassCastException,NoSuchElementException {
        boolean flagFrom = chekFlagToConsist(fromElement);
        boolean flagTo = chekFlagToConsist(toElement);

        if(flagFrom && flagTo){
            MySortedSet<T> arr = new MySortedSet();

            try{
                for(int i = data.indexOf(fromElement); i <= data.indexOf(toElement); i++){
                    arr.add(data.get(i));
                }
            }
            catch (IndexOutOfBoundsException ex){ throw new IndexOutOfBoundsException("aaaaaa");}
            return arr;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public SortedSet<T> headSet(T toElement) throws ClassCastException{ // <
        boolean flag = chekFlagToConsist(toElement);

        if(flag){
            MySortedSet<T> arr = new MySortedSet<>(this.subSet(data.get(0), toElement));
            arr.add(this.last());
            return arr;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) throws ClassCastException,NoSuchElementException{ //>=
        boolean flag = chekFlagToConsist(fromElement);

        if(flag){
            try {
                MySortedSet<T> arr = new MySortedSet<>(this.subSet(fromElement, this.last()));
                arr.add(this.last());
                return arr;
            }
            catch (NoSuchElementException ex){
                throw new NoSuchElementException("");
            }
        }
        else throw new NoSuchElementException();
    }

    private boolean chekFlagToConsist(T element){
        boolean flag = false;
        for (T elem: this.data){
            if(compare(elem, element) == 0){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     *  returns the first element in this set
     *
     * @return the first element
     * @throws NoSuchElementException, if our set is empty
     */
    @Override
    public T first() {
        if(data.size() > 1){
            return data.get(0);
        }
        else throw new NoSuchElementException();
    }

    /**
     *  returns the last element in this set.
     *
     * @return the last element
     * @throws NoSuchElementException, if set is empty
     */
    @Override
    public T last() {
        if(data.size() > 1){
            return data.get(data.size() - 1);
        }
        else throw new NoSuchElementException();
    }

     /**
     * @return set size
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * check empty set or not
     * @return false//true
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     *This method is used to check whether a specific element
     * is present in the Set or not.
     *
     * @param o
     * @return true/false
     * @throws NullPointerException
     */
    @Override
    public boolean contains(Object o) {
        if (o != null) {
            return data.contains(o);
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * @return iterator in this set
     */
    @Override
    public Iterator<T> iterator() {
        return new MySortedSetItetator();
    }

    private class MySortedSetItetator implements Iterator<T>{
        private int cursor;
        private boolean flag;

        public MySortedSetItetator() {
            cursor = data.size() - 1;
        }
        @Override
        public boolean hasNext() {
            return cursor >= 0;
        }
        @Override
        public T next() throws NoSuchElementException {
            try {
                T element = data.get(cursor);
                cursor--;
                flag = true;
                return element;
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                throw new NoSuchElementException();
            }
        }
        @Override
        public void remove() throws IllegalStateException {
            if (flag) {
                data.remove(cursor + 1);
            }
            else {
                throw new IllegalStateException();
            }
            flag = false;
        }
    }

    /**
     * this method is used to form an array of the same elements as that of the Set
     *
     * @return array
     * @throws NullPointerException
     */
    @Override
    public Object[] toArray() {
        if(data != null){
            Object[] arr = new Object[data.size()];
            for (int i = 0; i < data.size(); i++){
                arr[i] = data.get(i);
            }
            return arr;
        }
        else throw new NullPointerException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) throws ClassCastException{
        if(data != null){
            int index = 0;
            T1[] arr = (T1[]) new Object[a.length];
            for (int i = 0; i < a.length; i++){
                if(this.contains(a[i])){
                    arr[index] = a[i];
                    index++;
                }
            }
            return arr;
        }
        else throw new NullPointerException();
    }

    /**
     * This method is used to add a specific element to the set.
     *
     * @param t
     * @return  The function adds the element only if the specified element
     * is not already present in the set else the function returns False
     * if the element is already present in the Set.
     * @throws NullPointerException
     */
    @Override
    public boolean add(T t) {
        if (t != null) {
            if (data.contains(t)) {
                return false;
            }
            int i = 0;
            if (i == data.size()) {
                data.add(t);
                data.sort(this.comparator);
                return true;
            }
            while (compare(t, data.get(i)) > 0) {
                i++;
                if (i == data.size()) {
                    data.add(t);
                    data.sort(this.comparator);
                    return true;
                }
            }
            data.add(i, t);
            data.sort(this.comparator);
            return true;
        }
        else {
            throw new NullPointerException();
        }
    }


    /**
     * this method is used to remove
     * @param o
     * @return
     * @throws NullPointerException
     */
    @Override
    public boolean remove(Object o) {
        if (o != null) {
            return data.remove(o);
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * This method is used to check whether a specific element
     * which have second collection, is present in the Set or not.
     *
     * @param c
     * @return
     * @throws NullPointerException
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c != null){
            boolean flag = true;
            ArrayList<T> arr = (ArrayList<T>) c;
            int sizeArr = arr.size();
            for (int i = 0; i < sizeArr; i++){
                if(this.contains(arr.get(i)) == false){
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        else throw new NullPointerException();
    }

    /**
     *This method is used to append all
     * of the elements from the mentioned collection to the existing set.
     * The elements are added randomly without following any specific order.
     *
     * @param c (second collection)
     * @return true, if set changed // or false
     * @throws NullPointerException
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c != null){
            boolean flag = false;
            int count = 0;
            ArrayList<T> arr = (ArrayList<T>) c;
            int sizeArr = arr.size();
            for (int i = 0; i < sizeArr; i++){
                T t = arr.get(i);
                boolean flag1 = this.add(t);
                if (flag1) {count++;}
            }
            if(count > 0){
                flag = true;
            }
            return flag;
        }
        else throw new NullPointerException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * This method is used to retain all the elements from the set,
     * which are mentioned in the given collection.
     * @param c
     * @return true,if our set changed
     * @throws NullPointerException
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if(c != null){
            ArrayList<T> arr = (ArrayList<T>) c;
            int lent = arr.size();
            int index = 0;
            while (index < lent){
                data.remove(arr.get(index));
                index++;
            }
        }
        else throw new NullPointerException();
        return false;
    }

    /**
     * Our original "data" is recreated
     */
    @Override
    public void clear() {
        data = new ArrayList<T>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MySortedSet<?> sortedSet = (MySortedSet<?>) o;
        if (Objects.equals(comparator, sortedSet.comparator) &&
                data.size() == sortedSet.data.size()) {
            Iterator<T> i = this.iterator();
            Iterator<T> j = (Iterator<T>) sortedSet.iterator();
            while (i.hasNext()) {
                if (!i.next().equals(j.next())) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data, comparator, data.size());
    }

    /**
     * print set
     */
    public void display() {
        for (T elem: data){
            System.out.print(elem + ", ");
        }
    }
}


