package com.example.app_todolist.model;

import androidx.annotation.Nullable;

public class Task {
    private String title;
    private String descricao;

    public Task(String title,@Nullable String descricao) {
        this.title = title;
        this.descricao = descricao;
    }

    public String getTitle() { return title; }
    public String getDescricao() { return descricao;}
}
