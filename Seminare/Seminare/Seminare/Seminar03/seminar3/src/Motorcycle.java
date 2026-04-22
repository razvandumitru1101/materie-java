import java.util.Objects;

public class Motorcycle extends Vehicul {
    private float cc;
    Motorcycle(){super();}
    Motorcycle(String brand,double speed,float cc){

        super(brand,speed);
        this.cc=cc;
    }

    public float getCc() {
        return cc;
    }

    public void setCc(float cc) {
        this.cc = cc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return Float.compare(cc, that.cc) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cc);
    }
    @Override
    public void differentParam() {
        System.out.println("cc");
    }
}
