package com.gepardec.tdd.additional;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class AdditionalMockTest {

    @Test
    public void mockListSize() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
    }

    @Test
    public void mockListSizeMultipleReturnValues() {
        List list = mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    public void mockListGet() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(0)).thenReturn("gepardec");
        assertEquals("gepardec", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    public void mockListGetWithAny() {
        List<String> list = mock(List.class);
        Mockito.when(list.get(Mockito.anyInt())).thenReturn("gepardec");
        assertEquals("gepardec", list.get(0));
        assertEquals("gepardec", list.get(1));
    }
}
