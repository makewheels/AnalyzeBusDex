package com.google.zxing;

public class ResultPoint {
    /* renamed from: x */
    private final float f4343x;
    /* renamed from: y */
    private final float f4344y;

    public ResultPoint(float x, float y) {
        this.f4343x = x;
        this.f4344y = y;
    }

    public final float getX() {
        return this.f4343x;
    }

    public final float getY() {
        return this.f4344y;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ResultPoint)) {
            return false;
        }
        ResultPoint otherPoint = (ResultPoint) other;
        if (this.f4343x == otherPoint.f4343x && this.f4344y == otherPoint.f4344y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f4343x) * 31) + Float.floatToIntBits(this.f4344y);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(25);
        result.append('(');
        result.append(this.f4343x);
        result.append(',');
        result.append(this.f4344y);
        result.append(')');
        return result.toString();
    }

    public static void orderBestPatterns(ResultPoint[] patterns) {
        ResultPoint pointB;
        ResultPoint pointA;
        ResultPoint pointC;
        float zeroOneDistance = distance(patterns[0], patterns[1]);
        float oneTwoDistance = distance(patterns[1], patterns[2]);
        float zeroTwoDistance = distance(patterns[0], patterns[2]);
        if (oneTwoDistance >= zeroOneDistance && oneTwoDistance >= zeroTwoDistance) {
            pointB = patterns[0];
            pointA = patterns[1];
            pointC = patterns[2];
        } else if (zeroTwoDistance < oneTwoDistance || zeroTwoDistance < zeroOneDistance) {
            pointB = patterns[2];
            pointA = patterns[0];
            pointC = patterns[1];
        } else {
            pointB = patterns[1];
            pointA = patterns[0];
            pointC = patterns[2];
        }
        if (crossProductZ(pointA, pointB, pointC) < 0.0f) {
            ResultPoint temp = pointA;
            pointA = pointC;
            pointC = temp;
        }
        patterns[0] = pointA;
        patterns[1] = pointB;
        patterns[2] = pointC;
    }

    public static float distance(ResultPoint pattern1, ResultPoint pattern2) {
        float xDiff = pattern1.f4343x - pattern2.f4343x;
        float yDiff = pattern1.f4344y - pattern2.f4344y;
        return (float) Math.sqrt((double) ((xDiff * xDiff) + (yDiff * yDiff)));
    }

    private static float crossProductZ(ResultPoint pointA, ResultPoint pointB, ResultPoint pointC) {
        float bX = pointB.f4343x;
        float bY = pointB.f4344y;
        return ((pointC.f4343x - bX) * (pointA.f4344y - bY)) - ((pointC.f4344y - bY) * (pointA.f4343x - bX));
    }
}
