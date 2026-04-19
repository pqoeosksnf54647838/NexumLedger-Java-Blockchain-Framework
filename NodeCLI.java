package org.cli;

import java.util.Scanner;

public class NodeCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Blockchain Node CLI Started");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;
            processCommand(input);
        }
        scanner.close();
    }

    private static void processCommand(String cmd) {
        switch (cmd) {
            case "info" -> System.out.println("Node running, height: 100");
            case "peers" -> System.out.println("Connected peers: 8");
            default -> System.out.println("Unknown command");
        }
    }
}
