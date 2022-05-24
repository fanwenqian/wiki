package com.fan.wiki.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * bean转换工具类
 *
 * @author fan.wenqian
 * @date 2022-05-24 16:04
 */
public class CopyUtil {

    /**
     * 单实体copy
     * @param source 源实例
     * @param clazz 返回类型
     * @return 返回类型实体对象
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj;
        try {
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source,obj);
        return obj;
    }

    /**
     * 实体List copy
     * @param source 源实例
     * @param clazz 返回List中存储的实例类型
     * @return 实例List
     */
    public static <T> List<T> copyList(List<?> source,Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)) {
            for (Object o : source) {
                T obj = copy(o,clazz);
                target.add(obj);
            }
        }
        return target;
    }
}
