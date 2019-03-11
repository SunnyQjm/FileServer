import Data.FileInfo;
import com.google.gson.reflect.TypeToken;
import utils.GsonUtil;
import utils.SerializableUtil;

import java.io.*;
import java.util.*;

/**
 * Created by Sunny on 2017/7/8 0008.
 */
public class test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        List<FileInfo> list = new ArrayList<>();
//        Map<String, FileInfo> map = new HashMap<>();
//        list.add(new FileInfo.Builder()
//                .originalName("dasf")
//                .size(1243)
//                .build());
//        list.add(new FileInfo.Builder()
//                .uid("dasfasdfdf")
//                .originalName("dasf")
//                .size(1243)
//                .build());
//        map.put(list.get(0).getUid(), list.get(0));
//        map.put(list.get(1).getUid(), list.get(1));
//
//        File file = new File("./src/test.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(list);
//        oos.writeObject(map);
//
//        oos.close();
//        fos.close();

//        File file = new File("./src/test.txt");
//        FileInputStream fis = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        List<FileInfo> list = (List<FileInfo>) ois.readObject();
//        Map<String, FileInfo> map = (Map<String, FileInfo>) ois.readObject();
//
//        System.out.println(GsonUtil.getInstance().toJson(list));
//        System.out.println(GsonUtil.getInstance().toJson(map));
//
//        FileInfo fileInfo = list.get(0);
//        fileInfo.setOriginalName("originalName");
//
//        System.out.println(GsonUtil.getInstance().toJson(list));
//        System.out.println(GsonUtil.getInstance().toJson(map));


//        Map<String, FileInfo> map = new HashMap<>();
//        map.put("qqq1", new FileInfo.Builder().originalName("asdf").build());
//        map.put("qqq2", new FileInfo.Builder().originalName("asdf").build());
//        map.put("qqq3", new FileInfo.Builder().originalName("asdf").build());
//        SerializableUtil.serializeObjectToFile(map, "./src/main/test.dat");


//        List<FileInfo> list = new ArrayList<>();
//        Map<String, FileInfo> map = new HashMap<>();
//        list.add(new FileInfo.Builder()
//                .originalName("dasf")
//                .originalSize(1243)
//                .build());
//        list.add(new FileInfo.Builder()
//                .uid("dasfasdfdf")
//                .originalName("dasf")
//                .originalSize(1243)
//                .build());
//        map.put(list.get(0).getUid(), list.get(0));
//        map.put(list.get(1).getUid(), list.get(1));
//
//        SerializableUtil.serializeMapToFile(map, "./src/main/test1.dat", false);
//        SerializableUtil.serializeListToFile(list, "./src/main/test2.dat", false);
//
//        map = SerializableUtil.reverseSerializeMap("./src/main/test1.dat");
//        list = (List<FileInfo>) SerializableUtil.reverseSerializeMapList("./src/main/test2.dat");
//        System.out.println(list.size());

        List<String> list = new ArrayList<>();
        list.add("asdfas");
        list.add("two");
        list.remove("two");
        System.out.println(list.size());
    }
}
