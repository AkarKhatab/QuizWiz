/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package login;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author zolic
 */
@Named
@ViewScoped
public class login implements Serializable {
	private String username;
	private String password;
	private boolean isUsernameValid;
	private boolean isPasswordValid;
	private boolean validationComplete = false;
	
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
	
	public boolean getIsUsernameValid() {
		return isUsernameValid;
	}
	
	public void setUsernameValid(boolean isUsernameValid) {
		this.isUsernameValid = isUsernameValid;
	}
	
	public boolean getIsPasswordValid() {
		return isPasswordValid;
	}
	
	public void setPasswordValid(boolean isPasswordValid) {
		this.isPasswordValid = isPasswordValid;
	}
	
	public boolean getValidationComplete() {
		return validationComplete;
	}
	
	public void setValidationComplete(boolean validationComplete) {
		this.validationComplete = validationComplete;
	}

	public String checkValidity() throws IOException {
		if (this.username == null || this.username.equals("") ){
			isUsernameValid = false;
		}
		else {
			isUsernameValid = true;
		}
		if (this.password == null  || this.password.equals("")) {
			isPasswordValid = false;
		} 
		else {
			isPasswordValid = true;
		}
                if(username.equals("admin") && password.equals("admin")){
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("ownQuestion.xhtml");
                }
                validationComplete = true;
                return "success";
	}
}
