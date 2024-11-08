package tasks.simulation.animal.predator;

import tasks.simulation.Field;
import tasks.simulation.animal.Animal;
import tasks.simulation.animal.herbivore.Caterpillar;
import tasks.simulation.animal.herbivore.Duck;
import tasks.simulation.animal.herbivore.Mouse;
import tasks.simulation.animal.herbivore.Rabbit;

public class Fox extends Predator {
    public Fox(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    public double initialWeight() {
        return 8;
    }

    @Override
    public int maxQuantity() {
        return 30;
    }

    @Override
    protected void populateChancesMap() {
        addChance(Rabbit.class, 0.7);
        addChance(Mouse.class, 0.9);
        addChance(Duck.class, 0.6);
        addChance(Caterpillar.class, 0.4);
    }

    @Override
    public int speed() {
        return 2;
    }

    @Override
    public double neededFoodWeight() {
        return 2;
    }

    @Override
    public Animal createNewInstance(Field field, int x, int y) {
        return null;
    }
}
