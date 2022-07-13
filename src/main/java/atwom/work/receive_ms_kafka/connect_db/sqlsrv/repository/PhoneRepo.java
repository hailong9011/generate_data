package atwom.work.receive_ms_kafka.connect_db.sqlsrv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atwom.work.receive_ms_kafka.connect_db.sqlsrv.entity.Phone;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Long>{
	
}
