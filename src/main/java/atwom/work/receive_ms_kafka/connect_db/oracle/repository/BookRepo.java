package atwom.work.receive_ms_kafka.connect_db.oracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atwom.work.receive_ms_kafka.connect_db.oracle.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

}
