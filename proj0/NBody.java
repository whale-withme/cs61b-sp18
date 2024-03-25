
public class NBody {
    public static final double TIME_INCE = 10000.0;

    public static double readRadius(String path){
        In in = new In(path);
        in.readInt();
        double r = in.readDouble();
        return r;
    }

    /* Read planets info */
    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        Planet[] allPlanets = new Planet[num];
        in.readDouble();
        for(int i = 0; i < num; i++){       /* Why use this kind method init? */
            allPlanets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                                in.readDouble(), in.readDouble(), in.readString());
        }
        return allPlanets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
        String  filename = args[2];

        /* Read planets and r */
        double r = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        try {
            // System.out.println(planets.length);
            if (planets.length <= 0) {
                throw new IllegalArgumentException("error: planets have no members");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        StdDraw.enableDoubleBuffering();
        for(double time = 0; time <= T; time += 10000*dt){
            double[] xforces = new double[planets.length];
            double[] yforces = new double[planets.length];
            for(int i = 0; i < planets.length; i++){
                xforces[i] = planets[i].calcNetForceExertedByX(planets);
                yforces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            
            /* Update forces and positions */
            for(int i = 0; i < planets.length; i++){
                planets[i].update(TIME_INCE, xforces[i], yforces[i]);
            }

            /* Draw */
            StdDraw.setScale(-r, r);
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg", 2*r, 2*r);
            for(int i = 0; i < planets.length; i++){
                StdDraw.picture(planets[i].xxPos, planets[i].yyPos, planets[i].imgFileName);
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        /* Final data for autograde */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for(int i = 0; i < planets.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}
