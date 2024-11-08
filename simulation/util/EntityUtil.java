package tasks.simulation.util;

import tasks.simulation.Entity;
import tasks.simulation.Field;
import tasks.simulation.Point;
import tasks.simulation.animal.Plant;
import tasks.simulation.animal.herbivore.*;
import tasks.simulation.animal.predator.*;

import java.util.List;
import java.util.Random;

public final class EntityUtil {
    private EntityUtil() {
    }

    public static void addEntities(Field field, Point point, Entity... entities) {
        for (Entity entity : entities) {
            field.addEntity(point.x(), point.y(), entity);
        }
    }

    public static void addEntities(Field field, Point point, Class<? extends Entity> clazz, int amount) {
        int maxAmount = getMaxQuantity(field, clazz);
        if (amount > maxAmount) {
            throw new IllegalArgumentException(String.format("Specified amount[%d] is higher than entity[%s] max " +
                    "amount[%d] on location", amount, clazz.getSimpleName(), maxAmount));
        }

        for (int i = 0; i < amount; i++) {
            try {
                Entity entity = clazz.getConstructor(Field.class, int.class, int.class)
                        .newInstance(field, point.x(), point.y());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void addEntities(Field field, Class<? extends Entity> clazz, int amount) {
        for (int i = 0; i < amount; i++) {
            try {
                Point point = PointUtil.getRandomPoint(field, clazz);
                Entity entity = clazz.getConstructor(Field.class, int.class, int.class)
                        .newInstance(field, point.x(), point.y());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void addEntities(Field field, int amount) {
        for (int i = 0; i < amount; i++) {
            try {
                Class<? extends Entity> clazz = getRandomClass();
                Point point = PointUtil.getRandomPoint(field, clazz);
                Entity entity = clazz.getConstructor(Field.class, int.class, int.class)
                        .newInstance(field, point.x(), point.y());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Class<? extends Entity> getRandomClass() {
        List<Class<? extends Entity>> classes = List.of(
                Plant.class,
                Boar.class,
                Buffalo.class,
                Caterpillar.class,
                Deer.class,
                Duck.class,
                Goat.class,
                Horse.class,
                Mouse.class,
                Rabbit.class,
                Sheep.class,
                Bear.class,
                Boa.class,
                Eagle.class,
                Fox.class,
                Wolf.class
        );

        return classes.get(new Random().nextInt(classes.size()));
    }

    public static int getMaxQuantity(Field field, Class<? extends Entity> clazz) {
        try {
            Entity entity = clazz.getConstructor(Field.class, int.class, int.class).newInstance(field, 0, 0);
            int maxAmount = (int) clazz.getMethod("maxQuantity").invoke(entity);

            field.removeEntity(entity);
            return maxAmount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
