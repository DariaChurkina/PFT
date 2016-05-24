package ru.direc.sand;

public class Point {

    double x;
    double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point p) {

        return Math.sqrt ( Math.pow ((this.x - p.x), 2) +  Math.pow ((this.y - p.y), 2));
    }

    public static void main(String[]  args) {

        Point p1 = new Point (1,3);
        Point p2 = new Point (3,3);
        System.out.println(distance(p1, p2));
        System.out.println(p1.distanceTo(p2));
    }
    public static double distance(Point p1, Point p2) {

        return Math.sqrt ( Math.pow ((p2.x - p1.x), 2) +  Math.pow ((p2.y - p1.y), 2));
    }

}