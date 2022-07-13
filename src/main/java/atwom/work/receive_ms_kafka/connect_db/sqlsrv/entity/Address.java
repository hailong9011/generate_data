package atwom.work.receive_ms_kafka.connect_db.sqlsrv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	private Long id;
	@Column(name = "address")
	private String address;

}
