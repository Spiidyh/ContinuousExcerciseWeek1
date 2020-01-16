package Main;
import UI.UI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        UI ui = new UI(reader);
        ui.launchTextUI();
    }
}
