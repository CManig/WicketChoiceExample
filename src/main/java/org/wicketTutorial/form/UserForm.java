package org.wicketTutorial.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.ListMultipleChoice;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.wicketTutorial.helloworld.model.Group;
import org.wicketTutorial.helloworld.model.UserModel;

public class UserForm extends Form{

	public UserForm(String id) {
		super(id);			

		setDefaultModel(new CompoundPropertyModel<UserModel>(new UserModel()));
		
		addSelect();
		addTxt();
	}

	private void addTxt() {
		TextField<String> username = new TextField<String>("username");
		PasswordTextField password = new PasswordTextField("password");
		
		add(username);
		add(password);		
	}

	private void addSelect() {		
		ListMultipleChoice<Group> groups =
				new ListMultipleChoice<>("groups", getGroups(), new ChoiceRenderer<Group>("groupname"));
		
		add(groups);		
	}
	
	private List<Group> getGroups() {
		Group g1 = new Group();
		g1.setGroupId(1);
		g1.setGroupname("Group1");
		Group g2 = new Group();
		g2.setGroupId(2);
		g2.setGroupname("Group2");
		
		List<Group> groupList = new ArrayList<>();
		groupList.add(g1);
		groupList.add(g2);
		
		return groupList;
	}
}
