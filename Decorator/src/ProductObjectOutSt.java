import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Objects;

public class ProductObjectOutSt extends OutputStream {

    private ObjectOutputStream out;

    public ProductObjectOutSt(OutputStream out) throws IOException {
        this.out = new ObjectOutputStream(out);
    }

    public void writeProduct(Product product) throws IOException {
        try {
            out.writeObject(product);
        }
        catch (IOException e) {
            throw new IOException("Unable to write product in file", e);
        }
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductObjectOutSt objectOutSt = (ProductObjectOutSt) o;
        return Objects.equals(out, objectOutSt.out);
    }

    @Override
    public int hashCode() {
        return Objects.hash(out);
    }

    @Override
    public String toString() {
        return "ProductObjectOutputStream{" +
                "out=" + out +
                '}';
    }
}
