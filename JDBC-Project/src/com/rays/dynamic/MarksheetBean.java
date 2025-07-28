package com.rays.dynamic;

public class MarksheetBean {
	private int id;
	private int roll_no;
	private String name;
	private int physics;
	private int chemistry;
	private int maths;

	public int getId() {
		return id;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public String getName() {
		return name;
	}

	public int getPhysics() {
		return physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public int getMaths() {
		return maths;
	}

}
