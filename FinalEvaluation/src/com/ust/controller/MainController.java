package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;
import com.ust.beans.Ust_Login;
import com.ust.beans.Vendor;
import com.ust.dao.VendorDao;

@RequestMapping(value="/api")
@RestController
public class MainController {

	@Autowired
	VendorDao vdao;

	//verify login
	@RequestMapping(value = "login/{userid}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Ust_Login selectUser(@PathVariable("userid") String userid,
			@PathVariable("password") String password) {
		Ust_Login res= vdao.login(userid,password);
		System.out.println(res);
		return res;
	}

	//view all vendors

	@RequestMapping(value = "/vendor/{vendor_name}", method = RequestMethod.GET)
	@ResponseBody
	public List getVendor(Model m, @PathVariable("vendor_name") String vendor_name) {
		List list;
		if (vendor_name.equals("null")) {
			list = vdao.getVendor();
		} else {
			list = vdao.getVendorByName(vendor_name);
		}

		return list;
	}

	// Add new Vendor
	@ResponseBody
	@RequestMapping(value = "/insertVendor", method = RequestMethod.POST)
	public void insertVendor(@RequestBody Vendor v) throws ParseException {
		vdao.saveVendor(v);
	}

	// update existing Vendor
	@ResponseBody
	@RequestMapping(value = "/updateVendor", method = RequestMethod.PUT)
	public void updateVendor(@RequestBody Vendor v) throws ParseException {
		int vendorid = v.getVendorId();
		vdao.updateVendor(v, vendorid);
	}
	
	// view vendor list by id
			@RequestMapping(value = "/vendors/{vendorid}", method = RequestMethod.GET)
			@ResponseBody
			public Vendor getvendors(Model m, @PathVariable("vendorid") int vendorid) {
			
				return vdao.getVendorById(vendorid);
			
			}
			
			// to disable a vendor

			@RequestMapping(value = "/disablevendor/{vId}", method = RequestMethod.PUT)
			@ResponseBody
			public void disableVendor(@PathVariable("vId") int vId) {
			vdao.disableVendor(vId);
			}
			
			// view contactdetails by vendor id

			@RequestMapping(value = "/contactDetails/{vId}", method = RequestMethod.GET)
			@ResponseBody
			public List getContactDetails(Model m,@PathVariable("vId") int vId) {
				List list;
			list=vdao.getContactDetailsByVId(vId);
			return list;

			}


}


