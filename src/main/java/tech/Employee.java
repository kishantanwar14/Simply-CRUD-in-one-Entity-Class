package tech;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empTable")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private int Eid;
	
	@Column(name="Ename")
	private String Ename;
	private String Ecity;
	
		public int getEid() {
			return Eid;
		}
		public void setEid(int eid) {
			Eid = eid;
		}
		public String getEname() {
			return Ename;
		}
		public void setEname(String ename) {
			Ename = ename;
		}
		public String getEcity() {
			return Ecity;
		}
		public void setCity(String city) {
			this.Ecity = city;
		}
		@Override
		public String toString() {
			return "Employee [Eid=" + Eid + ", Ename=" + Ename + ", Ecity=" + Ecity + ", getEid()=" + getEid()
					+ ", getEname()=" + getEname() + ", getCity()=" + getEcity() + "]";
		}	
}