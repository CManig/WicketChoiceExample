package org.wicketTutorial.table;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketTutorial.HomePage;
import org.wicketTutorial.helloworld.model.Group;
import org.wicketTutorial.helloworld.model.UserModel;

/**
 * Panel which contains the edit and delete link for the table of the
 * usermanagement page.
 * 
 * @author cmanig
 */
public class UsermanagementPanel extends Panel {
	/** Logger which writes on the console. */
	private static final Logger log = LoggerFactory.getLogger(UsermanagementPanel.class);

	/** serialVersionUID */
	private static final long serialVersionUID = -829506922954459782L;

	/** The user which should be changed or deleted. */
	private UserModel userForAction;
	
	/**
	 * The constructor which creates the panel with the edit and delete link.
	 * 
	 * @param id
	 *            the id of the panel
	 * @param model
	 */
	public UsermanagementPanel(String id, IModel<UserModel> model) {
		super(id, model);
		addLinks();

		userForAction = model.getObject();
	}

	/**
	 * Add the edit and delete link.
	 * 
	 * @param model
	 */
	private void addLinks() {
		AjaxLink<UserModel> edit = new AjaxLink<UserModel>("editUser") {
			/** serialVersionUID */
			private static final long serialVersionUID = 4045653268294938060L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				log.info("User-ID: " + userForAction.getUserID());
				log.info("Username: " + userForAction.getUsername());
				log.info("Firstname: " + userForAction.getFirstname());
				log.info("Lastname: " + userForAction.getLastname());
				log.info("Email: " + userForAction.geteMailaddress());
				log.info("Phone: " + userForAction.getPhoneNumber());
				log.info("Passwort: " + userForAction.getPassword());
				log.info("Salt:" + userForAction.getSalt());
				for(Group g : userForAction.getGroups()) {
					log.info("Gruppe: " + g.getGroupname());
				}
				HomePage homePage = (HomePage) getPage();				
				Form<UserModel> form = homePage.getUserForm();
				form.setDefaultModelObject(userForAction);
				target.add(form);
			}
		};		

		add(edit);
	}
}
