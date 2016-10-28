package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "navigationPage")
public class NavigationPage implements Serializable {


	public String searchPage(){
		return "/pages/search?faces-redirect=true";
	}

	public String indexPage(){
		return "/pages/index?faces-redirect=true";
	}

	public String chatPage(){
		return "/pages/chat?faces-redirect=true";
	}

	public String friendPage(){
		return "/pages/friend?faces-redirect=true";
	}

}
