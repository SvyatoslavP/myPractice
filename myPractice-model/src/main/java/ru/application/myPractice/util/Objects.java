package ru.application.myPractice.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@UtilityClass
@SuppressWarnings("unused")
public class Objects {

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    @SuppressWarnings("unused")
    public static boolean isEmpty(Object obj) {
        return obj == null || com.google.common.base.Strings.isNullOrEmpty(obj.toString());
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    @SuppressWarnings("unused")
    public static boolean isAllNull(Object... objects) {
        return Optional.ofNullable(objects)
                .map(Arrays::stream)
                .map(objectStream -> objectStream.allMatch(Objects::isNull))
                .orElse(true);
    }

    @SuppressWarnings("unused")
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return isNull(collection) || collection.isEmpty();
    }

    @SuppressWarnings("unused")
    public static boolean isNotNullNorEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    public static boolean isNullOrEmpty(Map<?, ?> collection) {
        return isNull(collection) || collection.isEmpty();
    }

    @SuppressWarnings("unused")
    public static boolean isNotNullNorEmpty(Map<?, ?> collection) {
        return !isNullOrEmpty(collection);
    }

    @SuppressWarnings("unused")
    public static boolean isNullOrEmpty(String str) {
        return com.google.common.base.Strings.isNullOrEmpty(str);
    }

    public static boolean isNotNullNorEmpty(String str) {
        return !com.google.common.base.Strings.isNullOrEmpty(str);
    }

    @SuppressWarnings("unused")
    public static boolean isSpecified(Object obj) {
        if (obj instanceof String) {
            return isNotNullNorEmpty((String) obj);
        }
        return isNotNull(obj);
    }

    @SuppressWarnings("unused")
    public static <T> T defaultIfNull(final T object, final T defaultValue) {
        return ObjectUtils.defaultIfNull(object, defaultValue);
    }

    @SuppressWarnings("unused")
    public static boolean isEquals(Object a, Object b) {
        return java.util.Objects.deepEquals(a, b);
    }

}
