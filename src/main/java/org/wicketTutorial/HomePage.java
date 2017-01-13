/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketTutorial;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.wicketTutorial.form.UserForm;
import org.wicketTutorial.helloworld.model.Group;
import org.wicketTutorial.helloworld.model.UserModel;
import org.wicketTutorial.table.DAPDataProvider;
import org.wicketTutorial.table.UsermanagementPanel;

public class HomePage extends WebPage {
	
	private Form userForm;
	
	public HomePage() {	
		userForm = new UserForm("userForm"); 
		add(userForm);
		addTable();
    }
	
	public Form getUserForm() {
		return userForm;
	}

	private void addTable() {
		add(new DefaultDataTable<UserModel, String>("userTable", initColumns(), 
				new DAPDataProvider<UserModel>(getAllUsers(), "username"), 10));
		
	}
	
	private List<UserModel> getAllUsers() {
		List<UserModel> userList = new ArrayList<>();
		List<Group> groupList = new ArrayList<>();
		
		Group g1 = new Group();
		g1.setGroupId(1);
		g1.setGroupname("Group1");
		groupList.add(g1);
		
		UserModel user = new UserModel();
		user.setUserID(1);
		user.setUsername("admin");
		user.setFirstname("Christoph");
		user.setLastname("Manig");
		user.setPassword("admin");
		user.setPhoneNumber("999/20324912");
		user.seteMailaddress("admin@admin.com");
		user.setChangePasswordForce(false);
		user.setGroups(groupList);
		
		userList.add(user);
		
		return userList;
	}

	public List<IColumn<UserModel, String>> initColumns() {
		List<IColumn<UserModel, String>> columns = new ArrayList<IColumn<UserModel, String>>();

		columns.add(new AbstractColumn<UserModel, String>(new ResourceModel("datatable.action")) {
			/** serialVersionUID */
			private static final long serialVersionUID = 6160557212653571302L;

			@Override
			public void populateItem(Item<ICellPopulator<UserModel>> cellItem, String componentId, IModel<UserModel> model) {
				cellItem.add(new UsermanagementPanel(componentId, model));
			}
		});

		columns.add(new PropertyColumn<UserModel, String>(new ResourceModel("user.username"), "username", "username"));
		columns.add(new PropertyColumn<UserModel, String>(new ResourceModel("user.firstname"), "firstname", "firstname"));
		columns.add(new PropertyColumn<UserModel, String>(new ResourceModel("user.lastname"), "lastname", "lastname"));
		columns.add(new PropertyColumn<UserModel, String>(new ResourceModel("user.eMailaddress"), "eMailaddress", "eMailaddress"));
		columns.add(new PropertyColumn<UserModel, String>(new ResourceModel("user.phoneNumber"), "phoneNumber", "phoneNumber"));

		return columns;
	}

}
