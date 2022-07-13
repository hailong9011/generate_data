package atwom.work.receive_ms_kafka.connect_db.mariadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atwom.work.receive_ms_kafka.connect_db.mariadb.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
