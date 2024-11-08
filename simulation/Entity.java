package tasks.simulation;

import tasks.simulation.animal.EntityType;

public abstract class Entity {
    public Entity(Field field, int x, int y) {
        this.field = field;
        this.point = new Point(x, y);
        field.addEntity(x, y, this);
        weight = initialWeight();
    }

    protected double weight;

    protected Field field;
    protected Point point;

//    public void setPos(int x, int y) {
//        field.addEntity(x, y, this);
//        point = new Point(x, y);
//    }

    public boolean isAnimal() {
        return getEntityType().equals(EntityType.ANIMAL);
    }

    public boolean isPlant() {
        return getEntityType().equals(EntityType.PLANT);
    }

    public void die() {
        System.out.println(this + " dies");
        field.removeEntity(this);
    }

    public abstract double initialWeight();

    public abstract int maxQuantity();

    public abstract EntityType getEntityType();

    public boolean isAlive() {
        return field.getEntityPoint(this) != null;
    }

    @Override
    public String toString() {
        return String.format("%s[%.2f kg] in %s", getClass().getSimpleName(), weight, point);
    }

    public double getWeight() {
        return weight;
    }

    public Field getField() {
        return field;
    }

    public Point getPoint() {
        return point;
    }
}
