package main.app;

import main.UI.UI;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        UI ui = new UI(reader);
        ui.launchTextUI();
//        List<String> lista = new ArrayList<>();
//        lista.add("ASDasdas");
//        lista.add("dasdasd");
//        Topic dsa = new Topic("Java collections", "Information about classes, collections arraylists etc.", "No additional sources", false);
//        Task t = new Task( dsa, "asd", "asd", lista , LocalDate.of(1922, 11, 11), false, Task.Priority.MEDIUM);
//        System.out.println(t.getPriority());
//        t.setPriority(Task.Priority.LOW);
//        System.out.println(t.getPriority());
    }
}
