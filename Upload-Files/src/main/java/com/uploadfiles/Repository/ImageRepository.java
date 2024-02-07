package com.uploadfiles.Repository;

import com.uploadfiles.Entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String fileName);
}
