package com.example.app_todolist.model;

public class Task {
    private String title;
    private String descricao;

    public Task(String title, String descricao) {
        this.title = title;
        this.descricao = descricao;
    }

    public String getTitle() { return title; }
    public String getDescricao() { return descricao;}
}
