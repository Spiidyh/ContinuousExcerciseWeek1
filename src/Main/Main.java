package Main;
import UI.UI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        UI ui = new UI(reader);
        ui.launchTextUI();
    }
}
