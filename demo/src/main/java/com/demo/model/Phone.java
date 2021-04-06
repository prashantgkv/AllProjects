package com.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="inst_phone")
public class Phone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String phone;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contact_id")
	private ContactUs contact;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ContactUs getContact() {
		return contact;
	}

	public void setContact(ContactUs contact) {
		this.contact = contact;
	}
//	@Override
//	public boolean equals(Object obj) {
//			if (this == obj)
//			return true;
//			
//			if (obj==null)
//			         return false;
//
//			if (getClass() != obj.getClass())
//			return false;
//			
//		 Phone other = (Phone)  obj;
//		 
//			if (phone==null) {
//			if (other.phone!=null)
//			return false;
//			}else if (!phone.equals(other.phone)) {
//			return false;
//			}
//			return true;
//	}
		//return super.equals(obj);
	}
	




//@Entity
//public class Phone {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String phoneNo;
//    @ManyToOne(targetEntity = ContactUs.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "contactId_fk",referencedColumnName = "contactId")
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        
//        if (obj==null)
//            return false;
//        
//        if (getClass() != obj.getClass())
//            return false;
//        
//        Phone other = (Phone)  obj;
//        
//        if (phoneNo==null) {
//            if (other.phoneNo!=null)
//                return false;
//        }else if (!phoneNo.equals(other.phoneNo)) {
//            return false;
//        }
//        return true;
//    }
//    
