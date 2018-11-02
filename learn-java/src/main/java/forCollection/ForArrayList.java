package forCollection;

import org.junit.Test;
import util.UtilFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ForArrayList {


    /**
     * transient关键字，使用自定义的序列化方法，因为ArrayList可能有很多空的数据，全部序列化会浪费内存
     */

    @Test
    public void writeObject() {
        List<Long> longList = new ArrayList<>();
        longList.add(1L);
        longList.add(2L);
        List<String> stringList=new ArrayList<>();
        stringList.add("string one ");
        stringList.add("string tow ");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(UtilFile.getOrCreate("arrayListSerialize.txt"))) ){
            objectOutputStream.writeObject(longList);
            objectOutputStream.writeObject(stringList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readObject(){
        List<Long> longList=null;
        List<String> stringList=null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(UtilFile.getOrCreate("arrayListSerialize.txt"))) ){
            longList= (List<Long>) objectInputStream.readObject();
            stringList= (List<String>) objectInputStream.readObject();
            System.out.println(longList);
            System.out.println(stringList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
