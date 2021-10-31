package com.example.megacom.dao;

import com.example.megacom.models.entities.Code;
import com.example.megacom.models.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {

    int countByCodeAndSuccess(Code code, boolean success);
}