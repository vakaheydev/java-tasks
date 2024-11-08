package tasks.simulation.animal.herbivore;

import tasks.simulation.Field;
import tasks.simulation.animal.Animal;
import tasks.simulation.animal.Plant;

public abstract class Herbivore extends Animal {
    public Herbivore(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    protected void populateChancesMap() {
        addChance(Plant.class, 1.0);
    }
}
