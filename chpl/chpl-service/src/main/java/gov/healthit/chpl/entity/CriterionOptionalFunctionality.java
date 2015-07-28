package gov.healthit.chpl.entity;

import gov.healthit.chpl.entity.OptionalFunctionalityMet;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: criterion_optional_functionality.
 * 
 *
 * @author autogenerated
 */

@Entity
@Table(name = "criterion_optional_functionality", catalog = "openchpl", schema = "openchpl")
public class CriterionOptionalFunctionality implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -1618311524161820321L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private CertificationCriterion certificationCriterion;
	/** Field mapping. */
	private Date creationDate;
	/** Field mapping. */
	private Boolean deleted;
	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private Date lastModifiedDate;
	/** Field mapping. */
	private Long lastModifiedUser;
	/** Field mapping. */
	private String number;
	/** Field mapping. */
	private Set<OptionalFunctionalityMet> optionalFunctionalityMets = new HashSet<OptionalFunctionalityMet>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public CriterionOptionalFunctionality() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public CriterionOptionalFunctionality(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param certificationCriterion CertificationCriterion object;
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Long object;
	 */
	public CriterionOptionalFunctionality(CertificationCriterion certificationCriterion, Date creationDate, Boolean deleted, 					
			Long id, Date lastModifiedDate, Long lastModifiedUser) {

		this.certificationCriterion = certificationCriterion;
		this.creationDate = creationDate;
		this.deleted = deleted;
		this.id = id;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedUser = lastModifiedUser;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return CriterionOptionalFunctionality.class;
	}
 

	 /**
	 * Return the value associated with the column: certificationCriterion.
	 * @return A CertificationCriterion object (this.certificationCriterion)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@JoinColumn(name = "certification_criterion_id", nullable = false )
	public CertificationCriterion getCertificationCriterion() {
		return this.certificationCriterion;
		
	}
	

  
	 /**  
	 * Set the value related to the column: certificationCriterion.
	 * @param certificationCriterion the certificationCriterion value you wish to set
	 */
	public void setCertificationCriterion(final CertificationCriterion certificationCriterion) {
		this.certificationCriterion = certificationCriterion;
	}

	 /**
	 * Return the value associated with the column: creationDate.
	 * @return A Date object (this.creationDate)
	 */
	@Basic( optional = false )
	@Column( name = "creation_date", nullable = false  )
	public Date getCreationDate() {
		return this.creationDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: creationDate.
	 * @param creationDate the creationDate value you wish to set
	 */
	public void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	 /**
	 * Return the value associated with the column: deleted.
	 * @return A Boolean object (this.deleted)
	 */
	@Basic( optional = false )
	@Column( nullable = false  )
	public Boolean isDeleted() {
		return this.deleted;
		
	}
	

  
	 /**  
	 * Set the value related to the column: deleted.
	 * @param deleted the deleted value you wish to set
	 */
	public void setDeleted(final Boolean deleted) {
		this.deleted = deleted;
	}

	 /**
	 * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Basic( optional = true )
	@Column( length = 1000  )
	public String getDescription() {
		return this.description;
		
	}
	

  
	 /**  
	 * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "criterionOptionalFunctionalityCriterion_optional_functionality_idGenerator")
	@Basic( optional = false )
	@Column( name = "criterion_optional_functionality_id", nullable = false  )
	@SequenceGenerator(name = "criterionOptionalFunctionalityCriterion_optional_functionality_idGenerator", sequenceName = "openchpl.openchpl.criterion_optional_functional_criterion_optional_functional_seq", schema = "openchpl", catalog = "openchpl")
	public Long getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: lastModifiedDate.
	 * @return A Date object (this.lastModifiedDate)
	 */
	@Basic( optional = false )
	@Column( name = "last_modified_date", nullable = false  )
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastModifiedDate.
	 * @param lastModifiedDate the lastModifiedDate value you wish to set
	 */
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	 /**
	 * Return the value associated with the column: lastModifiedUser.
	 * @return A Long object (this.lastModifiedUser)
	 */
	@Basic( optional = false )
	@Column( name = "last_modified_user", nullable = false  )
	public Long getLastModifiedUser() {
		return this.lastModifiedUser;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastModifiedUser.
	 * @param lastModifiedUser the lastModifiedUser value you wish to set
	 */
	public void setLastModifiedUser(final Long lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	 /**
	 * Return the value associated with the column: number.
	 * @return A String object (this.number)
	 */
	@Basic( optional = true )
	@Column( length = 25  )
	public String getNumber() {
		return this.number;
		
	}
	

  
	 /**  
	 * Set the value related to the column: number.
	 * @param number the number value you wish to set
	 */
	public void setNumber(final String number) {
		this.number = number;
	}

	 /**
	 * Return the value associated with the column: optionalFunctionalityMet.
	 * @return A Set&lt;OptionalFunctionalityMet&gt; object (this.optionalFunctionalityMet)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "criterionOptionalFunctionality"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "criterion_optional_functionality_id", nullable = false  )
	public Set<OptionalFunctionalityMet> getOptionalFunctionalityMets() {
		return this.optionalFunctionalityMets;
		
	}
	
	/**
	 * Adds a bi-directional link of type OptionalFunctionalityMet to the optionalFunctionalityMets set.
	 * @param optionalFunctionalityMet item to add
	 */
	public void addOptionalFunctionalityMet(OptionalFunctionalityMet optionalFunctionalityMet) {
		optionalFunctionalityMet.setCriterionOptionalFunctionality(this);
		this.optionalFunctionalityMets.add(optionalFunctionalityMet);
	}

  
	 /**  
	 * Set the value related to the column: optionalFunctionalityMet.
	 * @param optionalFunctionalityMet the optionalFunctionalityMet value you wish to set
	 */
	public void setOptionalFunctionalityMets(final Set<OptionalFunctionalityMet> optionalFunctionalityMet) {
		this.optionalFunctionalityMets = optionalFunctionalityMet;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public CriterionOptionalFunctionality clone() throws CloneNotSupportedException {
		
        final CriterionOptionalFunctionality copy = (CriterionOptionalFunctionality)super.clone();

		copy.setCertificationCriterion(this.getCertificationCriterion());
		copy.setCreationDate(this.getCreationDate());
		copy.setDeleted(this.isDeleted());
		copy.setDescription(this.getDescription());
		copy.setId(this.getId());
		copy.setLastModifiedDate(this.getLastModifiedDate());
		copy.setLastModifiedUser(this.getLastModifiedUser());
		copy.setNumber(this.getNumber());
		if (this.getOptionalFunctionalityMets() != null) {
			copy.getOptionalFunctionalityMets().addAll(this.getOptionalFunctionalityMets());
		}
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("creationDate: " + this.getCreationDate() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastModifiedDate: " + this.getLastModifiedDate() + ", ");
		sb.append("lastModifiedUser: " + this.getLastModifiedUser() + ", ");
		sb.append("number: " + this.getNumber() + ", ");
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final CriterionOptionalFunctionality that; 
		try {
			that = (CriterionOptionalFunctionality) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getCertificationCriterion() == null) && (that.getCertificationCriterion() == null)) || (getCertificationCriterion() != null && getCertificationCriterion().getId().equals(that.getCertificationCriterion().getId())));	
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
		result = result && (((getNumber() == null) && (that.getNumber() == null)) || (getNumber() != null && getNumber().equals(that.getNumber())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Long newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

	
}
