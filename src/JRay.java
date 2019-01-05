package src;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JRay {

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

            for (int j = ny - 1; j >= 0; j--) {
                for(int i = 0; i < nx; i++) {
                    float r = (float)i / (float)nx;
                    float g = (float)j / (float)ny;
                    float b = (float) 0.2;

                    int ir = (int)(255.99 * r);
                    int ig = (int)(255.99 * g);
                    int ib = (int)(255.99 * b);
                    outfile.println(ir + " " + ig + " " + ib + "\n");
                }
            }
            outfile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
