package Lesson11;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException, InstantiationException {
        Person person = new Person();
        File testFile = new File("src/111.txt");
        BufferedReader bf = new BufferedReader(new FileReader(testFile));
        String line;
        ArrayList<String> personLine = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            personLine.add(line);
        }
        Person[] pers = new Person[personLine.size()];
        Class mClass = Person.class;
        for (int i = 0; i < personLine.size(); i++) {
            if (personLine.get(i).indexOf(' ') != -1) {
                Object obj = mClass.newInstance();
                pers[i] = (Person) obj;
                String[] words = personLine.get(i).split("\\s");
                Field fname = mClass.getDeclaredField("name");
                Field fsurname = mClass.getDeclaredField("surname");
                Field fprofession = mClass.getDeclaredField("profession");
                fname.setAccessible(true);
                fsurname.setAccessible(true);
                fprofession.setAccessible(true);
                fname.set(pers[i], words[0]);
                fsurname.set(pers[i], words[1]);
                fprofession.set(pers[i], words[3]);
            }
        }
    }
}
