package com.example.demo.domain.repository;


import com.example.demo.domain.entity.BoardNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<BoardNotification,Long> {

    @Query("SELECT b FROM BoardNotification b WHERE writenickname = :writenickname AND replynickname != :writenickname ORDER BY nid DESC")
    List<BoardNotification> findAllByNickname(@Param("writenickname") String writenickname);

    @Query("SELECT count(nid) FROM BoardNotification b WHERE writenickname = :writenickname AND replynickname != :writenickname")
    int countByMyNickname(@Param("writenickname") String writenickname);


}