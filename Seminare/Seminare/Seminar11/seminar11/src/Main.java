public class Main {

    public static void main(String[] args) {
        try {
            Class<?> studentClass = Student.class;

            System.out.println("1. CLASS INFORMATION");
            Task.printClassInformation(studentClass);

            System.out.println();
            System.out.println("2. DECLARED FIELDS");
            Task.listAllFields(studentClass);

            System.out.println();
            System.out.println("3. DECLARED METHODS");
            Task.listAllMethods(studentClass);

            System.out.println();
            System.out.println("4. CREATE OBJECT DYNAMICALLY");
            Object student1 = Task.createObjectDynamically(studentClass);
            System.out.println(student1);

            System.out.println();
            System.out.println("5. CALL PUBLIC METHOD");
            Task.callPublicMethod(student1, "Buna");

            System.out.println();
            System.out.println("6. ACCESS PRIVATE FIELD");
          Task.accessPrivateField(student1, "name", "Ana");
            System.out.println(student1);

            System.out.println();
            System.out.println("7. INVOKE PRIVATE METHOD");
            Task.invokePrivateMethod(student1, "SecretMethod");

            System.out.println();
            System.out.println("8. CONSTRUCTOR SELECTION");

            Object s1 = Task.createObjectWithConstructor(Student.class);
            Object s2 = Task.createObjectWithConstructor(Student.class, "Maria");
            Object s3 = Task.createObjectWithConstructor(Student.class, "Ion", 22);

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);

            System.out.println();
            System.out.println("9. OBJECT INSPECTOR");
            Task.inspect(s3);

            System.out.println();
            System.out.println("10. JSON SERIALIZER");
            String json = Task.toJson(s3);
            System.out.println(json);

            System.out.println();
            System.out.println("11. CSV MAPPER");

            String[] headers = {"name", "age", "university"};
            String[] values = {"Ana", "20", "UPB"};

            Student csvStudent = Task.fromCsv(Student.class, headers, values);
            System.out.println(csvStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}