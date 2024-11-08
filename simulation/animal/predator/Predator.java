package tasks.simulation.animal.predator;

import tasks.simulation.Field;
import tasks.simulation.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(Field field, int x, int y) {
        super(field, x, y);
    }
}
