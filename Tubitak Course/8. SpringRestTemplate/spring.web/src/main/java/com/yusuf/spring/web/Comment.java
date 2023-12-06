package com.yusuf.spring.web;

public record Comment(Long postID, Long id, String name, String email, String body) {
}
