package spring.demo.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: spring.demo.test
 * @ClassName: TestFolder
 * @Description: 递归获取某文件夹下所有的文件和对应路径
 * @Author: liangxin
 * @CreateDate: 2019/11/28 15:37
 * @UpdateDate: 2019/11/28 15:37
 */
public class TestFolder {

    public static void main(String[] args) {
        File file = new File("C:\\demo\\first");

        Map<String, String> map = getFileNameAndPath(file, new HashMap<String, String>());

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " ===> " + entry.getValue());
        }
    }

    private static Map<String, String> getFileNameAndPath(File file, Map<String, String> resultMap) {
        File[] mainFile = file.listFiles();
        for (File sonFile : mainFile) {
            if (sonFile.exists() && sonFile.isDirectory()){
                getFileNameAndPath(sonFile, resultMap);
            }else {
                resultMap.put(sonFile.getName(), sonFile.getAbsolutePath());
            }
        }

//        if (file.exists() && file.isDirectory()){
//            File[] files = file.listFiles(); // 获取目录下的所有文件/文件夹（仅该层路径下）
//            for (File sonFile : files) {
//                if (sonFile.exists() && sonFile.isDirectory()){
//                    getFileNameAndPath(sonFile);
//                }else {
//                    resultMap.put(sonFile.getName(), sonFile.getAbsolutePath());
//                }
//            }
//        }else {
//            resultMap.put(file.getName(), file.getAbsolutePath());
//        }
        return resultMap;
    }

}
