package Lesson11;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        File testFile = new File("src/111.txt");
        BufferedReader bf = new BufferedReader(new FileReader(testFile));
        String line;
        ArrayList<String> personLine = new ArrayList<>();
        while ((line = bf.readLine()) != null) {
            personLine.add(line);
        }
        Person[] pers = new Person[personLine.size()];
        for (int i = 0; i < personLine.size(); i++) {
            if (personLine.get(i).indexOf(' ') != -1) {
                Person person = new Person();
                pers[i] = person;
                Class mClass = Person.class;
                String[] words = personLine.get(i).split("\\s");
                Field fname = mClass.getDeclaredField("name");
                Field fsurname = mClass.getDeclaredField("surname");
                Field fprofession = mClass.getDeclaredField("profession");
                fname.setAccessible(true);
                fsurname.setAccessible(true);
                fprofession.setAccessible(true);
                fname.set(person, words[0]);
                fsurname.set(person, words[1]);
                fprofession.set(person, words[3]);
            }
        }
                System.out.println(pers [0]);
                System.out.println(pers [1]);
                System.out.println(pers [2]);
    }
}
