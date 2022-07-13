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
@Table(name = "phone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
	@Id
	private Long Id;
	@Column(name = "phone_number")
	private String phoneNumber;
}
