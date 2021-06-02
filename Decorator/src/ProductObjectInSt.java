import java.io.*;
import java.util.Objects;

public class ProductObjectInSt extends InputStream {

    private ObjectInputStream in;

    public ProductObjectInSt(InputStream in) throws IOException {
        this.in = new ObjectInputStream(in);
    }

    public Product readProduct() throws IOException, ClassNotFoundException {
        try {
            return (Product) in.readObject();
        }
        catch (IOException e) {
            throw new IOException("Unable to read product", e);
        }
        catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Class not found", e);
        }
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductObjectInSt objectInSt = (ProductObjectInSt) o;
        return Objects.equals(in, objectInSt.in);
    }

    @Override
    public int hashCode() {
        return Objects.hash(in);
    }

    @Override
    public String toString() {
        return "ProductObjectInputStream{" +
                "in=" + in +
                '}';
    }
}
