package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder phrase = new StringBuilder();
        int count = evenElements.size();
        for (int index = 0; index < count; index++) {
            Character character = evenElements.pollFirst();
            if (index % 2 == 0) {
                phrase.append(character);
            }
        }
        return phrase.toString();
    }

    private String getDescendingElements() {
        StringBuilder phrase = new StringBuilder();
        int count = descendingElements.size();
        for (int index = 0; index < count; index++) {
            phrase.append(descendingElements.pollLast());
        }
        return phrase.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
