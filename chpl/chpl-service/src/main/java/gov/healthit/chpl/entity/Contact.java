package gov.healthit.chpl.entity;

import gov.healthit.chpl.auth.user.UserEntity;
import gov.healthit.chpl.entity.AcbContactMap;
import gov.healthit.chpl.entity.AtlContactMap;
import gov.healthit.chpl.entity.VendorContactMap;
import gov.healthit.chpl.entity.UserContactMap;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: contact.
 * 
 *
 * @author autogenerated
 */

@Entity
@Table(name = "contact", catalog = "openchpl", schema = "openchpl")
public class Contact implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -4922450713586410718L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	

	/** Field mapping. */
	private Set<AcbContactMap> acbContactMaps = new HashSet<AcbContactMap>();

	/** Field mapping. */
	private Set<AtlContactMap> atlContactMaps = new HashSet<AtlContactMap>();

	/** Field mapping. */
	private Date creationDate;
	/** Field mapping. */
	private Boolean deleted;
	/** Field mapping. */
	private String email;
	/** Field mapping. */
	private String firstName;
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private Date lastModifiedDate;
	/** Field mapping. */
	private Long lastModifiedUser;
	/** Field mapping. */
	private String lastName;
	/** Field mapping. */
	private String phoneNumber;
	/** Field mapping. */
	private Date signatureDate;
	/** Field mapping. */
	private String title;
	/** Field mapping. */
	private Set<UserEntity> users = new HashSet<UserEntity>();

	/** Field mapping. */
	private Set<UserContactMap> userContactMaps = new HashSet<UserContactMap>();

	/** Field mapping. */
	private Set<VendorContactMap> vendorContactMaps = new HashSet<VendorContactMap>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Contact() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Contact(Long id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param creationDate Date object;
	 * @param deleted Boolean object;
	 * @param email String object;
	 * @param firstName String object;
	 * @param id Long object;
	 * @param lastModifiedDate Date object;
	 * @param lastModifiedUser Long object;
	 * @param lastName String object;
	 * @param phoneNumber String object;
	 */
	public Contact(Date creationDate, Boolean deleted, String email, 					
			String firstName, Long id, Date lastModifiedDate, 					
			Long lastModifiedUser, String lastName, String phoneNumber) {

		this.creationDate = creationDate;
		this.deleted = deleted;
		this.email = email;
		this.firstName = firstName;
		this.id = id;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedUser = lastModifiedUser;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Contact.class;
	}
 

	 /**
	 * Return the value associated with the column: acbContactMap.
	 * @return A Set&lt;AcbContactMap&gt; object (this.acbContactMap)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "id.contact"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "contact_id", nullable = false  )
	public Set<AcbContactMap> getAcbContactMaps() {
		return this.acbContactMaps;
		
	}
	
	/**
	 * Adds a bi-directional link of type AcbContactMap to the acbContactMaps set.
	 * @param acbContactMap item to add
	 */
	public void addAcbContactMap(AcbContactMap acbContactMap) {
		acbContactMap.getId().setContact(this);
		this.acbContactMaps.add(acbContactMap);
	}

  
	 /**  
	 * Set the value related to the column: acbContactMap.
	 * @param acbContactMap the acbContactMap value you wish to set
	 */
	public void setAcbContactMaps(final Set<AcbContactMap> acbContactMap) {
		this.acbContactMaps = acbContactMap;
	}

	 /**
	 * Return the value associated with the column: atlContactMap.
	 * @return A Set&lt;AtlContactMap&gt; object (this.atlContactMap)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "id.contact"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "contact_id", nullable = false  )
	public Set<AtlContactMap> getAtlContactMaps() {
		return this.atlContactMaps;
		
	}
	
	/**
	 * Adds a bi-directional link of type AtlContactMap to the atlContactMaps set.
	 * @param atlContactMap item to add
	 */
	public void addAtlContactMap(AtlContactMap atlContactMap) {
		atlContactMap.getId().setContact(this);
		this.atlContactMaps.add(atlContactMap);
	}

  
	 /**  
	 * Set the value related to the column: atlContactMap.
	 * @param atlContactMap the atlContactMap value you wish to set
	 */
	public void setAtlContactMaps(final Set<AtlContactMap> atlContactMap) {
		this.atlContactMaps = atlContactMap;
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
	 * Return the value associated with the column: email.
	 * @return A String object (this.email)
	 */
	@Basic( optional = false )
	@Column( nullable = false, length = 250  )
	public String getEmail() {
		return this.email;
		
	}
	

  
	 /**  
	 * Set the value related to the column: email.
	 * @param email the email value you wish to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	 /**
	 * Return the value associated with the column: firstName.
	 * @return A String object (this.firstName)
	 */
	@Basic( optional = false )
	@Column( name = "first_name", nullable = false, length = 250  )
	public String getFirstName() {
		return this.firstName;
		
	}
	

  
	 /**  
	 * Set the value related to the column: firstName.
	 * @param firstName the firstName value you wish to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactContact_idGenerator")
	@Basic( optional = false )
	@Column( name = "contact_id", nullable = false  )
	@SequenceGenerator(name = "contactContact_idGenerator", sequenceName = "openchpl.openchpl.contact_contact_id_seq", schema = "openchpl", catalog = "openchpl")
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
	 * Return the value associated with the column: lastName.
	 * @return A String object (this.lastName)
	 */
	@Basic( optional = false )
	@Column( name = "last_name", nullable = false, length = 250  )
	public String getLastName() {
		return this.lastName;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastName.
	 * @param lastName the lastName value you wish to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	 /**
	 * Return the value associated with the column: phoneNumber.
	 * @return A String object (this.phoneNumber)
	 */
	@Basic( optional = false )
	@Column( name = "phone_number", nullable = false, length = 50  )
	public String getPhoneNumber() {
		return this.phoneNumber;
		
	}
	

  
	 /**  
	 * Set the value related to the column: phoneNumber.
	 * @param phoneNumber the phoneNumber value you wish to set
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	 /**
	 * Return the value associated with the column: signatureDate.
	 * @return A Date object (this.signatureDate)
	 */
	@Basic( optional = true )
	@Column( name = "signature_date"  )
	public Date getSignatureDate() {
		return this.signatureDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: signatureDate.
	 * @param signatureDate the signatureDate value you wish to set
	 */
	public void setSignatureDate(final Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	 /**
	 * Return the value associated with the column: title.
	 * @return A String object (this.title)
	 */
	@Basic( optional = true )
	@Column( length = 250  )
	public String getTitle() {
		return this.title;
		
	}
	

  
	 /**  
	 * Set the value related to the column: title.
	 * @param title the title value you wish to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	 /**
	 * Return the value associated with the column: user.
	 * @return A Set&lt;User&gt; object (this.user)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "contact"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "contact_id", nullable = false  )
	public Set<User> getUsers() {
		return this.users;
		
	}
	
	/**
	 * Adds a bi-directional link of type User to the users set.
	 * @param user item to add
	 */
	public void addUser(UserEntity user) {
		//user.setContact(this);
		this.users.add(user);
	}

  
	 /**  
	 * Set the value related to the column: user.
	 * @param user the user value you wish to set
	 */
	public void setUsers(final Set<UserEntity> user) {
		this.users = user;
	}

	 /**
	 * Return the value associated with the column: userContactMap.
	 * @return A Set&lt;UserContactMap&gt; object (this.userContactMap)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "contact"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "contact_id", nullable = false  )
	public Set<UserContactMap> getUserContactMaps() {
		return this.userContactMaps;
		
	}
	
	/**
	 * Adds a bi-directional link of type UserContactMap to the userContactMaps set.
	 * @param userContactMap item to add
	 */
	public void addUserContactMap(UserContactMap userContactMap) {
		userContactMap.setContact(this);
		this.userContactMaps.add(userContactMap);
	}

  
	 /**  
	 * Set the value related to the column: userContactMap.
	 * @param userContactMap the userContactMap value you wish to set
	 */
	public void setUserContactMaps(final Set<UserContactMap> userContactMap) {
		this.userContactMaps = userContactMap;
	}

	 /**
	 * Return the value associated with the column: vendorContactMap.
	 * @return A Set&lt;VendorContactMap&gt; object (this.vendorContactMap)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "id.contact"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( name = "contact_id", nullable = false  )
	public Set<VendorContactMap> getVendorContactMaps() {
		return this.vendorContactMaps;
		
	}
	
	/**
	 * Adds a bi-directional link of type VendorContactMap to the vendorContactMaps set.
	 * @param vendorContactMap item to add
	 */
	public void addVendorContactMap(VendorContactMap vendorContactMap) {
		vendorContactMap.getId().setContact(this);
		this.vendorContactMaps.add(vendorContactMap);
	}

  
	 /**  
	 * Set the value related to the column: vendorContactMap.
	 * @param vendorContactMap the vendorContactMap value you wish to set
	 */
	public void setVendorContactMaps(final Set<VendorContactMap> vendorContactMap) {
		this.vendorContactMaps = vendorContactMap;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Contact clone() throws CloneNotSupportedException {
		
        final Contact copy = (Contact)super.clone();

		if (this.getAcbContactMaps() != null) {
			copy.getAcbContactMaps().addAll(this.getAcbContactMaps());
		}
		if (this.getAtlContactMaps() != null) {
			copy.getAtlContactMaps().addAll(this.getAtlContactMaps());
		}
		copy.setCreationDate(this.getCreationDate());
		copy.setDeleted(this.isDeleted());
		copy.setEmail(this.getEmail());
		copy.setFirstName(this.getFirstName());
		copy.setId(this.getId());
		copy.setLastModifiedDate(this.getLastModifiedDate());
		copy.setLastModifiedUser(this.getLastModifiedUser());
		copy.setLastName(this.getLastName());
		copy.setPhoneNumber(this.getPhoneNumber());
		copy.setSignatureDate(this.getSignatureDate());
		copy.setTitle(this.getTitle());
		if (this.getUsers() != null) {
			copy.getUsers().addAll(this.getUsers());
		}
		if (this.getUserContactMaps() != null) {
			copy.getUserContactMaps().addAll(this.getUserContactMaps());
		}
		if (this.getVendorContactMaps() != null) {
			copy.getVendorContactMaps().addAll(this.getVendorContactMaps());
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
		sb.append("email: " + this.getEmail() + ", ");
		sb.append("firstName: " + this.getFirstName() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastModifiedDate: " + this.getLastModifiedDate() + ", ");
		sb.append("lastModifiedUser: " + this.getLastModifiedUser() + ", ");
		sb.append("lastName: " + this.getLastName() + ", ");
		sb.append("phoneNumber: " + this.getPhoneNumber() + ", ");
		sb.append("signatureDate: " + this.getSignatureDate() + ", ");
		sb.append("title: " + this.getTitle() + ", ");
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
		
		final Contact that; 
		try {
			that = (Contact) proxyThat;
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
		result = result && (((getCreationDate() == null) && (that.getCreationDate() == null)) || (getCreationDate() != null && getCreationDate().equals(that.getCreationDate())));
		result = result && (((isDeleted() == null) && (that.isDeleted() == null)) || (isDeleted() != null && isDeleted().equals(that.isDeleted())));
		result = result && (((getEmail() == null) && (that.getEmail() == null)) || (getEmail() != null && getEmail().equals(that.getEmail())));
		result = result && (((getFirstName() == null) && (that.getFirstName() == null)) || (getFirstName() != null && getFirstName().equals(that.getFirstName())));
		result = result && (((getLastModifiedDate() == null) && (that.getLastModifiedDate() == null)) || (getLastModifiedDate() != null && getLastModifiedDate().equals(that.getLastModifiedDate())));
		result = result && (((getLastModifiedUser() == null) && (that.getLastModifiedUser() == null)) || (getLastModifiedUser() != null && getLastModifiedUser().equals(that.getLastModifiedUser())));
		result = result && (((getLastName() == null) && (that.getLastName() == null)) || (getLastName() != null && getLastName().equals(that.getLastName())));
		result = result && (((getPhoneNumber() == null) && (that.getPhoneNumber() == null)) || (getPhoneNumber() != null && getPhoneNumber().equals(that.getPhoneNumber())));
		result = result && (((getSignatureDate() == null) && (that.getSignatureDate() == null)) || (getSignatureDate() != null && getSignatureDate().equals(that.getSignatureDate())));
		result = result && (((getTitle() == null) && (that.getTitle() == null)) || (getTitle() != null && getTitle().equals(that.getTitle())));
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
