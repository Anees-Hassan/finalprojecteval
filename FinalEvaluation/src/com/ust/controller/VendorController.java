package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.VendorIntDao;
import com.ust.model.VendorBean;

@RestController
public class VendorController {

	// Autowired Vendor service
	@Autowired
	VendorIntDao vDao;

	// Request to list the doctor list
	@RequestMapping(value = "/api/listVendor", method = RequestMethod.GET)
	public List<VendorBean> getAllDoctors() {
		List list = vDao.getVendorList();
		return list;
	}

	// Inserting vendor details
	@RequestMapping(value = "/api/saveVendor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void doctorInsert(@RequestBody VendorBean vBean) {

		if (vBean.getVendorId() != 0) {
			vDao.updateVendor(vBean);
		} else {
			vDao.insertVendor(vBean);

		}
	}
	

	// Getting the Vendor By vendorId
	@RequestMapping(value = "/api/getVendorById/{vendorId}", method = RequestMethod.GET, produces = "application/json")
	public VendorBean getDoctoree(@ModelAttribute("vendorId") VendorBean vBean,
			@PathVariable("vendorId") int vendorId) {
		return vDao.getVendorById(vendorId);

	}

	// Searching the Vendors details using location, name, nature of service.
	@RequestMapping(value = "/api/vendorSearch/{searchString}", method = RequestMethod.GET)
	public List<VendorBean> getVendor(
			@PathVariable("searchString") String searchString) {
		List list = vDao.vendorSearch(searchString);
		return list;
	}

	// Disable Vendor
	@RequestMapping(value = "/api/disableVendor", method = RequestMethod.PUT)
	void doctorDisable(@RequestBody VendorBean vBean) {
		vDao.disableVendor(vBean);
	}
}
