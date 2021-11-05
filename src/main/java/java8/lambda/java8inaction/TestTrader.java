/* 
User: Urmi
Date: 11/5/2021 
Time: 6:35 PM
*/

package java8.lambda.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class TestTrader {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //QUESTIONS

        /*Find all transactions in 2011 and sort by value (small to high)*/
        List<Transaction> t1 = transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

        //####################################################################################

        /* Fina all the unique cities where the traders work*/
        List<String> cities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);

        //OR
        List<String> cities1 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities1);

        //using SET
        Set<String> cities2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(cities2);

        //####################################################################################

        /*Find all traders from Cambridge and sort them by name*/
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        //####################################################################################

        /*Return a string of all traders’ names sorted alphabetically*/
        List<String> names = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted() //using sorted() method on Stream of String, no need to pass comparator
                .collect(Collectors.toList());

        //using StringBuilder
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());

        System.out.println(names);
        System.out.println(traderStr);

        //####################################################################################

        /*Are any traders based in Milan?*/
        boolean anyTrader = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> t.getCity().equals("Milan"));

        System.out.println(anyTrader);

        //OR
        boolean anyTrader1 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(anyTrader1);

        /*Print all transactions’ values from the traders living in
        Cambridge*/
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //####################################################################################

        /*What’s the highest value of all the transactions?*/
        int highest = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max).get();

        //####################################################################################

        /*Find the transaction with the smallest value*/
        //FOLLOW THIS
        Transaction smallest = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).get();

        //USING LAMBDA - DO NOT FOLLOW
        Transaction smallest1 = transactions.stream()
                .reduce((t11, t21) -> t11.getValue() < t21.getValue() ? t11 : t21)
                .get();

    }



}
