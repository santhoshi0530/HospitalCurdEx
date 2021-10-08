package in.nit.hospital.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient_tab")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_id")
	private Long id;
	
	@Column(name="pat_first_name_col")
	private String firstName;
	
	@Column(name="pat_last_name_col")
	private String lastName;
	
	@Column(name="pat_gen_col")
	private String gender;
	
	@Column(name="pat_mob_col")
	private String mobile;
	
	@Column(name="pat_email_col")
	private String email;
	
	
	@DateTimeFormat(iso= ISO.DATE)
	@Temporal(TemporalType.DATE)
	@Column(name="pat_dob_col")
	private Date dob;
	
	@Column(name="pat_marital_status_col")
	private String maritalStatus;
	
	@Column(name="pat_present_addr_col")
	private String presentAddrs;
	
	@Column(name="pat_comm_addr_col")
	private String communicationAddrs;
	
	
	@ElementCollection
	@CollectionTable(name="pat_med_his_tab",
					joinColumns = @JoinColumn(name="pat_med_his_id_fk_col"))
	@Column(name="pat_med_his_col")
	private Set<String> mediHistory;
	
	@Column(name="pat_med_his_other_col")
	private String ifOther;
	
	@Column(name="pat_note_col")
	private String note; 
	
}
