package com.example.SignInPage.repository;

import com.example.SignInPage.dto.JoinEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JoinRepository extends CrudRepository<JoinEntity,Long> {

    @Override
    ArrayList<JoinEntity> findAll();
}
