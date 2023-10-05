package com.ism.services;

import com.ism.entities.Unite;
import com.ism.repositories.ITables;

import java.util.ArrayList;

public class UniteServiceImpl implements UniteService{
    private ITables<Unite> unRepository ;
    //private int cpt=1;
    public UniteServiceImpl(ITables<Unite> unRepository) {
        this.unRepository = unRepository;
    }

    //Injection de dépendance via le setter
    public void setUniteRepository(ITables<Unite> UniteRepository) {
        this.unRepository =unRepository;
    }

    @Override
    public int add(Unite data) {
        return unRepository.insert(data);
    }

    @Override
    public ArrayList<Unite> getAll() {
        return unRepository.findAll();
    }

    @Override
    public int update(Unite data) {
        return unRepository.update(data);
    }

    @Override
    public Unite show(int id) {
        return unRepository.findByID(id);
    }

    @Override
    public int remove(int id) {
        return unRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        return new int[0];
    }
}
