package src;

import src.util.Ray;
import src.util.Vector3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JRay {


    public static Vector3 color(Ray ray) {
        Vector3 unitDirection = ray.getDirection().unitVector();
        float t = (float)0.5 * (unitDirection.y() + 1.0f);
        Vector3 tempVecA = new Vector3(1.0f, 1.0f, 1.0f);
        Vector3 tempVecB = new Vector3(0.5f, 0.7f, 1.0f);
        tempVecA = tempVecA.scalarMult(1.0f - t);
        tempVecB = tempVecB.scalarMult(t);
        return tempVecA.add(tempVecB);
    }

    public static void main(String[] args) {

        // temp for quick test will change in future
        int nx = 200;
        int ny = 100;



        try {
            PrintWriter outfile = new PrintWriter("picture.ppm");
            System.out.println("Writing out to file: " + "picture.ppm");

            outfile.println("P3");   // Ascii PPM file
            outfile.println("# Image created by program");
            outfile.println(nx + " " + ny);
            outfile.println(255);

            Vector3 lowerLeftCorner = new Vector3(-2.0f, -1.0f, -1.0f);
            Vector3 horizontal = new Vector3(4.0f, 0.0f, 0.0f);
            Vector3 vertical = new Vector3(0.0f, 2.0f, 0.0f);
            Vector3 origin = new Vector3(0.0f, 0.0f, 0.0f);

            for (int j = ny - 1; j >= 0; j--) {
                for(int i = 0; i < nx; i++) {
                    float u = (float)i / (float)nx;
                    float v = (float)j / (float)ny;
                    Ray ray = new Ray(origin, lowerLeftCorner.add(horizontal.scalarMult(u).add(vertical.scalarMult(v))));
                    Vector3 color = JRay.color(ray);

                    int ir = (int)(255.99 * color.r());
                    int ig = (int)(255.99 * color.g());
                    int ib = (int)(255.99 * color.b());
                    outfile.println(ir + " " + ig + " " + ib + "\n");
                }
            }
            outfile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
