package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private final BetDao betDao = new BetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public void handleBet() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Please, enter correct data:");
            }
            betDao.addBet(bet);
            System.out.println(bet == null ? null : bet.toString());
        }
    }

    public void handleUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                System.out.println(userDao.getAll());
                return;
            }
            String[] userData = command.split(" ");
            String name = userData[0];
            String sport = userData[1];
            if (name.length() == 0 || sport.length() == 0) {
                System.out.println("Please, enter correct name and favourite sport");
            } else {
                User user = new User(name,sport);
                userDao.add(user);
            }
        }
    }
}
