package main;

import GUI.MiImagen;
import GUI.PrincipalGUI;
import MenuMain.MenuMain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuMain menuMain = new MenuMain();
        Scanner scanner = new Scanner(System.in);
        //menuMain.menu(scanner);
        new PrincipalGUI(new MiImagen(26,0));
    }
}
