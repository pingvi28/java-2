import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class ProductDataOutSt extends OutputStream {

    private DataOutputStream out;

    public ProductDataOutSt(OutputStream out) {
        this.out = new DataOutputStream(out);
    }

    public void writeProduct(Product product) throws IOException {
        try {
            out.writeUTF(product.getName());
            out.writeDouble(product.getCost());
            out.writeInt(product.getNumber());
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
        ProductDataOutSt dataOutS = (ProductDataOutSt) o;
        return Objects.equals(out, dataOutS.out);
    }

    @Override
    public int hashCode() {
        return Objects.hash(out);
    }

    @Override
    public String toString() {
        return "ProductDataOutputStream{" +
                "out=" + out +
                '}';
    }
}
