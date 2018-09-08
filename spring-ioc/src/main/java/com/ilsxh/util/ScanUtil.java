package com.ilsxh.util;

import com.ilsxh.annotation.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScanUtil {

    public static List<Map<String, Object>> list = new ArrayList<>();

    /**
     * 容器启动时候要执行该方法
     * @throws Exception
     */
    public static void doScan() throws Exception {
        String packagePath = "D:\\IDEAProjects\\spring\\spring-ioc\\src\\main\\java\\com\\ilsxh";

        File file = new File(packagePath);

        String[] childFile = file.list();
        for (String fileName : childFile) {
            File innerFile = new File(packagePath + "\\" + fileName);
            String clazzFileName[] = innerFile.list();
            for (String clazzName : clazzFileName) {
                clazzName = clazzName.substring(0, clazzName.indexOf("."));
                Object object = null;
                try {
                    Class clazz = Class.forName("com.ilsxh." + fileName + "." + clazzName);

                    if (clazz.isAnnotationPresent(Component.class)) {
                        object = clazz.newInstance();
                        Map<String, Object> map = new HashMap<>();
                        map.put(clazz.getSimpleName(), object);
                        list.add(map);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (Map<String, Object> map : list) {
            for (String clazzName : map.keySet()) {
                // 拿到实例化对象
                Object tempObject = map.get(clazzName);
                // 获取对象中的field，
                Field[] fields = tempObject.getClass().getDeclaredFields();
                for (Field field : fields) {
                    // 进一步判断是否有@Autowired注解
                    if (field.isAnnotationPresent(Autowired.class)) {
                        // 获取属性名称
                        String targetName = field.getType().getSimpleName();

                        // 遍历list， 寻找对应的对象注入到该属性中去
                        for (Map<String, Object> map1 : list) {
                            for (String clazzName1 : map1.keySet()) {
                                // 如果容器中找到对象，那么直接注入到属性中去
                                if (map1.get(clazzName1).getClass().getSimpleName().equals(targetName)) {
                                    field.setAccessible(true);
                                    field.set(tempObject, map1.get(clazzName1));
                                }
                            }
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        try {
            new ScanUtil().doScan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
































