package com.sbs.sbsgroup7.DataSource;

import com.sbs.sbsgroup7.model.Request;
import com.sbs.sbsgroup7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, String> {

}