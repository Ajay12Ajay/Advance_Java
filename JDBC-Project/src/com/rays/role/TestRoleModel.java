package com.rays.role;

import java.util.Iterator;
import java.util.List;

public class TestRoleModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		//testFindByName();
		 testSearch();

	}

	public static void testAdd() throws Exception {

		RoleBean bean = new RoleBean();
		bean.setId(1);
		bean.setName("Ram");
		bean.setDescription("HR");

		RoleModel model = new RoleModel();
		model.add(bean);

	}

	public static void testUpdate() throws Exception {
		RoleBean bean = new RoleBean();
		bean.setId(2);
		bean.setName("Ajay");
		bean.setDescription("Developer");

		RoleModel model = new RoleModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {
		RoleBean bean = new RoleBean();
		bean.setId(3);

		RoleModel model = new RoleModel();
		model.delete(bean);

	}

	public static void testFindByPk() throws Exception {
		RoleModel model = new RoleModel();
		RoleBean bean = model.findByPk(3);
		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getDescription());

		}
	}

	public static void testFindByName() throws Exception {
		RoleModel model = new RoleModel();
		RoleBean bean = model.findByName("Amit Sharma");
		if (bean != null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getDescription());

		}

	}

	public static void testSearch() throws Exception {
		RoleBean bean = new RoleBean();
		//bean.setId(4);
		 bean.setName("A");
		// bean.setDescription(description);

		RoleModel model = new RoleModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (RoleBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.println("\t" + bean.getDescription());

		}

	}

}
