import java.util.ArrayList;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        File Folder =new File("Courses");
        File file= new File(Folder.getPath()+File.separator+"Mathe.course");

        ArrayList tasks = new ArrayList<task>();
        for(int i=0; i<10;i++){
            int rtime=ThreadLocalRandom.current().nextInt(1, 7 + 1);
            tasks.add(new task("Aufgabe"+i,rtime));
        }
        course c2 = new course("Mathe",null,tasks);
        c2.save();


        course c = course.read(file);
        c.sort();
        c.Print();
        c.DoTask(3);
        c.Print();
        c.name="prog2";
        c.save();
    }
}