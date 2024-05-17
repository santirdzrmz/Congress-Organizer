package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day {
	private String Activity;
	private int Time;
	private String Materials;
	private String Classrooms;
	private String Roles;

	public Day(String activity, int time, String materials, String classrooms, String roles) {
		this.Activity = activity;
		this.Time = time;
		this.Materials = materials;
		this.Classrooms = classrooms;
		this.Roles = roles;
	}

	public String getActivity() {
		return Activity;
	}

	public void setActivity(String activity) {
		this.Activity = activity;
	}

	public int getTime() {
		return Time;
	}

	public void setTime(int age) {
		this.Time = age;
	}

	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		this.Roles = roles;
	}

	public String getMaterials() {
		return Materials;
	}

	public void setMaterials(String materials) {
		this.Materials = materials;
	}

	public String getClassrooms() {
		return Classrooms;
	}

	public void setClassrooms(String classrooms) {
		this.Classrooms = classrooms;
	}
}

