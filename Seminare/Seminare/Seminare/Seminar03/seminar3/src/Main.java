public class Main{
    static void main(String[] args) {
//        Car c=new Car("mercedes",250,4);
//        Car c1=new Car("Honda",190,4);
//        Truck t1=new Truck("Scania",90,50);
//        Motorcycle m1=new Motorcycle("yamaga",300,800);
        Vehicul[] v= {
                new Car("mercedes",250,4),
                new Truck("Scania",90,50),
                new Motorcycle("yamaga",300,800)
        };

    Car c2=new Car("honda",250,4);
    Car c3=new Car("honda",200,4);
 if(c2.equals(c3)){
        System.out.println("they are the same thing");
    }else{
        System.out.println("not the same objects");
    }

}
}

