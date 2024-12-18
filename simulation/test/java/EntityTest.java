package tasks.simulation.test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.simulation.Entity;
import tasks.simulation.Field;
import tasks.simulation.Point;
import tasks.simulation.animal.herbivore.Caterpillar;
import tasks.simulation.animal.herbivore.Duck;
import tasks.simulation.animal.herbivore.Mouse;
import tasks.simulation.util.EntityUtil;

import java.util.ArrayList;
import java.util.List;

public class EntityTest {
    private Field field;

    @BeforeEach
    void setUp() {
        field = new Field();
    }

    @Test
    public void testEntityShouldHaveDifferentHashCode() {
        EntityUtil.addEntities(field, new Point(0, 0), Duck.class, 199);
        EntityUtil.addEntities(field, new Point(0, 1), Mouse.class, 499);
        EntityUtil.addEntities(field, new Point(0, 2), Caterpillar.class, 999);

        checkEntityGroup(field.getEntityGroup(0, 0), Duck.class);
        checkEntityGroup(field.getEntityGroup(0, 1), Mouse.class);
        checkEntityGroup(field.getEntityGroup(0, 2), Caterpillar.class);
    }

    public void checkEntityGroup(Field.EntityGroup group, Class<? extends Entity> clazz) {
        List<Entity> entities = new ArrayList<>(group.getEntities());

        Entity entity = EntityUtil.newInstance(field, clazz);

        int hashCode = entity.hashCode();

        for (Entity x : entities) {
            int otherHashCode = x.hashCode();
            System.out.println(otherHashCode);
            Assertions.assertNotEquals(hashCode, otherHashCode);
        }
    }
}
