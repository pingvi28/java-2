package test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClassForMySortedSet {
    private String[] data;
    StringComparator stringComparator = new StringComparator();
    MySortedSet<String> mySortedSet = new MySortedSet<>(stringComparator);
    MySortedSet<String> mySortedSet1 = new MySortedSet<>(stringComparator);
    List<String> myList = new ArrayList<>();

    @Before
    public void setMySortedSet2Data() throws Exception {
        mySortedSet1.add("Welcome");
        mySortedSet1.add("Geeks");
        mySortedSet1.add("Fo");
        mySortedSet1.add("To");
    }

    @After
    public void tearDownToHexStringData() {
        mySortedSet.clear();
    }

    @Test
    public void whenAddTheSameElementsInDifferentWay() throws Exception {
        data = new String[]{"Welcome", "To", "Fo", "Geeks"};
        setMySortedSetData();

        try {
            Assert.assertTrue(mySortedSet.equals(mySortedSet1));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    // mySortedSet.size() == mySortedSet2.size()
    @Test
    public void whenAddTheDifferentElementsInDifferentWay() throws Exception {
        data = new String[]{"Wel", "Toto", "Fo", "Geeks"};
        setMySortedSetData();
        MySortedSet<String> mySortedSet = new MySortedSet<>(myList, stringComparator);

        try {
            Assert.assertFalse(mySortedSet.equals(mySortedSet1));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    // mySortedSet.size() != mySortedSet2.size()
    @Test
    public void whenAddTheDifferentElementsInDifferentWay2() throws Exception {
        data = new String[]{"Wel", "Toto", "Geeks"};
        setMySortedSetData();

        try {
            Assert.assertFalse(mySortedSet.equals(mySortedSet1));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void SubsetTest() throws Exception {
        mySortedSet1.add("Abc");
        data = new String[]{"Abc", "Geeks", "To"};
        setMySortedSetData();

        try {
            Assert.assertEquals(mySortedSet,mySortedSet1.subSet("Abc", "To"));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void HeadSetTest() throws Exception {
        mySortedSet1.remove("To");
        data = new String[]{ "Geeks, Fo"};
        setMySortedSetData();

        try {
            Assert.assertEquals(mySortedSet,mySortedSet1.headSet( "Welcome"));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void TailSet() throws Exception {
        data = new String[]{ "To", "Welcome"};
        setMySortedSetData();

        try {
            Assert.assertEquals(mySortedSet,mySortedSet1.tailSet( "To"));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void SizeTest(){
        mySortedSet1.add("3");
        int b = mySortedSet1.size();
        mySortedSet1.clear();

        try {
            Assert.assertEquals(5,b - mySortedSet1.size());
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void ContainsAllTest() throws Exception {
        data = new String[]{ "Fo", "Welcome"};
        myList = Arrays.asList(this.data);
        ArrayList<String> list= new ArrayList<>(myList);

        try {
            Assert.assertTrue(mySortedSet1.containsAll(list));
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void RemoveAllTest() throws Exception {
        data = new String[]{ "Fo", "To","Welcome"};
        myList = Arrays.asList(this.data);
        ArrayList<String> list= new ArrayList<>(myList);
        mySortedSet1.add("Abc");
        data = new String[]{ "Abc", "Geeks"};
        setMySortedSetData();
        mySortedSet1.removeAll(list); // return boolean

        try {
            Assert.assertEquals(mySortedSet, mySortedSet1);
        }
        catch (AssertionError ex){
            System.out.println(ex.getMessage());
        }
    }

    public void setMySortedSetData() throws Exception {
        myList = Arrays.asList(this.data);
        ArrayList<String> list= new ArrayList<>(myList);
        mySortedSet.addAll(list);
    }
}
