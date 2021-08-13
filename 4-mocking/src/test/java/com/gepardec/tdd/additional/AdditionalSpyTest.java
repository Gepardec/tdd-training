package com.gepardec.tdd.additional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

public class AdditionalSpyTest {

    @Test
    public void createSpyAndVerify() {
        List<String> listSpy = spy(ArrayList.class);
        listSpy.add("gepardec");
        listSpy.add("tdd");

        verify(listSpy).add("gepardec");
        verify(listSpy).add("tdd");

        assertEquals(2, listSpy.size());
        assertEquals("gepardec", listSpy.get(0));
    }

    @Test
    public void createSpyAndOverride() {
        List<String> listSpy = spy(ArrayList.class);
        listSpy.add("gepardec");
        listSpy.add("tdd");

        stub(listSpy.size()).toReturn(-1);

        assertEquals(-1, listSpy.size());
        assertEquals("gepardec", listSpy.get(0));
    }
}
