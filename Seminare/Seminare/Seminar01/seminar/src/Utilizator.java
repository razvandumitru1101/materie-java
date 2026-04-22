public class Utilizator implements Behaviour_ {
    private String name;
   private  int age;
   private String userType;
    Utilizator(){};
   Utilizator(String name,int age,String userType)

   {
       this.age=age;
       this.name=name;
       this.userType=userType;

   }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void login() {
        System.out.println("Bun venit utilizatorului:");
    }
}
