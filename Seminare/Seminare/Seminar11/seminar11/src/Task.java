import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task {

    public static void printClassInformation(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getName());

        Package packageName = clazz.getPackage();
        System.out.println("Package name: " + packageName);

        Class<?> superclass = clazz.getSuperclass();
        System.out.println("Superclass: " + superclass.getName());

        System.out.println("Implemented interfaces:");
        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> currentInterface : interfaces) {
            System.out.println("- " + currentInterface.getName());
        }
    }

    public static void listAllFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            String modifiers = Modifier.toString(field.getModifiers());
            String type = field.getType().getSimpleName();
            String name = field.getName();

            System.out.println(modifiers + " " + type + " " + name);
        }
    }

    public static void listAllMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            String modifiers = Modifier.toString(method.getModifiers());
            String returnType = method.getReturnType().getSimpleName();
            String methodName = method.getName();

            System.out.print(modifiers + " " + returnType + " " + methodName + "(");

            Class<?>[] parameterTypes = method.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getSimpleName());

                if (i < parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }
    }

    public static Object createObjectDynamically(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }

    public static void callPublicMethod(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();

        Method method = clazz.getMethod(methodName);
        method.invoke(obj);
    }

    public static void accessPrivateField(Object obj, String fieldName, Object newValue) throws Exception {
        Class<?> clazz = obj.getClass();

        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);

        System.out.println("Old value: " + field.get(obj));

        field.set(obj, newValue);

        System.out.println("New value: " + field.get(obj));
    }

    public static void invokePrivateMethod(Object obj, String methodName) throws Exception {
        Class<?> clazz = obj.getClass();

        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);

        method.invoke(obj);
    }

    public static Object createObjectWithConstructor(Class<?> clazz, Object... args) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            if (parameterTypes.length == args.length && parametersMatch(parameterTypes, args)) {
                constructor.setAccessible(true);
                return constructor.newInstance(args);
            }
        }

        throw new RuntimeException("No matching constructor found.");
    }

    private static boolean parametersMatch(Class<?>[] parameterTypes, Object[] args) {
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            Object argument = args[i];

            if (argument == null) {
                continue;
            }

            if (parameterType.isPrimitive()) {
                parameterType = convertPrimitiveToWrapper(parameterType);
            }

            if (!parameterType.isAssignableFrom(argument.getClass())) {
                return false;
            }
        }

        return true;
    }

    private static Class<?> convertPrimitiveToWrapper(Class<?> type) {
        if (type == int.class) {
            return Integer.class;
        }

        if (type == long.class) {
            return Long.class;
        }

        if (type == double.class) {
            return Double.class;
        }

        if (type == float.class) {
            return Float.class;
        }

        if (type == boolean.class) {
            return Boolean.class;
        }

        if (type == char.class) {
            return Character.class;
        }

        if (type == byte.class) {
            return Byte.class;
        }

        if (type == short.class) {
            return Short.class;
        }

        return type;
    }

    public static void inspect(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        System.out.println("Inspecting object of class: " + clazz.getName());

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            String fieldName = field.getName();
            Object fieldValue = field.get(obj);

            System.out.println(fieldName + " = " + fieldValue);
        }
    }

    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder();
        json.append("{");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            String fieldName = field.getName();
            Object fieldValue = field.get(obj);

            json.append("\"").append(fieldName).append("\":");

            if (fieldValue instanceof String) {
                json.append("\"").append(fieldValue).append("\"");
            } else {
                json.append(fieldValue);
            }

            if (i < fields.length - 1) {
                json.append(",");
            }
        }

        json.append("}");

        return json.toString();
    }

    public static <T> T fromCsv(Class<T> clazz, String[] headers, String[] values) throws Exception {
        Constructor<T> constructor = clazz.getConstructor();
        T object = constructor.newInstance();

        Map<String, String> csvData = new LinkedHashMap<>();

        for (int i = 0; i < headers.length; i++) {
            csvData.put(headers[i], values[i]);
        }

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            String fieldName = field.getName();

            if (csvData.containsKey(fieldName)) {
                String value = csvData.get(fieldName);
                Object convertedValue = convertStringToFieldType(value, field.getType());

                field.set(object, convertedValue);
            }
        }

        return object;
    }

    private static Object convertStringToFieldType(String value, Class<?> type) {
        if (type == String.class) {
            return value;
        }

        if (type == int.class || type == Integer.class) {
            return Integer.parseInt(value);
        }

        if (type == long.class || type == Long.class) {
            return Long.parseLong(value);
        }

        if (type == double.class || type == Double.class) {
            return Double.parseDouble(value);
        }

        if (type == boolean.class || type == Boolean.class) {
            return Boolean.parseBoolean(value);
        }

        throw new RuntimeException("Unsupported field type: " + type.getName());
    }
}