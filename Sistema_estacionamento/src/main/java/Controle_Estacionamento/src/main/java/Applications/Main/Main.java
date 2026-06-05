package Applications.Main;

import Applications.Menu.Menu;

public class Main {
    static void main(String[] args) {
        Menu menu= new Menu();
        //Menu sendo intanciado e usado abaixo
        System.out.println("Bem vindo ao sistema de controle de estacionamento!");
        menu.menuPrincipal();
    }
}