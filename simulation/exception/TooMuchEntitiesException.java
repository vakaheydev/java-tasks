package tasks.simulation.exception;

import tasks.simulation.Entity;
import tasks.simulation.util.EntityUtil;

public class TooMuchEntitiesException extends RuntimeException {
    public TooMuchEntitiesException(int currentAmount, Class<? extends Entity> entityClass) {
        super(String.format("There is already max amount[%d] of specified " +
                "entity[%s} on this location", currentAmount, entityClass.getSimpleName()));
    }
}
