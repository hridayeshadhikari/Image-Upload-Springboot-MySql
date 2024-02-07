package com.uploadfiles.Repository;

import com.uploadfiles.Entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String name);
}
