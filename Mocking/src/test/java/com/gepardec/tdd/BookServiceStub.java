package com.gepardec.tdd;

import java.util.List;

public class BookServiceStub implements BookService {
    @Override
    public List<String> retrieveAllBookTitles(String user) {
        return List.of("Clean Code",
                "Think Java: How to think like a computer scientist",
                "Pro WPF in C# 2008",
                "Java Performance: The Definitive Guide: Getting the Most Out of Your Code",
                "Learn Python the Hard Way");
    }
}
