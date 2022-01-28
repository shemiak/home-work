package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveElementWithoutErrorsTest {

    @Test
    public void successConcurrentModificationException() {

        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {
            
            for (Integer integer : list) {
                list.remove(1);
            }
            
        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));

        list.removeIf(element -> element == 2);

        assertFalse(list.contains(2));
    }

    @Test
    public void successAlternativeRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));

        list = list.stream().filter(element -> element != 2).collect(Collectors.toList());

        assertFalse(list.contains(2));
    }
}
