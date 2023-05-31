package Login;

import Manage.Dealer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Manage.Validation;
import Manage.DealerManage;

public class UserManage extends ArrayList<User> implements I_User {

    User u = new User();

    @Override
    public boolean loadFromUserFile(String filenameU) {
        String username, password, role, status;
        try {
            FileReader fr = new FileReader(filenameU);
            BufferedReader br = new BufferedReader(fr);
            String[] arr;
            String test = br.readLine();
            while (test != null) {

                arr = test.split("\\|");
                username = arr[0].trim();
                password = arr[1].trim();
                role = arr[2].trim();
                status = arr[3].trim();

                this.add(new User(username, password, role, status));
                test = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("IO");

        }
        return false;
    }

    public int searchU(String username) {

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getUsername().trim().equals(username)) {
                return i;
            }
        }
        return -1;

    }

    public int searchP(String password) {

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPassword().trim().equals(password)) {
                return i;
            }
        }
        return -1;

    }

    public int searchR(String role) {

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getRole().trim().equals(role)) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public void login() {

        int count1 = 0;
        int count2 = 0;
        int count3;
        String role;
        String password;
        String username;
        String roleCheck;
        String askYN = "";

        boolean count = false;
        DealerManage us = new DealerManage();

        do {

            username = Validation.inputStr("ENTER USERNAME:").trim();

            count1 = this.searchU(username);

            password = Validation.inputStr("ENTER PASSWORD: ");
            count2 = this.searchP(password);

            if (count1!= count2 || !username.equals(password)) {
                System.out.println();
                System.err.println("USERNAME OR PASSWORD IS INCORRECT!");
                System.out.println();
                count1=0;
                count2=0;
                login();
            
            } else {
                System.out.println("LOGIN DONE");
            }

        } while (count1 < 0 || count2 < 0);
        if (count1 == count2) {
            if (count1 == 1) {
                System.out.println("ROLE: R001");

            } else if (count1 == 2) {
                System.out.println("ROLE: R002");
                System.err.println("NOTHING TO SHOW!");

                askYN = Validation.inputStr("DO YOU WANT TO BACK TO LOGIN MENU?(Y/N): ");
                if (askYN.toUpperCase().equals("Y")) {
                    login();
                } else if (askYN.toUpperCase().trim().equals("N")) {
                    System.exit(0);
                }

            } else if (count1 == 3) {
                System.out.println("ROLE: ADMIN");
                System.err.println("NOTHING TO SHOW!");

                askYN = Validation.inputStr("DO YOU WANT TO BACK TO LOGIN MENU?(Y/N): ");
                if (askYN.toUpperCase().equals("Y")) {
                    login();
                } else if (askYN.toUpperCase().trim().equals("N")) {
                    System.exit(0);
                }
            }
        }

    }

}
