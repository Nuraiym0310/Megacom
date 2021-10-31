package com.example.megacom.dao;

import com.example.megacom.models.entities.Code;
import com.example.megacom.models.entities.User;
import com.example.megacom.models.enums.CodeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepo extends JpaRepository<Code, Long > {

    Code findByUserAndCodeStatus(User user, CodeStatus status);
}