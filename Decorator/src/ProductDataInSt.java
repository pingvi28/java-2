import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ProductDataInSt extends InputStream {

    private DataInputStream in;

    public ProductDataInSt(InputStream in) {
        this.in = new DataInputStream(in);
    }

    public Product readProduct() throws IOException {
        try {
            String name = in.readUTF();
            double cost = in.readDouble();
            int number = in.readInt();

            return new Product(name, cost, number);
        }
        catch (IOException e) {
            throw new IOException("Unable to read product", e);
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
        ProductDataInSt dataInS = (ProductDataInSt) o;
        return Objects.equals(in, dataInS.in);
    }

    @Override
    public int hashCode() {
        return Objects.hash(in);
    }

    @Override
    public String toString() {
        return "ProductDataInputStream{" +
                "in=" + in +
                '}';
    }
}
