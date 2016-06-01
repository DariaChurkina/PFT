package ru.direc.sand;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testPoint() {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(7, 3);
        Assert.assertEquals(p1.distanceTo(p2), 6.0);
    }

}
