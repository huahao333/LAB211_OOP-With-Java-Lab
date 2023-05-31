/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manage;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public interface I_Dealer {

    public boolean readDealerFile(String filename);

    public void add();

    public void search();

    public void remove();

    public void update();

    public void print();

    public boolean writeToFile(String filename);

}
