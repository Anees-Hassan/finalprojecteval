package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.VendorBean;

public class VendorImpDao implements VendorIntDao {

	// declaring Jdbctemplate to connect with database
	JdbcTemplate template;

	// defining setters for template
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// Listing the Vendors details
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#getVendorList()
	 */
	@Override
	public List<VendorBean> getVendorList() {

		return template
				.query("select fe_vendorTable.vendorId,vendorName,address,location,service,pinCode,name,dptmt,email,phNo from fe_contactPersonTable join fe_vendorTable on fe_vendorTable.vendorId=fe_contactPersonTable.vendorId where isActive='1'",
						new RowMapper<VendorBean>() {

							@Override
							public VendorBean mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorBean vb = new VendorBean();
								vb.setVendorId(rs.getInt(1));
								vb.setVendorName(rs.getString(2));
								vb.setAddress(rs.getString(3));
								vb.setLocation(rs.getString(4));
								vb.setService(rs.getString(5));
								vb.setPinCode(rs.getString(6));
								vb.setName(rs.getString(7));
								vb.setDptmt(rs.getString(8));
								vb.setEmail(rs.getString(9));
								vb.setPhNo(rs.getString(10));
								return vb;
							}

						});

	}

	// Inserting Vendor basic details into Vendor Table with default isActive as
	// 1
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#insertVendor(com.ust.model.VendorBean)
	 */
	@Override
	public int insertVendor(VendorBean vBean) {

		String sql = "insert into fe_vendorTable(vendorName,address,location,service,pinCode,isActive) values('"
				+ vBean.getVendorName()
				+ "','"
				+ vBean.getAddress()
				+ "','"
				+ vBean.getLocation()
				+ "','"
				+ vBean.getService()
				+ "','"
				+ vBean.getPinCode() + "',1)";

		// insert contact table only after successfully insert in vendor table
		if (template.update(sql) != 0) {

			return insertContact(vBean);
		} else {
			return 0;
		}

	}

	// Insert remaining details in contact table by getting the VendorId from
	// Vendor table
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#insertContact(com.ust.model.VendorBean)
	 */
	@Override
	public int insertContact(VendorBean vBean) {

		String sql = "select max(vendorId) from fe_vendorTable";
		int vendorId = template.queryForObject(sql, Integer.class);

		String sql2 = "insert into fe_contactPersonTable(name,vendorId,dptmt,email,phNo) values(?,?,?,?,?)";

		return template.update(sql2, new Object[] { vBean.getName(), vendorId,
				vBean.getDptmt(), vBean.getEmail(), vBean.getPhNo() });
	}

	// Getting details of Vendor based on a particular Id
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#getVendorById(int)
	 */
	@Override
	public VendorBean getVendorById(int vendorId) {
		String sql = "select fe_vendorTable.vendorId,vendorName,address,location,service,pinCode,name,dptmt,email,phNo from fe_contactPersonTable join fe_vendorTable on fe_vendorTable.vendorId=fe_contactPersonTable.vendorId where isActive='1' and fe_vendorTable.vendorId=?";
		return template.queryForObject(sql, new Object[] { vendorId },
				new BeanPropertyRowMapper<VendorBean>(VendorBean.class));
	}

	// updating Vendor Details
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#updateVendor(com.ust.model.VendorBean)
	 */
	@Override
	public int updateVendor(VendorBean vBean) {
		String sql = "update fe_vendorTable set vendorName='"
				+ vBean.getVendorName() + "',address='" + vBean.getAddress()
				+ "'," + "location='" + vBean.getLocation() + "',service='"
				+ vBean.getService() + "',pinCode='" + vBean.getPinCode()
				+ "'," + "isActive=1 where vendorId=" + vBean.getVendorId()
				+ "";

		if (template.update(sql) != 0) {
			return updateContact(vBean);
		} else {
			return 0;
		}
	}

	// updating Contact Details
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#updateContact(com.ust.model.VendorBean)
	 */
	@Override
	public int updateContact(VendorBean vBean) {
		String sql = "update fe_contactPersonTable set name='"
				+ vBean.getName() + "',dptmt='" + vBean.getDptmt() + "',"
				+ "email='" + vBean.getEmail() + "',phNo='" + vBean.getPhNo()
				+ "' where vendorId=" + vBean.getVendorId() + "";

		return template.update(sql);

	}

	// Searching the Vendors details using location, name, nature of service.
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#vendorSearch(java.lang.String)
	 */
	@Override
	public List<VendorBean> vendorSearch(String searchString) {

		return template
				.query("select fe_vendorTable.vendorId,vendorName,address,location,service,pinCode,name,dptmt,email,phNo from fe_contactPersonTable join fe_vendorTable on fe_vendorTable.vendorId=fe_contactPersonTable.vendorId where isActive='1' and(location like '"
						+ searchString
						+ "%' or "
						+ "name like '"
						+ searchString
						+ "%' or service like '"
						+ searchString
						+ "%')", new RowMapper<VendorBean>() {

					@Override
					public VendorBean mapRow(ResultSet rs, int row)
							throws SQLException {
						VendorBean vb = new VendorBean();
						vb.setVendorId(rs.getInt(1));
						vb.setVendorName(rs.getString(2));
						vb.setAddress(rs.getString(3));
						vb.setLocation(rs.getString(4));
						vb.setService(rs.getString(5));
						vb.setPinCode(rs.getString(6));
						vb.setName(rs.getString(7));
						vb.setDptmt(rs.getString(8));
						vb.setEmail(rs.getString(9));
						vb.setPhNo(rs.getString(10));
						return vb;
					}

				});

	}

	// Disable Vendor Details
	/* (non-Javadoc)
	 * @see com.ust.dao.VendorIntDao#disableVendor(com.ust.model.VendorBean)
	 */
	@Override
	public int disableVendor(VendorBean vBean) {
		String sql = "update fe_vendorTable set isActive=0 where vendorId="
				+ vBean.getVendorId() + "";

		return template.update(sql);
	}

}
