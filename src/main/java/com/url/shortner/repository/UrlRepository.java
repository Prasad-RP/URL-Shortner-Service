package com.url.shortner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.url.shortner.entity.UrlMaster;

@Repository
public interface UrlRepository extends JpaRepository<UrlMaster, Long>{

	Optional<UrlMaster> findByShortenedUrl(String url);
}
