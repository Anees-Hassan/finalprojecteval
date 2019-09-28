package com.ust.dao;

import java.util.List;

import com.ust.model.VendorBean;

public interface VendorIntDao {

	// Listing the Vendors details
	public abstract List<VendorBean> getVendorList();

	// Inserting Vendor basic details into Vendor Table with default isActive as
	// 1
	public abstract int insertVendor(VendorBean vBean);

	// Insert remaining details in contact table by getting the VendorId from
	// Vendor table
	public abstract int insertContact(VendorBean vBean);

	// Getting details of Vendor based on a particular Id
	public abstract VendorBean getVendorById(int vendorId);

	// updating Vendor Details
	public abstract int updateVendor(VendorBean vBean);

	// updating Contact Details
	public abstract int updateContact(VendorBean vBean);

	// Searching the Vendors details using location, name, nature of service.
	public abstract List<VendorBean> vendorSearch(String searchString);

	// Disable Vendor Details
	public abstract int disableVendor(VendorBean vBean);

}