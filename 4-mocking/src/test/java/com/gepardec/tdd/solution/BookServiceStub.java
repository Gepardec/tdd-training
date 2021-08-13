package com.gepardec.tdd.solution;

import com.gepardec.tdd.BookService;

import java.util.List;

public class BookServiceStub implements BookService {
    @Override
    public List<String> retrieveAllBookTitles(String user) {
        return List.of("Pro ASP.NET Core 3: Develop Cloud-Ready Web Applications Using MVC, Blazor, and Razor Pages",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");
    }

    @Override
    public void deleteBook(String user, String bookName) {
        // not necessary
    }
}
