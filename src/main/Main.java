package main;

import MenuMain.MenuMain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuMain menuMain = new MenuMain();
        Scanner scanner = new Scanner(System.in);
        menuMain.menu(scanner);
    }
}
