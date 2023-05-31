package Manage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

public class DealerManage extends ArrayList<Dealer> implements I_Dealer {

    boolean idDuplicated = false;

    private boolean isIdDuplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    @Override
    public void add() {
        String newId, newName, newAddress, newPhone, newStatus;

        do {
            newId = Validation.inputPatternForId("INPUT ID TO ADD: ");
            idDuplicated = isIdDuplicated(newId);
            if (idDuplicated) {
                System.out.println("ID DUPLICATED");
            }
        } while (idDuplicated == true);
        newName = Validation.inputNonBankStr("ENTER NAME: ");
        newAddress = Validation.inputNonBankStr("ENTER ADDRESS: ");

        do {
            newPhone = Validation.inputNonBankStr("ENTER PHONE");
            idDuplicated = isIdDuplicated(newPhone);
            if (idDuplicated) {
                System.out.println("PHONE DUPLICATED");
            }
        } while (idDuplicated == true);

        newStatus = Validation.inputNonBankStr("INPUT STATUS(ENABLED OR DISABLED): ").toUpperCase();

        System.out.println("ADD DONE!");
        Dealer de = new Dealer(newId, newName, newAddress, newPhone, newStatus);
        this.add(de);
    }

    public Dealer search(String id) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId().equals(id)) {
                return this.get(i);
            }
        }
        return null;

    }

    @Override
    public void search() {
        if (this.isEmpty()) {
            System.err.println("EMPTY LIST!");
        } else {
            String sId = Validation.inputStr("INPUT ID FOR SEARCH: ");
            Dealer st = this.search(sId);
            if (st == null) {
                System.out.println("DEALER: " + sId + " DOESN'T EXIST!");
            } else {
                System.out.println("FOUND: " + st);
            }
        }

    }

    @Override
    public void remove() {

        if (this.isEmpty()) {
            System.out.println("EMPTY LIST!");
        } else {
            String rId = Validation.inputStr("INPUT ID FOR REMOVING:");
            Dealer st = this.search(rId);
            if (st == null) {
                System.out.println("ID " + rId + " DOESN'T EXIST!");
            } else {
                this.remove(st);
                System.out.println("ID " + rId + " HAS BEEN REMOVED");
            }
        }

    }

    @Override
    public void update() {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST!");

        } else {
            String uId = Validation.inputStr("INPUT DEALER'S ID: ");
            Dealer st = this.search(uId);
            if (st == null) {
                System.out.println("DEALER " + uId + " DOESN'T EXIST");
            } else {
                String oldId = st.getId();
                String msg;
                do {
                    msg = "OLD ID " + oldId + ", NEW ID: ";

                    String newUid = Validation.inputPatternForId(msg);
                    idDuplicated = isIdDuplicated(newUid);
                    if (idDuplicated) {
                        System.out.println("ID DUPLICATED!");
                    }
                    st.setId(newUid);
                } while (idDuplicated == true);

                String oldName = st.getName();
                msg = "OLD NAME " + oldName + ", NEW NAME: ";
                String newUName = Validation.inputNonBankStr(msg);
                st.setName(newUName);
                String oldUAddress = st.getAddress();
                msg = "OLD ADDRESS " + oldUAddress + ", NEW ADDRESS: ";
                String newUAddress = Validation.inputNonBankStr(msg);
                st.setAddress(newUAddress);
                String oldUPhone = st.getPhone();
                do {
                    msg = "OLD PHONE " + oldUPhone + ", NEW PHONE: ";
                    String newUPhone = Validation.inputStr(msg);
                    idDuplicated = isIdDuplicated(newUPhone);
                    if (idDuplicated) {
                        System.out.println("PHONE DUPLICATED");
                    }
                    st.setPhone(newUPhone);
                } while (idDuplicated == true);

                String oldUStatus = st.getStatus();
                msg = "OLD STATUS " + oldUStatus + ", NEW STATUS: ";
                String newUStatus = Validation.inputNonBankStr(msg);
                st.setStatus(newUStatus);
            }

        }
    }

    @Override
    public void print() {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST");
        } else {
            System.out.println("-----DEALER LIST-----");
        }
        for (int i = 0; i < this.size(); i++) {

            System.out.println(this.get(i));
        }
    }

    public boolean writeToFile(String filename) {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Dealer x : this) {
                System.out.println("\n");
                pw.println(x.getId() + " | " + x.getName() + " | " + x.getAddress() + " | " + x.getPhone() + " | " + x.getStatus());

            }
            pw.close();
            System.out.println("SAVE TO FILE DONE!");
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public boolean readDealerFile(String filename) {
        String id, name, address, phone, status;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String[] arr;
            String test = br.readLine();
            while (test != null) {

                arr = test.split("\\|");
                id = arr[0].trim();
                name = arr[1].trim();
                address = arr[2].trim();
                phone = arr[3].trim();
                status = arr[4].trim();
                this.add(new Dealer(id, name, address, phone, status));
                test = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println("IO");
        }
        return false;
    }

}
