package ru.mail.polis.homework.objects;


import java.util.Arrays;

public class MaxTask {

    /**
     * Вам дан массив и количество элементов в возвращаемом массиве
     * Вернуть нужно массив из count максимальных элементов array, упорядоченный по убыванию.
     * Если массив null или его длина меньше count, то вернуть null
     * Например ({1, 3, 10, 11, 22, 0}, 2) -> {22, 11}
     * ({1, 3, 22, 11, 22, 0}, 3) -> {22, 22, 11}
     * НЕЛЬЗЯ СОРТИРОВАТЬ массив array и его копии
     * 4 тугрика
     */
     
    public static int[] getMaxArray(int[] array, int count) {
        if (array == null || array.length < count) {
            return null;
        }
        int[] result = new int[count];
        int maxDigit = Integer.MIN_VALUE;
        int indexOfMax = -1;
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < count; ++i) {
            for (int j = 0; j < arrayCopy.length; ++j) {
                if (arrayCopy[j] > maxDigit) {
                    maxDigit = arrayCopy[j];
                    indexOfMax = j;
                }
            }
            result[i] = maxDigit;
            maxDigit = Integer.MIN_VALUE;
            for (int k = indexOfMax; k < arrayCopy.length - 1; ++k) {
                arrayCopy[k] = arrayCopy[k + 1];
            }
            arrayCopy[arrayCopy.length - 1] = Integer.MIN_VALUE;
        }

        return result;
    }
}
