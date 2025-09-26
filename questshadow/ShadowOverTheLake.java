package questshadow;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Shohjahon
 * @version 1.0
 */

public class ShadowOverTheLake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Scene 1: Awakening");
        System.out.println("You wake up on the cold sand by the lakeshore.");
        System.out.println("It's foggy, night, and not a soul around.");
        System.out.println("Your phone in your pocket is almost dead (1%).");
        System.out.println("In your other pocket is a match and a scrap of paper with the inscription:");
        System.out.println("\"Don't trust the voices. Go north.\"");
        System.out.println();
        System.out.println("What do you do?");
        System.out.println("1 - Go east, where the light flickers in the fog.");
        System.out.println("2 - Go north, as the note suggests.");
        System.out.println("3 - Stay by the lake, maybe someone will come.");
        System.out.print("Enter your choice: ");

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. The fog swallows you as you hesitate...");
            return;
        }

        if (choice == 1) {
            System.out.println("\nScene 2A: Eastern Light");
            System.out.println("You follow the light and find an old power plant.");
            System.out.println("Suddenly, a spotlight comes on.");
            System.out.println("Voice: \"Halt. Identification...\"");
            System.out.println("You don't understand anything.");
            System.out.println("1 - Reply: \"I'm human, I'm lost!\"");
            System.out.println("2 - Run back into the forest.");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. You freeze, and shadows take you...");
                return;
            }

            if (choice == 1) {
                System.out.println("\nScene 3A: Attempt at Communication");
                System.out.println("You scream, but the light blinds you. A figure in a gas mask appears.");
                System.out.println("You are tranquilized. When you wake up, you are in the lab.");
                System.out.println("You have become part of the experiment.");
                System.out.println("Ending: Failure");
            } else if (choice == 2) {
                System.out.println("\nScene 3B: Escape");
                System.out.println("You run, but stumble. The spotlight goes out.");
                System.out.println("Something moves in the bushes. You vanished without a trace.");
                System.out.println("Ending: Failure");
            }

        } else if (choice == 2) {
            System.out.println("\nScene 2B: Northern Path");
            System.out.println("You follow north and find an abandoned village.");
            System.out.println("One house contains traces of a fire and a journal:");
            System.out.println("\"The lake awakens at the full moon. Don't trust the voices. Hide until dawn.\"");
            System.out.println("1 - Stay in the house until dawn.");
            System.out.println("2 - Exit and continue into the fog.");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. The fog swallows you as you hesitate...");
                return;
            }

            if (choice == 1) {
                System.out.println("\nScene 3C: Waiting");
                System.out.println("You sit by the fire. Hours pass. At dawn, survivors emerge from the fog.");
                System.out.println("They help you escape.");
                System.out.println("Ending: Victory");
            } else if (choice == 2) {
                System.out.println("\nScene 3D: Search");
                System.out.println("You wander through the fog and come to a lighthouse.");
                System.out.println("There's an old radio there. You manage to establish contact.");
                System.out.println("The next day—evacuation.");
                System.out.println("Ending: Victory");
            }

        } else if (choice == 3) {
            System.out.println("\nScene 2C: Waiting by the Lake");
            System.out.println("You remain where you are. From the fog, you hear a child's voice:");
            System.out.println("\"Help me... please...\"");
            System.out.println("1 - Follow the voice.");
            System.out.println("2 - Run away into the forest.");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. The fog swallows you as you hesitate...");
                return;
            }

            if (choice == 1) {
                System.out.println("\nScene 3E: Girl");
                System.out.println("You follow the voice and see a girl in white.");
                System.out.println("She smiles and disappears into the water.");
                System.out.println("Shadows surround you. You can't move.");
                System.out.println("Ending: Curse of the Lake");
            } else if (choice == 2) {
                System.out.println("\nScene 3F: Escape into the Forest");
                System.out.println("You run away. You stumble upon an underground hatch.");
                System.out.println("Inside—a bunker with monitors, maps, logs.");
                System.out.println("1 - Destroy the control center.");
                System.out.println("2 - Join the project.");
                System.out.print("Enter your choice: ");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. The bunker collapses around you...");
                    return;
                }

                if (choice == 1) {
                    System.out.println("\nScene 4A: Destruction");
                    System.out.println("You activate the self-destruct. The lake begins to glow.");
                    System.out.println("The darkness fades. You saved the world... but died.");
                    System.out.println("Ending: Hero");
                } else if (choice == 2) {
                    System.out.println("\nScene 4B: Joining");
                    System.out.println("You enter the project. You are given a new name.");
                    System.out.println("You become part of what once haunted you.");
                    System.out.println("Ending: Secret Participant");
                }
            }
        } else {
            System.out.println("Invalid choice. The fog swallows you as you hesitate...");
        }
    }
}
