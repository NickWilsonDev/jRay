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


    /* vector math operations */
    public Vector3 add(Vector3 vec) {
        return new Vector3(vector[0] + vec.vector[0], vector[1] + vec.vector[1], vector[2] + vec.vector[2]);
    }

    public Vector3 sub(Vector3 vec) {
        return new Vector3(vector[0] - vec.vector[0], vector[1] - vec.vector[1], vector[2] - vec.vector[2]);
    }

    public Vector3 mult(Vector3 vec) {
        return new Vector3(vector[0] * vec.vector[0], vector[1] * vec.vector[1], vector[2] * vec.vector[2]);
    }

    public Vector3 div(Vector3 vec) {
        return new Vector3(vector[0] / vec.vector[0], vector[1] / vec.vector[1], vector[2] / vec.vector[2]);
    }

    /* scalar math operations */
    public Vector3 scalarMult(float scalar) {
        return new Vector3(vector[0] * scalar, vector[1] * scalar, vector[2] * scalar);
    }

    public Vector3 scalarDiv(float scalar) {
        return new Vector3(vector[0] / scalar, vector[1] / scalar, vector[2] / scalar);
    }


    public float length() {
        return (float)Math.sqrt(vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2]);
    }

    public float lengthSquared() {
        return (vector[0] * vector[0] + vector[1] * vector[1] + vector[2] * vector[2]);
    }

    public float dot(Vector3 vec) {
        return (vector[0] * vec.vector[0] + vector[1] * vec.vector[1] + vector[2] * vec.vector[2]);
    }

    public Vector3 cross(Vector3 veca, Vector3 vecb) {
        return new Vector3( (veca.vector[1] * vecb.vector[2] - veca.vector[2] * vecb.vector[1]),
                (-(veca.vector[0] * vecb.vector[2] - veca.vector[2] * vecb.vector[0])),
                (veca.vector[0] * vecb.vector[1] - veca.vector[1] * vecb.vector[0]));
    }

    public Vector3 unitVector() {
        float length = this.length();
        return this.scalarDiv(length());
    }


    /* getters for x,y,z and r,g,b */
    public float x() {
        return vector[0];
    }
    public float y() {
        return vector[1];
    }
    public float z() {
        return vector[2];
    }
    public float r() {
        return vector[0];
    }
    public float g() {
        return vector[1];
    }
    public float b() {
        return vector[2];
    }
}
