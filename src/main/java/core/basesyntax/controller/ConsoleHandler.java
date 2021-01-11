package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String QUIT_APP = "q";
    private static final String DIVIDER = " ";
    private static final int INDEX_VALUE = 0;
    private static final int INDEX_RISK = 1;
    private static final int INDEX_NAME = 0;
    private static final int INDEX_SPORT = 1;
    private final BetDao betDao = new BetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public void handleBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(QUIT_APP)) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(DIVIDER);
                if (betData.length != 2) {
                    throw new RuntimeException("Incorrect data, expected pair of values");
                }
                int value = Integer.parseInt(betData[INDEX_VALUE]);
                double risk = Double.parseDouble(betData[INDEX_RISK]);
                bet = new Bet(value, risk);
                betDao.addBet(bet);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter correct data:");
            }
            System.out.println(bet == null ? null : bet.toString());
        }
    }

    public void handleUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase(QUIT_APP)) {
                System.out.println(userDao.getAll());
                return;
            }
            String[] userData = command.split(DIVIDER);
            if (userData.length != 2) {
                throw new RuntimeException("Incorrect data, expected pair of values");
            }
            String name = userData[INDEX_NAME];
            String sport = userData[INDEX_SPORT];
            if (name.length() == 0 || sport.length() == 0) {
                System.out.println("Please, enter correct name and favourite sport");
            } else {
                User user = new User(name, sport);
                userDao.add(user);
            }
        }
    }
}
