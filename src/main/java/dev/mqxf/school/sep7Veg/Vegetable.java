package dev.mqxf.school.sep7Veg;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Vegetable {

    List<String> vegetables = Arrays.stream(new String[]{"carrot", "brocoli", "tomato", "cucumber", "pepper", "potato", "lettuce"}).toList();

    @SneakyThrows
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your favourite vegetable?");
        String veg = scanner.nextLine();
        if (veg == null || veg.isBlank() || veg.isEmpty() || veg.equals("")) throw new IllegalArgumentException("Vegetable cannot be null!");
        if (!vegetables.contains(veg)) {
            System.out.println("The computer doesnt like " + veg + "s. Sorry!");
            return;
        }
        System.out.println("How many " + veg + "s do you think you can eat?");
        int amount = Integer.parseInt(scanner.nextLine());
        if (amount < 0) throw new IndexOutOfBoundsException("Cannot be smaller than 0");
        if (amount > 20) throw new FatPigException("You fat pig you eat too much.");
        System.out.println("So you think you can eat " + amount + " " + pluralise(veg, amount) + "?");
        int computer = new Random().nextInt(20);
        System.out.println("The computer can eat " + computer + " " + pluralise(veg, computer) + ".");
        if (amount > computer) {
            System.out.println("Wow! You can eat more than the computer!");
        }
        else if (amount < computer) {
            System.out.println("The computer can eat more than you...");
        }
        else {
            System.out.println("You and the computer can eat the same amount of carrots.");
        }

    }

    public String pluralise(String s, int number) {
        return number > 1 ? s + "s" : s;
    }

}
