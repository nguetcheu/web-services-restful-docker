package com.nkd.webservices.web_services_restful.repository;

import com.nkd.webservices.web_services_restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
