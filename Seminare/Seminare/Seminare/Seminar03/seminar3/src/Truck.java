import javax.crypto.spec.PSource;
import java.security.PublicKey;
import java.util.Objects;

public class Truck extends Vehicul{

    private float consumption;
    public Truck(){super();}
    public Truck(String brand,double speed,float consumption) {

         super( brand, speed);
        this.consumption=consumption;

    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Float.compare(consumption, truck.consumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(consumption);
    }

    @Override
    public void differentParam() {
        System.out.println("consumption");
    }
}
