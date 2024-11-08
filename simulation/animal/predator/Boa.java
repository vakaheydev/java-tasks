package tasks.simulation.animal.predator;

import tasks.simulation.Field;
import tasks.simulation.animal.Animal;
import tasks.simulation.animal.herbivore.Duck;
import tasks.simulation.animal.herbivore.Mouse;
import tasks.simulation.animal.herbivore.Rabbit;

public class Boa extends Predator {
    public Boa(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    public double initialWeight() {
        return 15;
    }

    @Override
    public int maxQuantity() {
        return 30;
    }

    @Override
    protected void populateChancesMap() {
        addChance(Rabbit.class, 0.2);
        addChance(Mouse.class, 0.4);
        addChance(Duck.class, 0.1);
    }

    @Override
    public int speed() {
        return 1;
    }

    @Override
    public double neededFoodWeight() {
        return 3;
    }

    @Override
    public Animal createNewInstance(Field field, int x, int y) {
        return new Boa(field, x, y);
    }
}
