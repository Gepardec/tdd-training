package com.gepardec.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookbBusinessImplMockInjectionTest {

    @Mock
    BookService bookService;

    @InjectMocks
    BookBusinessImpl bookBusiness;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void usingMockito() {
        List<String> allBookTitles = List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

        assertEquals(2, bookBusiness.retrieveAllJavaBookTitles("gepard").size());
    }

    @Test
    public void usingMockito_WithBDD() {
        List<String> allBookTitles = List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        //given
        given(bookService.retrieveAllBookTitles("gepard")).willReturn(allBookTitles);

        //when
        List<String> bookTitles = bookBusiness.retrieveAllJavaBookTitles("gepard");

        //then
        assertEquals(2, bookTitles.size());
    }

    @Test
    public void delete_withVerify() {

        List<String> allBookTitles = List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");

        when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

        bookBusiness.deleteAllNoneJavaBooks("gepard");

        verify(bookService).deleteBook("gepard", "Clean Code");

        verify(bookService, Mockito.never()).deleteBook("gepard", "Think Java: How to think like a computer scientist");

        verify(bookService, Mockito.times(1)).deleteBook("gepard", "Pro WPF in C# 2008");

        // FIXME GAJ: atLeastOnce, atLeast ?!?!
    }

    @Test
    public void captureArgument() {
        List<String> allBookTitles = List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code");

        Mockito.when(bookService.retrieveAllBookTitles("gepard")).thenReturn(allBookTitles);

        bookBusiness.deleteAllNoneJavaBooks("gepard");
        Mockito.verify(bookService).deleteBook(eq("gepard"), argumentCaptor.capture());

        assertEquals("Clean Code", argumentCaptor.getValue());
    }
}
