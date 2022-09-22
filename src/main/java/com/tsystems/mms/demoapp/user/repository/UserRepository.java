package com.tsystems.mms.demoapp.user.repository;

import com.tsystems.mms.demoapp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
