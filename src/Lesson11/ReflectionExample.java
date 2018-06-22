package Lesson11;

import java.lang.reflect.Field;

public class ReflectionExample {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
        Person ps = new Person();
        ReflectionExample refl = new ReflectionExample();
        refl.toString(ps);
    }
    public static void toString (Object object) throws IllegalAccessException, ClassNotFoundException {
        String name;
        if (object instanceof String){
            name = String.valueOf(object);
        } else {
            name = String.valueOf(object.getClass().getName());
        }
        Class claz = Class.forName(name);
        Field [] fields = claz.getDeclaredFields();
        for (Field field : fields){
            if (field.getType().isPrimitive()) {
                field.setAccessible(true);
                System.out.println(String.valueOf(field.getType()+ " " +field.get(object)));
            }
            else if (field.getType().isArray()){
                field.setAccessible(true);
                int [] elements = (int[]) field.get(object);
                for (int el : elements)
                System.out.println(field.getType()+ " " +el);
            }
            else if (field.getType() == String.class) {
                field.setAccessible(true);
                System.out.println(field.getType()+ " " + field.get(object));
            }
            else {
                field.setAccessible(true);
                System.out.println(field.getType());
                toString(field.getType().getName());
            }
        }
    }
}
