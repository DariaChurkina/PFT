package ru.direc.sand;

import org.testng.annotations.Test;

public class PointTests2 {

    @Test
    public void testPoint2() {
        Point p1 = new Point (1, 9);
        Point p2 = new Point (7, 6);
        assert Point.distance(p1, p2) == 6.708203932499369;
    }
}
