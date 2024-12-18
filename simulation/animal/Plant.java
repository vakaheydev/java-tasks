package tasks.simulation.animal;

import tasks.simulation.Entity;
import tasks.simulation.Field;

public class Plant extends Entity {
    public Plant(Field field, int x, int y) {
        super(field, x, y);
    }

    @Override
    public double initialWeight() {
        return 1;
    }

    @Override
    public int maxQuantity() {
        return 200;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.PLANT;
    }
}
