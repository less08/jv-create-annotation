package core.basesyntax.factory;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        return betDao == null ? new BetDaoImpl() : betDao;
    }

    public static UserDao getUserDao() {
        return userDao == null ? new UserDaoImpl() : userDao;
    }
}
