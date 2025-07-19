package com.rays.Marksheet;

public class TestMarksheetModal {
	public static void main(String[] args) throws Exception {
		 testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindByRollNo();
		//testSearch();

	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		//bean.setId(6);
		bean.setRoll_no(107);
		bean.setName("Ram");
		bean.setPhysics(77);
		bean.setChemistry(77);
		bean.setMaths(77);

		MarksheetModal modal = new MarksheetModal();
		modal.add(bean);

	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(5);
		bean.setRoll_no(1055);
		bean.setName("Laxman");
		bean.setPhysics(55);
		bean.setChemistry(55);
		bean.setMaths(55);

		MarksheetModal modal = new MarksheetModal();
		modal.update(bean);

	}

	public static void testDelete() throws Exception {

		MarksheetModal modal = new MarksheetModal();
		modal.delete(5);

	}

	public static void testFindByPk() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		modal.findByPk(1);

	}

	public static void testFindByRollNo() throws Exception {
		MarksheetModal modal = new MarksheetModal();
		modal.findByRollNo(104);

	}

	public static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		//bean.setId(3);
		// bean.setRoll_no();
		// bean.setName(name);
		 bean.setPhysics(78);
		// bean.setChemistry();
		// bean.setMaths();
		MarksheetModal modal = new MarksheetModal();
		modal.search(bean, 1, 2);

	}

}
