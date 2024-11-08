package tasks.simulation.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.simulation.Field;
import tasks.simulation.Point;
import tasks.simulation.animal.Plant;
import tasks.simulation.animal.herbivore.*;
import tasks.simulation.animal.predator.Bear;
import tasks.simulation.animal.predator.Boa;
import tasks.simulation.animal.predator.Fox;
import tasks.simulation.animal.predator.Wolf;
import tasks.simulation.util.EntityUtil;

import static org.junit.jupiter.api.Assertions.*;
import static tasks.simulation.animal.Animal.Direction.*;

public class SimulationTest {
    private Field field;

    @BeforeEach
    public void setup() {
        field = new Field();
    }


    @Test
    @DisplayName("Duck multiply 1X | eat 2X | dies from hunger")
    public void testDuckAndCaterpillarShouldActCorrectly() {
        Duck duck = new Duck(field, 1, 2);
        Duck duck2 = new Duck(field, 2, 2);
        Caterpillar caterpillar = new Caterpillar(field, 1, 2);
        Caterpillar caterpillar2 = new Caterpillar(field, 5, 4);
        Caterpillar caterpillar3 = new Caterpillar(field, 5, 3);

        System.out.println(field);
        duck2.move(LEFT, RIGHT, DOWN, RIGHT);
        duck2.move(RIGHT, RIGHT, RIGHT);
        duck2.move(RIGHT, RIGHT, RIGHT, UP);

        System.out.println("--- End of simulation ---");
        System.out.println(field);

        assertEquals(3, field.entityCnt());
        assertEquals(3, field.animalCnt());
        assertEquals(0, field.plantCnt());

        assertEquals(new Point(1, 2), field.getEntityPoint(duck));
        assertEquals(new Point(5, 4), field.getEntityPoint(caterpillar2));

        assertEquals(2, field.getEntityGroup(1, 2).size());
        assertEquals(1, field.getEntityGroup(5, 4).size());
        assertEquals(0, field.plantCnt());

        assertFalse(caterpillar3.isAlive());
        assertFalse(caterpillar.isAlive());
        assertFalse(duck2.isAlive());

        assertTrue(duck.isAlive());
    }

    @DisplayName("Animals should multiply")
    @Test
    public void testAnimalsShouldMultiply() {
        Wolf wolf = new Wolf(field, 0, 0);
        Wolf wolf3 = new Wolf(field, 0, 0);
        Wolf wolf2 = new Wolf(field, 1, 0);

        assertEquals(3, field.entityCnt());
        assertEquals(3, field.animalCnt());
        assertEquals(0, field.plantCnt());

        wolf2.move(LEFT);

        assertEquals(5, field.entityCnt());
        assertEquals(5, field.animalCnt());
        assertEquals(0, field.plantCnt());
    }

    @DisplayName("Predator should eat herbivore")
    @Test
    public void testPredatorShouldEatHerbivore() {
        Bear bear = new Bear(field, 0, 0);
        Mouse mouse = new Mouse(field, 0, 1);
        Mouse mouse2 = new Mouse(field, 0, 1);
        Mouse mouse3 = new Mouse(field, 0, 1);
        Mouse mouse4 = new Mouse(field, 0, 1);
        Mouse mouse5 = new Mouse(field, 0, 1);
        Mouse mouse6 = new Mouse(field, 0, 1);
        Mouse mouse7 = new Mouse(field, 0, 1);
        Mouse mouse8 = new Mouse(field, 0, 1);
        Mouse mouse9 = new Mouse(field, 0, 1);
        Mouse mouse10 = new Mouse(field, 0, 1);

        assertEquals(11, field.entityCnt());
        assertEquals(11, field.animalCnt());
        assertEquals(0, field.plantCnt());

        bear.move(DOWN);

        assertTrue(field.animalCnt() < 11);
        assertTrue(field.entityCnt() < 11);
        assertEquals(0, field.plantCnt());

        System.out.println(field);
    }

    @DisplayName("Herbivore should eat plant")
    @Test
    public void testHerbivoreShouldEatPlant() {
        Plant plant = new Plant(field, 0, 0);
        Deer deer = new Deer(field, 1, 0);

        assertEquals(2, field.entityCnt());
        assertEquals(1, field.animalCnt());
        assertEquals(1, field.plantCnt());

        deer.move(LEFT);

        double initWeight = deer.initialWeight();

        assertEquals(initWeight - (initWeight * 0.1) + 1, deer.getWeight());

        assertEquals(1, field.entityCnt());
        assertEquals(1, field.animalCnt());
        assertEquals(0, field.plantCnt());

        System.out.println(field);
    }

    @DisplayName("Animal shouldn't move further than it can")
    @Test
    public void testAnimalShouldnNotMoveMoreThanSpeed() {
        Fox fox = new Fox(field, 0, 0);

        assertEquals(1, field.entityCnt());
        assertEquals(1, field.animalCnt());
        assertEquals(0, field.plantCnt());

        assertThrows(IllegalArgumentException.class, () -> fox.move(UP, UP, RIGHT));
    }

    @DisplayName("Animal should die from hunger")
    @Test
    public void testAnimalShouldDieFromHunger() {
        Goat goat = new Goat(field, 5, 0);

        assertEquals(1, field.entityCnt());
        assertEquals(1, field.animalCnt());
        assertEquals(0, field.plantCnt());

        goat.move(LEFT);

        assertEquals(new Point(4, 0), field.getEntityPoint(goat));

        goat.move(DOWN);

        assertEquals(new Point(4, 1), field.getEntityPoint(goat));

        goat.move(UP);

        assertEquals(new Point(4, 0), field.getEntityPoint(goat));

        goat.move(RIGHT, DOWN, DOWN);

        assertEquals(new Point(5, 2), field.getEntityPoint(goat));

        goat.move(UP, DOWN);

        assertEquals(new Point(5, 2), field.getEntityPoint(goat));

        goat.move(DOWN, UP);

        assertEquals(0, field.entityCnt());
        assertEquals(0, field.animalCnt());
        assertEquals(0, field.plantCnt());
        assertFalse(goat.isAlive());
    }

    @DisplayName("Animal should move")
    @Test
    public void testAnimalShouldMove() {
        Boa boa = new Boa(field, 0, 0);
        Goat goat = new Goat(field, 5, 0);

        assertEquals(2, field.entityCnt());
        assertEquals(2, field.animalCnt());
        assertEquals(0, field.plantCnt());

        goat.move(LEFT);

        assertEquals(new Point(4, 0), field.getEntityPoint(goat));

        goat.move(DOWN);

        assertEquals(new Point(4, 1), field.getEntityPoint(goat));

        goat.move(UP);

        assertEquals(new Point(4, 0), field.getEntityPoint(goat));

        goat.move(RIGHT, DOWN, DOWN);

        assertEquals(new Point(5, 2), field.getEntityPoint(goat));

        goat.move(UP, DOWN);

        assertEquals(new Point(5, 2), field.getEntityPoint(goat));

        EntityUtil.addEntities(field, new Point(5, 2), Plant.class, 100);

        goat.move(DOWN, UP);

        assertEquals(new Point(5, 2), field.getEntityPoint(goat));

        goat.move(LEFT, LEFT, LEFT);

        assertEquals(new Point(2, 2), field.getEntityPoint(goat));

        goat.move(LEFT, RIGHT);

        assertEquals(new Point(2, 2), field.getEntityPoint(goat));

        goat.move(RIGHT, LEFT);

        assertEquals(new Point(2, 2), field.getEntityPoint(goat));

        goat.move(LEFT, LEFT);
        goat.move(UP, UP);

        assertEquals(new Point(0, 0), field.getEntityPoint(goat));

        Field.EntityGroup group = field.getEntityGroup(0, 0);

        assertEquals(2, group.size());
    }
}
