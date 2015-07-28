package com.charvi.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.charvi.form.RegistrationForm;
import com.charvi.service.RegistrationService;

public class RegistrationAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionMessages appErrors = new ActionMessages();
		RegistrationForm rform = (RegistrationForm) form;

		String username = rform.getUsername();
		String password = rform.getPassword();
		
		try {
			RegistrationService rService= new RegistrationService();
			boolean doesUserExist = rService.doesUserExist(username);
			if(doesUserExist){
				appErrors.add("username", new ActionMessage("user.exists"));
				saveErrors(request, appErrors);
				rform.setPassword("");
				rform.setUsername("");
				return mapping.findForward("failure");
			}
			else{
				rService.registerUser(username, password);
				return mapping.findForward("success");
				
			}
		}
		catch(Exception e){
			
		}
		return super.execute(mapping, form, request, response);
	}
}
