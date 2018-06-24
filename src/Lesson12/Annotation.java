package Lesson12;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class Annotation {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String path = "src/Lesson9";
        String [] classNames = getClassNames(path);
        objectsToString(classNames);
    }

    public static String [] getClassNames (String path){
        File dir = new File(path);
        File[] filesInDir = dir.listFiles();
        String [] className = new String[filesInDir.length];
        for (int i = 0; i < filesInDir.length; i++){
            className[i] = filesInDir[i].getPath().substring(4);
            className[i] = className[i].replace('\\','.');
            className[i] = className[i].substring(0,className[i].lastIndexOf('.'));
        }
        return className;
    }

    public static void objectsToString (String [] lines) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ArrayList <Object> obb = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            Class claz = Class.forName(lines[i]);
            obb.add(i, claz.newInstance());
            Field[] fields = obb.get(i).getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    RandomInt annotation = field.getAnnotation(RandomInt.class);
                    if (annotation != null) {
                        int min = annotation.min();
                        int max = annotation.max();
                        field.set(obb.get(i), (int)(Math.random()*(max - min+1)+min));
                    }
                    System.out.println(String.valueOf(field.getType() + " " + field.get(obb.get(i))));
                }
        }
    }
}
