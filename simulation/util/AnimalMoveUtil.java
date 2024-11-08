package tasks.simulation.util;

import tasks.simulation.Point;
import tasks.simulation.animal.Animal;

import static tasks.simulation.animal.Animal.Direction;

public final class AnimalMoveUtil {
    private AnimalMoveUtil() {
    }

    public static void randomMove(Animal animal, int moveCnt) {
        if (animal.speed() < moveCnt) {
            throw new IllegalArgumentException(String.format("Specified moves amount[%d] is higher than animal " +
                    "speed[%d]", moveCnt, animal.speed()));
        }

        for (int i = 0; i < moveCnt; i++) {
            randomMove(animal);
        }
    }

    public static void randomMove(Animal animal) {
        Point point = animal.getPoint();
        Direction rndDirection = PointUtil.getRandomDirection(point);
        animal.move(rndDirection);
    }
}
