package atwom.work.receive_ms_kafka.connect_db.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	private Long Id;
	@Column(name = "title")
	private String title;
}
