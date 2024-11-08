package tasks.simulation.test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.simulation.Field;
import tasks.simulation.Point;
import tasks.simulation.animal.Plant;
import tasks.simulation.animal.predator.Bear;
import tasks.simulation.animal.predator.Wolf;
import tasks.simulation.util.EntityUtil;

public class EntityUtilTest {
    Field field;

    @BeforeEach
    void setUp() {
        field = new Field();
    }

    @Test
    void testFieldEntityGroupShouldCountEntities() {
        EntityUtil.addEntities(field, new Point(0, 0), Plant.class, 20);
        Field.EntityGroup entityGroup = field.getEntityGroup(0, 0);
        Assertions.assertEquals(20, entityGroup.entityCnt(Plant.class));
    }

    @Test
    void testFieldEntityGroupShouldCountEntities2() {
        EntityUtil.addEntities(field, new Point(0, 0), Plant.class, 91);
        EntityUtil.addEntities(field, new Point(0, 1), Wolf.class, 30);
        Field.EntityGroup entityGroup = field.getEntityGroup(0, 0);
        Field.EntityGroup entityGroup2 = field.getEntityGroup(0, 1);
        Assertions.assertEquals(91, entityGroup.entityCnt(Plant.class));
        Assertions.assertEquals(30, entityGroup2.entityCnt(Wolf.class));
    }

    @Test
    void testFieldEntityGroupShouldThrowIllegalArgumentEx() {
        Assertions.assertThrows(RuntimeException.class, () -> EntityUtil.addEntities(field,
                new Point(0, 0), Wolf.class, 31));
        Field.EntityGroup entityGroup = field.getEntityGroup(0, 0);
    }

    @Test
    void testShouldCreateEntitiesInRandomPoints() {
        EntityUtil.addEntities(field, Bear.class, 1000);

        Assertions.assertEquals(1000, field.entityCnt());
        Assertions.assertEquals(1000, field.animalCnt());
        System.out.println(field);
    }

    @Test
    void testShouldCreateRandomEntitiesInRandomPoints() {
        EntityUtil.addEntities(field, 1000);

        Assertions.assertEquals(1000, field.entityCnt());
        Assertions.assertEquals(field.entityCnt() - field.plantCnt(), field.animalCnt());
        Assertions.assertEquals(field.entityCnt() - field.animalCnt(), field.plantCnt());

        System.out.println(field);
    }
}
