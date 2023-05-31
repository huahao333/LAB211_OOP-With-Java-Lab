package Test;

import Manage.Dealer;
import Manage.DealerManage;
import Manage.I_Dealer;
import Manage.Validation;
import Login.I_User;
import Login.User;
import Login.UserManage;

import java.io.FileReader;
import java.util.Properties;

public class Management_System {

    public static void main(String[] args) throws Exception {
        UserManage user = new UserManage();
        DealerManage dealer = new DealerManage();
        FileReader reader = new FileReader("config.properties");

        Properties p = new Properties();
        p.load(reader);
        String filenameD;
        String filenameU;
        filenameU = p.getProperty("users_file");
        filenameD = p.getProperty("dealers_file");

        boolean changed = true;
        int choiceL = 0;
        int choiceC = 0;

        user.loadFromUserFile(filenameU);
        changed = true;

        dealer.readDealerFile(filenameD);
        changed = true;

        System.out.println(
                "----LOGIN TO MANAGE SYSTEM----");
        String[] login = {"LOGIN", "QUIT"};
        String[] options = {"ADD NEW DEALER", "SEARCH A DEALER BY ID", "REMOVE DEALER BY ID", "UPDATE DEALER", "PRINT ALL DEALER", "SAVE ALL TO FILE", "LOGOUT"};
        choiceL = Validation.getChoice(login);
        backpoint:

        do {
            switch (choiceL) {

                case 1:

                    user.login();

                    do {
                        switch (choiceC = Validation.getChoice(options)) {

                            case 1:
                                dealer.add();

                                break;

                            case 2:
                                dealer.search();
                                break;
                            case 3:
                                dealer.remove();
                                break;
                            case 4:
                                dealer.update();
                                break;
                            case 5:
                                dealer.print();
                                break;
                            case 6:
                                dealer.writeToFile(filenameD);
                                dealer.removeAll(dealer);
                                dealer.readDealerFile(filenameD);
                                break;
                            case 7:
                                continue backpoint;
                        }
                    } while (choiceC > 0 && choiceC < (choiceC + 1));
                    break;
                case 2:
                    System.exit(0);

            }

        } while (choiceL > 0 && choiceL < (choiceL + 1));
    }
}
