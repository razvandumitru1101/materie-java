import java.util.Objects;

public class Car extends  Vehicul {
    private int nrUsi;
    public Car(){super();}
    public Car(String brand,double speed,int nrUsi)
    {

        super(brand,speed);
        this.nrUsi=nrUsi;
    }

    public int getNrUsi() {
        return nrUsi;
    }

    public void setNrUsi(int nrUsi) {
        this.nrUsi = nrUsi;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return nrUsi == car.nrUsi;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nrUsi);
    }
    @Override
    public void differentParam(){
        System.out.println("nrUsi");
    }
}
