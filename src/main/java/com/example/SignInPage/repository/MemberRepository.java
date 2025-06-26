package com.example.SignInPage.repository;

import com.example.SignInPage.dto.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member,Long> {

    @Override
    ArrayList<Member> findAll();
}
