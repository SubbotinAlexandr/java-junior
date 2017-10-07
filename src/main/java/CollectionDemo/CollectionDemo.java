package CollectionDemo;


import java.util.HashSet;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();
        Cat murik = new Cat("Miruk");
        cats.add(murik);
        murik.setName("Murzik");
        cats.add(new Cat("Miruk"));
        cats.forEach(System.out::println);
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }
    public void setName (String name) {
        this.name = name;
    }
}