package com.test.db.testDb;


import org.springframework.data.jpa.repository.JpaRepository;

public interface YourRepository extends JpaRepository<YourEntity, Long> {
}
