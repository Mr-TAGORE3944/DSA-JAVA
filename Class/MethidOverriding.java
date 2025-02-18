package Class;

class Animal {
    void move() {
        System.out.println("Animal can Move....");
    }

    void eat() {
        System.out.println("Animal can Eat Food...");
    }
}

class Dog extends Animal {
    void move() {
        System.out.println("Dog can move...");
    }

    void eat() {
        System.out.println("Dog Eats pedigree...");
    }
}

public class MethidOverriding {
    public static void main(String[] args) {
        Dog blacky = new Dog();
        blacky.move();
        blacky.eat();
    }
}
