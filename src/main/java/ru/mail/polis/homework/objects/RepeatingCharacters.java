package ru.mail.polis.homework.objects;


import java.util.Objects;

/**
 * Нужно найти символ, который встречается подряд в строке чаще всего, и указать количество повторений.
 * Если более одного символа с максимальным значением, то нужно вернуть тот символ,
 * который первый встречается в строчке
 * Если строка пустая или null, то вернуть null
 * Пример abbasbdlbdbfklsssbb -> (s, 3)
 * 4 тугрика
 */
public class RepeatingCharacters {

    public static Pair<Character, Integer> getMaxRepeatingCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Pair<Character, Integer> maxPair = new Pair<>(str.charAt(0), 1);
        char currentChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) == currentChar) {
                ++count;
                continue;
            }
            if (count > maxPair.second) {
                maxPair = new Pair<>(currentChar, count);
            }
            if ((str.length() - i) < maxPair.second) {
                break;
            }
            currentChar = str.charAt(i);
            count = 1;

        }
        if (count > maxPair.second) {
            return new Pair<>(currentChar, count);
        }
        return maxPair;
    }

    public static class Pair<T, V> {
        private final T first;
        private final V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

    }
}
