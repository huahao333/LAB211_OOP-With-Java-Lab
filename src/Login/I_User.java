/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Login;

/**
 *
 * @author ACER
 */
public interface I_User {

    public boolean loadFromUserFile(String filenameU);

    public void login();

    public int searchU(String username);

    public int searchP(String password);

    public int searchR(String role);

   

}
