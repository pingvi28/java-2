import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    protected String name;
    protected double cost;
    protected int number;


    public Product() {
        this.name = "Unknown product. You must give param";
    }

    public Product(String name, double cost, int number) {
        this.name = name;
        this.cost = cost;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost == product.cost &&
                Double.compare(product.number, number) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public String toString() {
        return "{Product name: " + name + ", cost: " + cost + ", number: " + number + "}\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, number);
    }
}
