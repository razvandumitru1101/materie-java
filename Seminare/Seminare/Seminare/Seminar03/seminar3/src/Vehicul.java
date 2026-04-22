public abstract class Vehicul {
    private String brand;
    private double speed;

    public Vehicul(){};
     public   Vehicul(String brand, double speed){
     this.brand=brand;
     this.speed=speed;
 }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void differentParam(){}
}

