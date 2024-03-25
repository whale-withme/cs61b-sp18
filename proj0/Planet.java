public class Planet {
    private double xxPos;
    private double yyPos;
    private double xxVel;
    private double yyVel;
    private double mass;
    private String imgFileName;

    /* Constor */
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP; yyPos = yP; xxVel = xV; yyVel = yV; mass = m;
        imgFileName = img;
    }
    public Planet(Planet P){
        this.xxPos = P.xxPos; this.yyPos = P.yyPos; this.xxVel = P.xxVel; this.yyVel = P.yyVel;
        this.mass = P.mass;
        this.imgFileName = P.imgFileName;
    }

    /* Calculate distance between two planets */
    public double calcDistance(Planet object){
        double x_ = this.xxPos - object.xxPos;
        double y_ = this.yyPos - object.yyPos;
        double distance = Math.sqrt(x_*x_ + y_*y_);
        return distance;
    }

    public double calcForceExertedBy(Planet obj){
        double dis = this.calcDistance(obj);
        double force = (6.67e-11) * this.mass * obj.mass / (dis * dis);
        return force;
    }

    public double calcForceExertedByX(Planet obj){
        double relxx = obj.xxPos - this.xxPos;
        double dis = calcDistance(obj);
        double Fx = calcForceExertedBy(obj) * relxx / dis;
        return Fx;
    }

    public double calcForceExertedByY(Planet obj){
        /* Calculate single force on Y */
        double relyy = obj.yyPos - this.yyPos;
        double dis = calcDistance(obj);
        double Fy = calcForceExertedBy(obj) * relyy / dis;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double Fx = 0;
        for(int i = 0; i < allPlanets.length; i++){
            if(this.equals(allPlanets[i]))
                continue;
            Fx += calcForceExertedByX(allPlanets[i]);
        }
        assert(Fx != 0);
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        /* Calculate all forces on Y direction */
        double Fy = 0;
        for(int i = 0; i < allPlanets.length; i++){
            if(this.equals(allPlanets[i]))
                continue;
            Fy += calcForceExertedByY(allPlanets[i]);
        }
        assert(Fy != 0);
        return Fy;
    }

    public void update(double dt, double fx, double fy){
        /* Update xxpos and yypos etc */
        double accx = fx/this.mass, accy = fy/this.mass;
        double DetaXvels = dt*accx, DetaYvels = accy*dt;
        this.xxVel += DetaXvels;
        this.yyVel += DetaYvels;

        double DetaXpos = this.xxVel*dt;
        double DetaYpos = this.yyVel*dt;
        this.xxPos += DetaXpos;
        this.yyPos += DetaYpos;
    }

    public void draw(){
        /* Draw itself*/
        StdDraw.picture(xxPos, yyPos, this.imgFileName);
    }
}