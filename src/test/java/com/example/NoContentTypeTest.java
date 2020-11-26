package com.example;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@MicronautTest
public class NoContentTypeTest {

    public static final String TARGET_URL = "http://localhost/foobar.json";
    @Inject
    HttpClient client;

    @Test
    void testWithObject() {
        try {
            FooBar fooBar = client.toBlocking().retrieve(TARGET_URL, FooBar.class);
            assertEquals("foobar", fooBar.toString());
        } catch(HttpClientResponseException e) {
            // That's not true, there is a body, though Micronaut didn't decode it!
            // The other test below proves it
            assertNotEquals("Empty body", e.getMessage());
        }
    }

    @Test
    void testWithString() {
        String fooBar = client.toBlocking().retrieve(TARGET_URL);
        assertEquals("{\n" +
                "    \"foo\": \"foo\",\n" +
                "    \"bar\": \"bar\"\n" +
                "}", fooBar);
    }
}
