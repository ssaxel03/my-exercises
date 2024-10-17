package io.codeforall.fanstatics;

public class Vectors {

    public static float[] getNormalizedDirection(int directionX, int directionY) {

        int length = (int) Vectors.getVectorLength(directionX, directionY);

        System.out.println("LENGTH " + length);

        return new float[] { (float)directionX / length, (float)directionY / length};
    }

    public static double getVectorLength(int directionX, int directionY) {
        return Math.sqrt((directionX * directionX) + (directionY * directionY));
    }

}
