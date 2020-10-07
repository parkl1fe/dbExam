import controler.ConnectionManager;
import helper.IbanGenerator;
import model.Account;
import model.Transaction;
import model.User;
import model.User_details;
import model.enums.Account_type;
import model.enums.Transaction_type;
import repository.*;
import service.TransactionService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class BankApp {


    public static void main(String[] args) throws SQLException {

        ConnectionManager cm = new ConnectionManager();

        try {
            UserRepository userRepository = new UserRepository(cm.getConnection());
            User_detailsRepository user_detailsRepository = new User_detailsRepository(cm.getConnection());
            AccountRepository accountRepository = new AccountRepository(cm.getConnection());
            TransactionRepository transactionRepository = new TransactionRepository(cm.getConnection());
            Account_transactionRepository account_transactionRepository = new Account_transactionRepository(cm.getConnection());
            TransactionService transactionService = new TransactionService(cm.getConnection());

// GET USER BY ID
            User user = userRepository.getBy(10001);
            System.out.println(user.toString());

// ADD NEW USER
            User user1 = new User(10003, "TEST");
            User_details ud = new User_details(10003, "Saulius", "Sauliokas", "none", "1234", new Date(Calendar.getInstance().getTime().getTime()));
            user_detailsRepository.create(ud);
            userRepository.create(user1);

// GET NEW USER BACK
            User user2 = userRepository.getBy(10003);
            System.out.println(user2.toString());

// GET ACCOUNT BY IBAN
            Account account = accountRepository.getBy("LT266646711884723144");
            System.out.println(account.toString());

// GET ALL ACCOUNT FOR USER
            List<Account> accountList = accountRepository.getBy(10002);
            accountList.forEach(x -> System.out.println(x.toString()));

// CREATE NEW ACCOUNT
            String newIban = new IbanGenerator().generate();
            System.out.println("NEW iban: " + newIban);
            Account account1 = new Account(newIban, 10003, 467, 0, Account_type.DEBIT, 0, "EUR");
            accountRepository.create(account1);

// GET NEW ACCOUNT
            List<Account> accountList2 = accountRepository.getBy(10003);
            accountList2.forEach(x -> System.out.println(x.toString()));

// CREATE NEW TRANSACTION
            Transaction transaction = new Transaction(7, "LT642164163593527528", "LT547328833285252748", 105.44d, new Date(Calendar.getInstance().getTime().getTime()), Transaction_type.TRANSFER, "EUR");
            transactionRepository.create(transaction);

// GET NEW TRANSACTION
            transactionRepository.getBy(7)
                    .forEach(x -> System.out.println(x.toString()));

// GET ACCOUNT_TRANSACTIONS MAPPING FOR ACCOUNT (shoul include new transaction id=7)
            account_transactionRepository.getBy("LT642164163593527528");


//CREATE TRANSACTION USING SERVICE
            Transaction transactionNew = new Transaction(8, "LT266646711884723144", "LT425365116785299977", 99.44d, new Date(Calendar.getInstance().getTime().getTime()), Transaction_type.TRANSFER, "EUR");
            transactionService.makeTransfer(transactionNew, 10002);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cm.closeConnection();
        }

    }

}
