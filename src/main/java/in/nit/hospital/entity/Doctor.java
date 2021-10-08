package in.nit.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id_col")
	private Long id;

	@Column(name = "doc_fn_col")
	private String firstName;

	@Column(name = "doc_ln_col")
	private String LastName;

	@Column(name = "doc_email_col")
	private String email;

	@Column(name = "doc_addr_col")
	private String address;

	@Column(name = "doc_mob_col")
	private String mobile;

	@Column(name = "doc_gen_col")
	private String gender;

	@Column(name = "doc_note_col")
	private String note;
	
	@Column(name="doc_photo_col")
	private String photoLoc;

	@ManyToOne
	@JoinColumn(name = "spec_id_fl_col")
	private Specialization specialization;
}
