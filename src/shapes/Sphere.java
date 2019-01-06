package src.shapes;

import src.util.Ray;
import src.util.Vector3;

public class Sphere {

    public Vector3 center;
    public float radius;
    public float radiusSquared;

    public Sphere() {}

    public Sphere(Vector3 c, float r) {
        center = new Vector3(c.x(), c.y(), c.z());
        radius = r;
        radiusSquared = r * r;
    }

    public float hit(Ray r) {

        Vector3 oc = r.getOrigin().sub(this.center);
        float a = r.getDirection().dot(r.getDirection());
        float b = oc.dot(r.getDirection()) * 2.0f;
        float c = oc.dot(oc) - radiusSquared;
        float discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return -1.0f;
        } else {
            return (float) ( -b - Math.sqrt(discriminant)) / (2.0f * a);
        }
    }

    public Vector3 color(Ray r) {
        // will change this later
        Sphere tempSphere = new Sphere(new Vector3(0, 0, -1), 0.5f);
        float t = tempSphere.hit(r);
        if ( t > 0.0) {
            Vector3 n = r.pointAtParameter(t).sub(new Vector3(0, 0, -1)).unitVector();
            return new Vector3(n.x() + 1, n.y() + 1, n.z() + 1).scalarMult(0.5f);
        }

        Vector3 unitDirection = r.getDirection().unitVector();
        t = 0.5f * (unitDirection.y() + 1.0f);
        Vector3 colorA = new Vector3(1.0f, 1.0f, 1.0f).scalarMult(1.0f - t);
        Vector3 colorB = new Vector3(0.5f, 0.7f, 1.0f).scalarMult(t);
        return colorA.add(colorB);
    }
}
