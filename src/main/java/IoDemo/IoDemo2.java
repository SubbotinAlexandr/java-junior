package IoDemo;

import java.io.*;

public class IoDemo2 {
    public static void main(String[] args) {
        File path = new File("test.txt");//Где создатся файл? Нигде
        path.exists();
        path.getAbsolutePath();
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            raf.seek(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in2;
        OutputStream out;
        //new FileInputStream(path); //С ним работать не прикольно делаем
        //new BufferedInputStream(new FileOutputStream(path);); //С ним тоже не прикольно работать
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            objectOutputStream.writeObject(new Employee("qqq", 2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))){
            Employee employee1 = (Employee)in.readObject();
            System.out.println(employee1.name);
            System.out.println((String)in.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //dataOS.writeInt(1);
    }
}

class Employee implements Serializable {
    private static long SerialVersionUID = 1L;
    public String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getCanonicalName() + "}";
    }
}