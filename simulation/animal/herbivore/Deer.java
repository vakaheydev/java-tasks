package tasks.simulation.animal.herbivore;

import tasks.simulation.Field;
import tasks.simulation.animal.Animal;

public class Deer extends Herbivore {
    public Deer(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    public double initialWeight() {
        return 300;
    }

    @Override
    public int maxQuantity() {
        return 20;
    }

    @Override
    public int speed() {
        return 4;
    }

    @Override
    public double neededFoodWeight() {
        return 50;
    }

    @Override
    public Animal createNewInstance(Field field, int x, int y) {
        return new Duck(field, x, y);
    }
}
