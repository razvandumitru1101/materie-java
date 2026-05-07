public class Student extends Person implements Learner {
    String name;
    int age;
    String universite;
    public Student(){
        this.name = "";
        this.age = 0;
        this.universite = "";

    }
    public Student (String name)
    {
        this.name = name;
        this.age = 0;
        this.universite = "";
    }
    public Student (String name,int age)
    {
        this.name = name;
        this.age = age;
        this.universite = "";

    }
    public void Buna()
    {
        System.out.println("buna numele meu este:"+name);
    }
    private void SecretMethod()
    {
        System.out.println("metoda privata pentru studentul cu numele:"+name);
    }

    @Override
    public String toString()
    {
        return "name:"+name+" age:"+age+" universite:"+universite;
    }

    @Override
    public void learn() {

    }
}
