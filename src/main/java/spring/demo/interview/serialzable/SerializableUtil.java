package spring.demo.interview.serialzable;

import java.io.*;

/**
 * @Package: spring.demo.interview.serialzable
 * @ClassName: SerializableUtil
 * @Description: 序列化及反序列化
 * @Author: liangxin
 * @CreateDate: 2019/7/30 16:29
 * @UpdateDate: 2019/7/30 16:29
 */
public class SerializableUtil {

    public static void main(String[] args) {
//        UserSeria user = new UserSeria();
//        user.setUserId(4);
//        user.setUserName("liangxin");
//        System.out.println(user);
//
//        toSerial("C:\\demo\\serializable\\UserSeria.txt", user);

        System.out.println("下面开始反序列化...");
        UserSeria userSeria = fromSerial("C:\\demo\\serializable\\UserSeria.txt");

//        System.out.println(userSeria == user);
    }

    /**
     * 序列化过程
     * filePath 具体到文件后缀
     */
    public static void toSerial(String filePath, UserSeria user) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();

            System.out.println("序列化完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化过程
     * filePath 具体到文件后缀
     */
    public static UserSeria fromSerial(String filePath){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            UserSeria user = (UserSeria) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("反序列化完毕！反序列的对象为：" + user);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
