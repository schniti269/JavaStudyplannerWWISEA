import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class course implements Serializable {
    public ArrayList<task> ToDoTaskList;
    public int NbrTasks(){
        return ToDoTaskList.size();
    }
    public String name;
    public Date DueDate;
    private int DoneHrsCount;

    private int remainigHrs(){
        int sum=0;
        for(task t:ToDoTaskList){
            sum+=t.duration;
        }
        return sum;
    }
    public course(String name, Date date,ArrayList<task> tasks){
        this.DueDate=date;
        this.name=name;
        this.ToDoTaskList= tasks;
        this.DoneHrsCount=0;
    }
    public void addTask(task t){
        this.ToDoTaskList.add(t);
    }
    public void DoTask(int nr){
        task temp = ToDoTaskList.get(nr);
        ToDoTaskList.remove(nr);
        DoneHrsCount+=temp.duration;
    }
    public void sort(){
            ToDoTaskList.sort(task::compareTo);
    }
    public void Print(){
        System.out.println("Name: "+name);
        System.out.println("Aufgaben:");
        for(task t: ToDoTaskList){
            System.out.println("    Name:"+t.name);
            System.out.println("    Zeit:"+t.duration);
        }
    }
    public boolean save(){
        try{
            FileOutputStream fos = new FileOutputStream("Courses"+File.separator+name+".course");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public static course read(File f){
        try (FileInputStream fis = new FileInputStream(f);){
            ObjectInputStream ois = new ObjectInputStream(fis);
            course c = (course)ois.readObject();
            return c;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
