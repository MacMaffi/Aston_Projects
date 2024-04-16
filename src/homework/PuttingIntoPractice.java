package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//1.Найти все транзакции за 2011 год и отсортировать их по сумме
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() ==2011)
                .sorted((x,y) -> Integer.valueOf(x.getValue()).compareTo(Integer.valueOf(y.getValue())))
                .collect(Collectors.toList());
        System.out.println(transactions2011);

//2.Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> city = transactions.stream()
                 .map(transaction -> transaction.getTrader().getCity())
                 .distinct().collect(Collectors.toList());
        System.out.println(city);

//3.Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> traders1 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct().filter(Trader -> Trader.getCity().equals("Cambridge"))
                .sorted((x,y)->x.getName().compareTo(y.getName()))
                .collect(Collectors.toList());
        System.out.println(traders1);

//4.Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        List<String> traders2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct().sorted((x,y)-> x.compareTo(y)).collect(Collectors.toList());
        System.out.println(traders2);

//5.Выяснить, существует ли хоть один трейдер из Милана
        boolean milan = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch(x -> x.equals("Milan"));
        System.out.println("Есть ли трейдер из Милана " + milan);

//6.Вывести суммы всех транзакций трейдеров из Кембриджа
        int sum = transactions.stream().filter(transaction ->
                transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(x -> x.getValue()).sum();
        System.out.println(sum);

//7.Какова максимальная сумма среди всех транзакций?
        int max = transactions.stream()
                .mapToInt(x -> x.getValue())
                .max().getAsInt();
        System.out.println(max);

//8.Найти транзакцию с минимальной суммой.
        int min = transactions.stream()
                .mapToInt(x -> x.getValue())
                .min().getAsInt();
        System.out.println(min);
    }
}
