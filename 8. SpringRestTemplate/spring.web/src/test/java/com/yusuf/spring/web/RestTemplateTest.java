package com.yusuf.spring.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

public class RestTemplateTest {
    private final static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    RestTemplate restTemplate = new RestTemplate();

    @Test
    void getPosts(){

        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();
        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build(); // get isteği yollarkenki bilgilerimiz
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);// get isteğinden dönen cevabın bilgileri
        System.out.println(Arrays.stream(response.getBody()).toList());
    }
    @Test
    void getSinglePost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","2")
                .build()
                .toUri();
        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build(); // get isteği yollarkenki bilgilerimiz
        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);// get isteğinden dönen cevabın bilgileri
        System.out.println(response.getBody());
    }
    @Test
    void addPost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();
        RequestEntity<Post> request = RequestEntity
                .post(uri)
                .body(new Post(7L,null,"Yusuf","bodytest"));
        ResponseEntity<Post> responseLaterPost = restTemplate.exchange(request, Post.class);//Apiye gore degisir api eklendi diye bir mesajda donebilir donmeyedebilir
        System.out.println(responseLaterPost.getBody());
    }
    @Test
    void getPostById(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId","2")
                .build()
                .toUri();
        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build(); // get isteği yollarkenki bilgilerimiz
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);// get isteğinden dönen cevabın bilgileri
        System.out.println(Arrays.stream(response.getBody()).toList());

    }
    @Test
    void updateComment(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments","5")
                .build()
                .toUri();
        RequestEntity<Comment> requestEntity = RequestEntity
                .put(uri)
                .body(new Comment(9L,5L,"Yusuf","yusuf@gmail.com","hello")); // put isteği yollarkenki bilgilerimiz
        ResponseEntity<Comment> responseLaterPut = restTemplate.exchange(requestEntity, Comment.class);
        System.out.println(responseLaterPut.getBody());

    }
    @Test
    void deletePost(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","2")
                .build()
                .toUri();
        RequestEntity<Void> requestEntity = RequestEntity.delete(uri).build();
        ResponseEntity<Void> responseLaterDelete = restTemplate.exchange(requestEntity, Void.class);
        System.out.println(responseLaterDelete.getStatusCode());//İslem basarili ise 200 ok döner

    }
}
