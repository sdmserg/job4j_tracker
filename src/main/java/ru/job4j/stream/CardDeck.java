package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

public class CardDeck {

    public static void main(String[] args) {
        List<Card> cards = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .collect(Collectors.toList());
    }
}
