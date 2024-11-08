package tasks.simulation.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.simulation.Field;
import tasks.simulation.Point;
import tasks.simulation.animal.Animal;
import tasks.simulation.animal.herbivore.Herbivore;
import tasks.simulation.util.AnimalMoveUtil;

public class AnimalMoveUtilTest {
    static class NotHungryAnimal extends Herbivore {
        public NotHungryAnimal(Field field, int x, int y) {
            super(field, x, y);
        }

        @Override
        public int speed() {
            return 1;
        }

        @Override
        public double neededFoodWeight() {
            return 0;
        }

        @Override
        public Animal createNewInstance(Field field, int x, int y) {
            return new NotHungryAnimal(field, x, y);
        }

        @Override
        public double initialWeight() {
            return 1;
        }

        @Override
        public int maxQuantity() {
            return 2_140_000_000;
        }

        @Override
        public double loseWeight() {
            return weight;
        }
    }

    private Field field;

    @BeforeEach
    void setUp() {
        field = new Field();
    }

    @Test
    void testAnimalShouldMoveRandomly() {
        Animal animal = new NotHungryAnimal(field, 0, 0);
        for (int i = 0; i < 25_000; i++) {
            AnimalMoveUtil.randomMove(animal);
        }
        System.out.println(animal);
        System.out.println(field);
    }

    @Test
    void testAnimalShouldMoveRandomlyNotUpAndNotLeft() {
        Animal animal = new NotHungryAnimal(field, 0, 0);
        for (int i = 0; i < 1000; i++) {
            AnimalMoveUtil.randomMove(animal);
            if (animal.getPoint().equals(new Point(0, 1))) {
                animal.move(Animal.Direction.UP);
            } else if (animal.getPoint().equals(new Point(1, 0))) {
                animal.move(Animal.Direction.LEFT);
            }
        }
        System.out.println(animal);
        System.out.println(field);
    }

    @Test
    void testAnimalShouldMoveRandomlyNotLeftAndDown() {
        int height = Field.FIELD_HEIGHT - 1;
        Animal animal = new NotHungryAnimal(field, 0, height);
        for (int i = 0; i < 1000; i++) {
            AnimalMoveUtil.randomMove(animal);
            if (animal.getPoint().equals(new Point(0, height - 1))) {
                animal.move(Animal.Direction.DOWN);
            } else if (animal.getPoint().equals(new Point(1, height))) {
                animal.move(Animal.Direction.LEFT);
            }
        }
        System.out.println(animal);
        System.out.println(field);
    }

    @Test
    void testAnimalShouldMoveRandomlyNotRightAndDown() {
        int height = Field.FIELD_HEIGHT - 1;
        int width = Field.FIELD_WIDTH - 1;
        Animal animal = new NotHungryAnimal(field, width, height);
        for (int i = 0; i < 1000; i++) {
            AnimalMoveUtil.randomMove(animal);
            if (animal.getPoint().equals(new Point(width, height - 1))) {
                animal.move(Animal.Direction.DOWN);
            } else if (animal.getPoint().equals(new Point(width - 1, height))) {
                animal.move(Animal.Direction.RIGHT);
            }
        }
        System.out.println(animal);
        System.out.println(field);
    }

    @Test
    void testAnimalShouldMoveRandomlyNotUpAndRight() {
        int width = Field.FIELD_WIDTH - 1;
        Animal animal = new NotHungryAnimal(field, width, 0);
        for (int i = 0; i < 1000; i++) {
            AnimalMoveUtil.randomMove(animal);
            if (animal.getPoint().equals(new Point(width, 1))) {
                animal.move(Animal.Direction.UP);
            } else if (animal.getPoint().equals(new Point(width - 1, 0))) {
                animal.move(Animal.Direction.RIGHT);
            }
        }
        System.out.println(animal);
        System.out.println(field);
    }
}
