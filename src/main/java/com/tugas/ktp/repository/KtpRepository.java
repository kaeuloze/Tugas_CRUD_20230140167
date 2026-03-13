package com.tugas.ktp.repository;

import com.tugas.ktp.model.KtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KtpRepository extends JpaRepository<KtpEntity, Integer> {
    // Tambahan method untuk validasi nomor KTP unik
    Optional<KtpEntity> findByNomorKtp(String nomorKtp);
}