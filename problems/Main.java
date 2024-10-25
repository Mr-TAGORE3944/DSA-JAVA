package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CelestialObject {
    String name;
    double mass;

    public CelestialObject(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public void disintegrate() {
        System.out.println(name + " is disintegrating...");
    }
}

class Star extends CelestialObject {
    public Star(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void disintegrate() {
        System.out.println(name + " is going supernova!");
    }
}

class Planet extends CelestialObject {
    public Planet(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void disintegrate() {
        System.out.println(name + " is being torn apart by gravitational forces.");
    }
}

class BlackHole extends CelestialObject {
    public BlackHole(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void disintegrate() {
        System.out.println(name + " is collapsing further into singularity.");
    }
}

class Universe {
    double energy;
    double entropy;
    List<CelestialObject> celestialObjects;

    public Universe(double energy) {
        this.energy = energy;
        this.entropy = 0;
        this.celestialObjects = new ArrayList<>();
    }

    public void addCelestialObject(CelestialObject obj) {
        celestialObjects.add(obj);
    }

    public void increaseEntropy() {
        Random random = new Random();
        entropy += random.nextDouble() * 10;
        energy -= random.nextDouble() * 5;
        System.out.println("Entropy increased to: " + entropy + ", Energy remaining: " + energy);
    }

    public void simulateDestruction() {
        while (energy > 0) {
            increaseEntropy();
            if (entropy > 50) {
                System.out.println("Critical entropy level reached! Celestial objects are disintegrating...");
                for (CelestialObject obj : celestialObjects) {
                    obj.disintegrate();
                }
                System.out.println("The universe has collapsed!");
                break;
            }
        }

        if (energy <= 0) {
            System.out.println("The universe has run out of energy and collapsed into nothingness.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Universe universe = new Universe(100); // Start with 100 energy

        // Create some celestial objects
        Star sun = new Star("Sun", 1.989e30);
        Planet earth = new Planet("Earth", 5.972e24);
        BlackHole blackHole = new BlackHole("Sagittarius A*", 4.31e6);

        // Add them to the universe
        universe.addCelestialObject(sun);
        universe.addCelestialObject(earth);
        universe.addCelestialObject(blackHole);

        // Simulate the destruction of the universe
        universe.simulateDestruction();
    }
}

