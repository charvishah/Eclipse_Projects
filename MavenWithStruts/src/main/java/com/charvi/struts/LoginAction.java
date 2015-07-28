package com.charvi.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.charvi.exception.ServiceException;
import com.charvi.form.LoginForm;
import com.charvi.service.LoginService;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionMessages appErrors = new ActionMessages();

		// In MVC, model is the form object-- Login form
		LoginForm lf = (LoginForm) form;

		String username = lf.getUsername();
		String password = lf.getPassword();

		/*
		 * FetchUserCredentials fc = new FetchUserCredentials(); boolean
		 * isValidData = fc.fetchUserData(username, password);
		 */

		try {
			LoginService ls = new LoginService();
			boolean isValid = ls.isValidPassword(username, password);

			// sends the req back to the Action servlet which then reads the
			// config file to find the forward tag and its appropriate mapping
			if (isValid) {

				// setting the attribute username so that we can display the
				// username in Login Success page
				request.setAttribute("reqName", username);
				return mapping.findForward("success");
			} else {
				appErrors.add("username", new ActionMessage("login.failed"));
				saveErrors(request, appErrors);
				lf.setPassword("");
				lf.setUsername("");
				return mapping.findForward("failure");
			}

		} catch (Exception e) {
			
			if(!(e instanceof ServiceException)){
				e.printStackTrace();
			}
			
			appErrors.add("username",new ActionMessage("global.exception.message"));
			saveErrors(request, appErrors);
			lf.setPassword("");
			lf.setUsername("");
			return mapping.findForward("failure");
		}
		/*
		 * PrintWriter out = response.getWriter();
		 * 
		 * // obtaining the data from the login form using getters n setters
		 * out.println("User name entered  : " + lf.getUsername());
		 * out.println("Password entered  : " + lf.getPassword());
		 * 
		 * System.out.println("Hello user...");
		 */
	}

}
