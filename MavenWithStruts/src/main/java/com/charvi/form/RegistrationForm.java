package com.charvi.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrationForm extends ActionForm {

	// the variable names should be exactly the same as mentioned in login.jsp
	// 'property' tag
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// checks if there are any errors
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// ActionErrors given by the Struts framework
		ActionErrors error_msg = new ActionErrors();

		if (getUsername() == null || ("".equals(getUsername()))) {
			error_msg.add("common.name.err", new ActionMessage(
					"error.name.required"));
		}

		if (getPassword() == null || ("".equals(getPassword()))) {
			error_msg.add("common.password.err", new ActionMessage(
					"error.password.required"));
		}

		return error_msg;

	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
}