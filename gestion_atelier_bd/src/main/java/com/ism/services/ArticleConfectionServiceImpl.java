package com.ism.services;

import com.ism.entities.ArticleConfection;
import com.ism.repositories.ITables;

import java.util.ArrayList;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {
    private ITables<ArticleConfection> articleConfectionRepository;
    //Injection de dépendance via le constructeur
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
    }
    //Injection de dépendance via le setter
    public void setArticleConfectionRepository(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
    }

    @Override
    public int add(ArticleConfection data) {
        return articleConfectionRepository.insert(data);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleConfectionRepository.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        return articleConfectionRepository.update(data);
    }

    @Override
    public ArticleConfection show(int id) {
        return null;
    }

    @Override
    public int remove(int id) {
        return 0;
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }
}
