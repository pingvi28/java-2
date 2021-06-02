import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Product orange = new Product("Orange", 14.4, 100);
        Product milk = new Product("Milk", 24.5, 20);
        Product cake = new Product("Cake", 50.4, 5);
        Product unknownProduct = new Product();

        productDataInSOuSTest(orange, milk,cake, unknownProduct);
        System.out.println();
        productObjectInSOuSTest(orange, milk,cake, unknownProduct);
    }

    /**
     *
     * @param orange
     * @param milk
     * @param cake
     * @param unknownProduct
     *
     * this method combines two method : productDataInputStream and productDataOutputStream
     */
    public static void productDataInSOuSTest(Product orange, Product milk, Product cake, Product unknownProduct) {
        productDataOutputStream(orange, milk,cake, unknownProduct);
        productDataInputStream();

    }

    public static void productDataInputStream(){
        try (ProductDataInSt in = new ProductDataInSt(new FileInputStream("src\\test.txt"))) {
            System.out.print(in.readProduct());  //.toString()
            System.out.print(in.readProduct());  //.toString()
            System.out.print(in.readProduct());  //.toString()
            System.out.print(in.readProduct());  //.toString()
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void productDataOutputStream(Product orange, Product milk, Product cake, Product unknownProduct){
        try (ProductDataOutSt out = new ProductDataOutSt(new FileOutputStream("src\\test.txt"))) {
            out.writeProduct(orange);
            out.writeProduct(milk);
            out.writeProduct(cake);
            out.writeProduct(unknownProduct);
            out.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param orange
     * @param milk
     * @param cake
     * @param unknownProduct
     *
     * this method combines two method : productObjectInputStream and productObjectOutputStream
     */
    public static void productObjectInSOuSTest(Product orange, Product milk, Product cake, Product unknownProduct) {
        productObjectOutputStream(orange, milk, cake, unknownProduct);
        productObjectInputStream();
    }

    public static void productObjectInputStream(){
        try (ProductObjectInSt in = new ProductObjectInSt(new FileInputStream("src\\test.txt"))) {
            System.out.print(in.readProduct());  //.toString()
            System.out.print(in.readProduct());  //.toString()
            System.out.print(in.readProduct());  //.toString()
            System.out.print(in.readProduct());  //.toString()
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void productObjectOutputStream(Product orange, Product milk, Product cake, Product unknownProduct){
        try (ProductObjectOutSt out = new ProductObjectOutSt(new FileOutputStream("src\\test.txt"))) {
            out.writeProduct(orange);
            out.writeProduct(milk);
            out.writeProduct(cake);
            out.writeProduct(unknownProduct);
            out.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
