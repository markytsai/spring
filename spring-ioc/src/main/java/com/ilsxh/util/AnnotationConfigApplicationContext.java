package com.ilsxh.util;

import java.util.Map;

public class AnnotationConfigApplicationContext {

    public AnnotationConfigApplicationContext() {
        try {
            ScanUtil.doScan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟getBean方法，参数为class对象
     * @param clazzName
     * @return
     */
    public Object getBean(String clazzName) {
        for (Map<String, Object> map : ScanUtil.list) {
            Object object = map.get(clazzName.substring(0, clazzName.indexOf(".class")));
            if (object != null) {
                return object;
            }
        }
        return null;
    }
}
