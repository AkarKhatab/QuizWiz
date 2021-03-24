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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author zolic
 */
@Named
@ViewScoped
@NoArgsConstructor@Getter@Setter
public class Login implements Serializable {
	private String username;
	private String password;
	private boolean isUsernameValid;
	private boolean isPasswordValid;
	private boolean validationComplete = false;

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
