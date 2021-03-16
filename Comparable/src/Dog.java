public class Dog implements Comparable<Dog> {
    protected String breed;
    protected double age;
    protected double price;
    protected boolean vaccinated;

    public Dog(String breed,double age, double price,boolean vaccinated){
        this.age = age;
        this.breed = breed;
        this.price = price;
        this.vaccinated = vaccinated;
    }

    @Override
    public int compareTo(Dog someDog)
    {
        if (this.breed.equals(someDog.breed)){
            if (this.age == someDog.age) {
                return 0;
            } else if (this.age < someDog.age) {
                return -1;
            } else {
                return 1;
            }
        }
        else if (this.vaccinated == someDog.vaccinated){ // одна порода и привиты
            return 1;
        }
        else return -1;
    }

    @Override
    public String toString() {
        return "Dog { " +
                "breed: " + breed +
                ", age: " + age +
                ", price: " + price +
                ", vaccinated: " + vaccinated +
                " }";
    }
}
