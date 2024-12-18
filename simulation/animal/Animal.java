package tasks.simulation.animal;

import tasks.simulation.Entity;
import tasks.simulation.Field;
import tasks.simulation.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static tasks.simulation.Field.EntityGroup;

public abstract class Animal extends Entity {
    protected static final Map<Class<? extends Entity>, Double> chances = new HashMap<>();

    public enum Direction {
        RIGHT, LEFT, UP, DOWN
    }

    public Animal(Field field, int x, int y) {
        super(field, x, y);
        populateChancesMap();
    }

    public double eat(Entity entity) {
        if (checkDeathFromHunger()) {
            return 0;
        }

        if (canEat(entity)) {
            double chance = getChanceToEat(entity);
            if (randomEat(chance)) {
                System.out.println(this + " eats " + entity);
                entity.die();
                weight += entity.getWeight();
                return entity.getWeight();
            }
            return 0;
        }
        return 0;
    }

    private boolean randomEat(double chance) {
        Random rnd = new Random();

        return rnd.nextDouble() <= chance;
    }

    protected boolean canEat(Entity entity) {
        return chances.get(entity.getClass()) != null;
    }

    protected abstract void populateChancesMap();

    protected void addChance(Class<? extends Entity> animalClazz, double chance) {
        chances.put(animalClazz, chance);
    }

    protected double getChanceToEat(Entity entity) {
        return chances.getOrDefault(entity.getClass(), -1.0);
    }

    public void multiply(Entity entity) {
        if (checkDeathFromHunger()) {
            return;
        }

        if (this.getClass().equals(entity.getClass())) {
            Animal other = (Animal) entity;
            if (this.point.equals(other.point)) {
                System.out.println(this + " multiply with " + entity);
                field.addEntity(point.x(), point.y(), createNewInstance(this.field, point.x(), point.y()));
            }
        }
    }

    public void move(Direction... directions) {
        if (checkDeathFromHunger()) {
            return;
        }

        if (directions.length > speed()) {
            throw new IllegalArgumentException("This entity can't move more than " + speed() + " locations at once");
        }

        for (Direction direction : directions) {
            moveTo(direction);
            if (checkDeathFromHunger()) {
                return;
            }
        }
    }

    private void moveTo(Direction direction) {
        Point directionPoint = getDirectionPoint(this.point, direction);
        int x = directionPoint.x();
        int y = directionPoint.y();

        EntityGroup entityGroup = field.getEntityGroup(x, y);

        System.out.printf("%s moving %s to %s\n", this, direction, directionPoint);

        this.point = new Point(x, y);
        actOnEntityGroup(entityGroup);
        loseWeight();

        if (!checkDeathFromHunger()) {
            field.moveEntity(x, y, this);
        }
    }

    /**
     * Lose 10% of current weight
     *
     * @return new weight
     */
    public double loseWeight() {
        weight -= initialWeight() * 0.1;
        return weight;
    }

    private double actOnEntityGroup(EntityGroup entityGroup) {
        double eatenWeight = 0;
        for (var other : new ArrayList<>(entityGroup.getEntities())) {
            this.multiply(other);
            eatenWeight += this.eat(other);
            if (other instanceof Animal otherAnimal) {
                if (other.isAlive()) {
                    otherAnimal.eat(this);
                }
            }
        }

        return eatenWeight;
    }

    private boolean checkDeathFromHunger() {
        if (!isAlive()) {
            return true;
        }

        if (weight <= 0) {
            System.out.printf("Whoops... poor %s dies from hunger\n",
                    getClass().getSimpleName());
            die();
            return true;
        }

        return false;
    }

    private Point getDirectionPoint(Point curPoint, Direction direction) {
        int x = curPoint.x();
        int y = curPoint.y();
        return switch (direction) {
            case RIGHT -> new Point(x + 1, y);
            case LEFT -> new Point(x - 1, y);
            case UP -> new Point(x, y - 1);
            case DOWN -> new Point(x, y + 1);
        };
    }

    public abstract int speed();

    public abstract double neededFoodWeight();

    public abstract Animal createNewInstance(Field field, int x, int y);

    @Override
    public EntityType getEntityType() {
        return EntityType.ANIMAL;
    }
}
