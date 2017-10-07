package IoDemo;

import java.io.*;

public class IoDemo {
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
        InputStream in;
        OutputStream out;
        //new FileInputStream(path); //С ним работать не прикольно делаем
        //new BufferedInputStream(new FileOutputStream(path);); //С ним тоже не прикольно работать
        try (DataOutputStream dataOS = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        //dataOS.writeInt(1);
    }
}
