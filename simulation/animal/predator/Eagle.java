package tasks.simulation.animal.predator;

import tasks.simulation.Field;
import tasks.simulation.animal.Animal;
import tasks.simulation.animal.herbivore.Duck;
import tasks.simulation.animal.herbivore.Mouse;
import tasks.simulation.animal.herbivore.Rabbit;

public class Eagle extends Predator {
    public Eagle(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    public double initialWeight() {
        return 6;
    }

    @Override
    public int maxQuantity() {
        return 20;
    }

    @Override
    protected void populateChancesMap() {
        addChance(Fox.class, 0.1);
        addChance(Rabbit.class, 0.9);
        addChance(Mouse.class, 0.9);
        addChance(Duck.class, 0.8);
    }

    @Override
    public int speed() {
        return 3;
    }

    @Override
    public double neededFoodWeight() {
        return 1;
    }

    @Override
    public Animal createNewInstance(Field field, int x, int y) {
        return new Eagle(field, x, y);
    }
}
