package com.sbrf.reboot.functionalinterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalInterfaceTest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class SomeObject {
        private String objectName;
    }

    @FunctionalInterface
    interface ObjectToJsonFunction<T> {
        String applyAsJson(T t) throws JsonProcessingException;
    }

    static class ListConverter<T> {
        public List<String> toJsonsList(@NonNull List<T> someObjects, ObjectToJsonFunction<T> objectToJsonFunction) {
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");

            return someObjects.stream()
                    .map(x -> {
                        String s = null;
                        try {
                            s = objectToJsonFunction.applyAsJson(x);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                        return s;
                    })
                    .collect(Collectors.toList());
        }
    }

    @Test
    public void successCallFunctionalInterface() {
        ListConverter<SomeObject> ListConverter = new ListConverter<>();

        ObjectToJsonFunction<SomeObject> objectToJsonFunction = someObject -> {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(someObject);
        };

        List<String> strings = ListConverter.toJsonsList(
                Arrays.asList(
                        new SomeObject("Object-1"),
                        new SomeObject("Object-2")
                ),
                objectToJsonFunction
        );

        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-1\"}"));
        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-2\"}"));
    }

}
