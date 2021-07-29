package com.taras.tarbannerapi.repository;

import com.taras.tarbannerapi.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    @Modifying
    @Query("update Banner b set b.deleted = true where b.id = ?1")
    void deleteById(Long id);

    List<Banner> findByNameContainsAllIgnoreCase(String theName);
}
