package gov.healthit.chpl.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
 * Object mapping for hibernate-handled table: product_certification_statuses.
 * Table to store counts of certified products per certification status for each product_id
 *
 * @author autogenerated / dlucas
 */
@Entity
@Table(name = "product_certification_statuses")
public class ProductCertificationStatusesEntity implements Cloneable, Serializable{
	/** Serial Version UID. */
	private static final long serialVersionUID = -1396979001199564864L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "product_id", nullable = false)
	private Long id;
	
	@Column(name = "active", nullable = false)
	private Integer active;
	
	@Column(name = "retired", nullable = false)
	private Integer retired;
	
	@Column(name = "withdrawn", nullable = false)
	private Integer withdrawn;
	
	@Column(name = "terminated", nullable = false)
	private Integer terminated;
	
	@Column(name = "suspended", nullable = false)
	private Integer suspended;
	
	public ProductCertificationStatusesEntity(){
		
	}
	
	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public ProductCertificationStatusesEntity(Long id) {
		this.id = id;
	}
	
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return ProductCertificationStatusesEntity.class;
	}
	
	/** Constructor taking a given ID.
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Long object;
	 */
	public ProductCertificationStatusesEntity(Long id, Integer active, Integer retired, Integer withdrawn, Integer terminated, Integer suspended) {
		this.id = id;
		this.active = active;
		this.retired = retired;
		this.withdrawn = withdrawn;
		this.terminated = terminated;
		this.suspended = suspended;
	}
	
	/**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
	public Long getId(){
		return this.id;
	}
	
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id){
		this.id = id;
	}
	
	/**
	 * Return the value associated with the column: active.
	 * @return A Integer object (this.active)
	 */
	public Integer getActive(){
		return this.active;
	}
	
	/**  
	 * Set the value related to the column: active.
	 * @param active - the aggregate count of active certification_statuses
	 */
	public void setActive(Integer active){
		this.active = active;
	}
	
	/**
	 * Return the value associated with the column: retired.
	 * @return A Integer object (this.retired)
	 */
	public Integer getRetired(){
		return this.retired;
	}
	
	/**  
	 * Set the value related to the column: retired.
	 * @param retired - the aggregate count of retired certification_statuses
	 */
	public void setRetired(Integer retired){
		this.retired = retired;
	}
	
	/**
	 * Return the value associated with the column: withdrawn.
	 * @return A Integer object (this.withdrawn)
	 */
	public Integer getWithdrawn(){
		return this.withdrawn;
	}
	
	/**  
	 * Set the value related to the column: withdrawn.
	 * @param withdrawn - the aggregate count of withdrawn certification_statuses
	 */
	public void setWithdrawn(Integer withdrawn){
		this.withdrawn = withdrawn;
	}
	
	/**
	 * Return the value associated with the column: terminated.
	 * @return A Integer object (this.terminated)
	 */
	public Integer getTerminated(){
		return this.terminated;
	}
	
	/**  
	 * Set the value related to the column: terminated.
	 * @param terminated - the aggregate count of terminated certification_statuses
	 */
	public void setTerminated(Integer terminated){
		this.terminated = terminated;
	}
	
	/**
	 * Return the value associated with the column: suspended.
	 * @return A Integer object (this.suspended)
	 */
	public Integer getSuspended(){
		return this.suspended;
	}
	
	/**  
	 * Set the value related to the column: suspended.
	 * @param suspended - the aggregate count of suspended certification_statuses
	 */
	public void setSuspended(Integer suspended){
		this.suspended = suspended;
	}
	
	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("active: " + this.getActive() + ", ");
		sb.append("retired: " + this.getRetired() + ", ");
		sb.append("withdrawn: " + this.getWithdrawn() + ", ");
		sb.append("terminated: " + this.getTerminated());
		return sb.toString();		
	}
}