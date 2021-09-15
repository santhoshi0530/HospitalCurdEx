package in.nit.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="specialization")
public class Specialization {
	
	@Id
	@GeneratedValue
	@Column(name="spec_id")
	private Integer id ;
	@Column(name="spec_code")
	private String code;
	@Column(name="spec_name")
	private String name;
	@Column(name="spec_note")
	private String note;
}
