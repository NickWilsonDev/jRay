package src.util;

public class Ray {

    Vector3 origin;

    Vector3 direction;


    public Ray() {}

    public Ray(Vector3 a, Vector3 b) {
        origin = a;
        direction = b;
    }

    public Vector3 pointAtParameter(float t) {
        return origin.add(direction.scalarMult(t));
    }

    public Vector3 getOrigin() {
        return origin;
    }

    public void setOrigin(Vector3 origin) {
        this.origin = origin;
    }

    public Vector3 getDirection() {
        return direction;
    }

    public void setDirection(Vector3 direction) {
        this.direction = direction;
    }
}
