package src.util;

public class Vector3 {

    private float[] vector;

    public Vector3() {
    }

    public Vector3(float e0, float e1, float e2) {
        vector = new float[3];
        vector[0] = e0;
        vector[1] = e1;
        vector[2] = e2;
    }
}
