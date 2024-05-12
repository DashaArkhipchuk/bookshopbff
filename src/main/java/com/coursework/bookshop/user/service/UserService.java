package com.coursework.bookshop.user.service;

import com.coursework.bookshop.bff.feign.BookshopApiClient;
import com.coursework.bookshop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final BookshopApiClient bookshopApiClient;


    public User getUser(String username) {
        return bookshopApiClient.getUserByEmail(username);
    }
}
