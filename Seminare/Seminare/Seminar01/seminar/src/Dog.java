import java.sql.SQLOutput;

public class Dog implements Interfata{
    private String name ;
    private int age;
   private  String race;



    public Dog(){}

    public Dog(String name,int age,String race)
    {
        this.name=name;
        this.age=age;
        this.race=race;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", race='" + race + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }


    @Override
    public void bark() {
        System.out.println("ham ham");
    }




}
