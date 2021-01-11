package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.NoSuchAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                Object dao = new Object();
                if (field.getType().isAssignableFrom(BetDao.class)) {
                    dao = Factory.getBetDao();
                }
                if (field.getType().isAssignableFrom(UserDao.class)) {
                    dao = Factory.getUserDao();
                }
                if (dao.getClass().getAnnotation(Dao.class) == null) {
                    throw new NoSuchAnnotationException("Can`t find child with @Dao for class "
                            + field.getType().getName());
                }
                field.set(instance, dao);
            }
        }
        return instance;
    }
}
