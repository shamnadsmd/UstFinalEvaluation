package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Ust_Login;
import com.ust.beans.Vendor;

public class VendorDao {

	JdbcTemplate template;



	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	//--------------------UST LOGIN---------------------//

	public Ust_Login login(String userid, String password) {
		String sql = "select username from ust_login where userid='"
				+ userid
				+ "' and password='" + password + "'";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Ust_Login>(Ust_Login.class));
	}

	//	get all vendors

	public List<Vendor> getVendor() {
		return template.query
				("select vendorid,vendorname,address,location,service,pincode from vendor where isactive=1",
						new RowMapper<Vendor>() {
					public Vendor mapRow(ResultSet rs, int row)
							throws SQLException {
						Vendor v = new Vendor();
						v.setVendorId(rs.getInt(1));
						v.setVendorName(rs.getString(2));
						v.setAddress(rs.getString(3));
						v.setLocation(rs.getString(4));
						v.setService(rs.getString(5));
						v.setPincode(rs.getInt(6));
						return v;
					}
				});
	}


	//		 get vendor by name

	public List<Vendor> getVendorByName(String vendorName) {
		return template
				.query("select vendorid,vendorname,address,location,service,pincode from vendor where isactive=1 and vendorname='"+ vendorName + "'",
						new RowMapper<Vendor>() {
					public Vendor mapRow(ResultSet rs, int row)
							throws SQLException {
						Vendor v = new Vendor();
						v.setVendorId(rs.getInt(1));
						v.setVendorName(rs.getString(2));
						v.setAddress(rs.getString(3));
						v.setLocation(rs.getString(4));
						v.setService(rs.getString(5));
						v.setPincode(rs.getInt(6));
						return v;
					}
				});
	}
	
	
//	Get vendor by id
	public Vendor getVendorById(int vendorid) {
		String sql="select vc.vendorid,vc.vendorname,vc.address,vc.location,vc.service,vc.pincode,cd.contactname,cd.department,cd.email,cd.phone,cd.contactid from vendor vc join vendorcontacts cd on vc.vendorid=cd.vendorid where vc.isActive=1 and vc.vendorid="+ vendorid + "";
		return template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Vendor>(Vendor.class));

//		,
//						new RowMapper<Vendor>() {
//							public Vendor mapRow(ResultSet rs, int row)
//									throws SQLException {
//								Vendor v = new Vendor();
//								v.setVendorId(rs.getInt(1));
//								v.setVendorName(rs.getString(2));
//								v.setAddress(rs.getString(3));
//								v.setLocation(rs.getString(4));
//								v.setService(rs.getString(5));
//								v.setPincode(rs.getInt(6));
//								v.setContactName(rs.getString(7));
//								v.setDepartment(rs.getString(8));
//								v.setEmail(rs.getString(9));
//								v.setPhone(rs.getString(10));
//								v.setContactID(rs.getInt(11));
//								return v;
//							}
//						});
	}

	//---------Add vendors

	public int saveVendor(Vendor v) {

		String sql1 = "insert into vendor(vendorname,address,location,service,pincode,isactive) values "
				+ "('"
				+ v.getVendorName()
				+ "','"
				+ v.getAddress()
				+ "','"
				+ v.getLocation()
				+ "','"
				+ v.getService()
				+ "','"
				+ v.getPincode()
				+ "',"
				+ 1
				+ ")";

		template.update(sql1);

		Integer maxId = getSequence();
		String sql2="insert into vendorcontacts(vendorid,contactname,department,email,phone,isactive) values ("
				+ maxId
				+ ",'"
				+ v.getContactName()
				+ "','"
				+ v.getDepartment()
				+ "','"
				+ v.getEmail()
				+ "','" + v.getPhone()
				+"',"
				+1
				+ ")";
		return template.update(sql2);



	}

	// to get vendor id
	private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vendorid)from vendor";
		seq = template.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	// update vendor
	public int updateVendor( Vendor v,int vendorid) {

		String sql = "update vendor set vendorname='" + v.getVendorName()
				+ "' ,address='" + v.getAddress() + "' ,location='"
				+ v.getLocation() + "',service='" + v.getService() + "',pincode=" + v.getPincode() + ",isactive=1  "
				+ "where vendorid =" + vendorid;
		template.update(sql);

		// Integer maxId = getSequence();

		String sql1 = "update vendorcontacts set vendorid=" + vendorid + ",contactname='"
				+ v.getContactName() + "',department='"
				+ v.getDepartment() + "',email='"
				+ v.getEmail() + "',phone='" + v.getPhone() + "'where contactid = " + v.getContactID();

		return template.update(sql1);
	}
	
	public List<Vendor> getContactDetailsByVId(int vid) {
		return template.query("select contactid,contactname,department,vendorid,email,phone from contactdetails where vendorid="+vid+"", new RowMapper<Vendor>() {
			public Vendor mapRow(ResultSet rs, int row)
					throws SQLException {
				Vendor v = new Vendor();
				v.setContactID(rs.getInt(1));
				v.setContactName(rs.getString(2));
				v.setDepartment(rs.getString(3));
				v.setVendorId(rs.getInt(4));
				v.setEmail(rs.getString(5));
				v.setPhone(rs.getString(6));
				return v;
			}
		});
		}
		//--------------- to disable a vendor
		public int disableVendor(int vId) {

		String sql = "update vendor set isActive='0' where vendorid=" + vId
		+ "";

		return template.update(sql);
		}

}
