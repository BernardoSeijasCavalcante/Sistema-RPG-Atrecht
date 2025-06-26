package model.resources;

import javafx.scene.image.Image;

public abstract class Effects {
	
	private int lifeA;
	private int resilienceA;
	
	private int strengthA;
	private int defenseA;
	private int vdmA;
	private int idmA;
	private int inteligenceA;
	
	private int duration;
	
	private Image picture;

	public Effects(int lifeA, int resilienceA, int strengthA, int defenseA, int vdmA, int idmA, int inteligenceA, int duration) {
		this.lifeA = lifeA;
		this.resilienceA = resilienceA;
		this.strengthA = strengthA;
		this.defenseA = defenseA;
		this.vdmA = vdmA;
		this.idmA = idmA;
		this.inteligenceA = inteligenceA;
		
		this.duration = duration;
	}

	public Effects() {
		// TODO Auto-generated constructor stub
	}

	public int getLifeA() {
		return lifeA;
	}

	public void setLifeA(int lifeA) {
		this.lifeA = lifeA;
	}

	public int getResilienceA() {
		return resilienceA;
	}

	public void setResilienceA(int resilienceA) {
		this.resilienceA = resilienceA;
	}

	public int getStrengthA() {
		return strengthA;
	}

	public void setStrengthA(int strengthA) {
		this.strengthA = strengthA;
	}

	public int getDefenseA() {
		return defenseA;
	}

	public void setDefenseA(int defenseA) {
		this.defenseA = defenseA;
	}

	public int getVdmA() {
		return vdmA;
	}

	public void setVdmA(int vdmA) {
		this.vdmA = vdmA;
	}

	public int getIdmA() {
		return idmA;
	}

	public void setIdmA(int idmA) {
		this.idmA = idmA;
	}

	public int getInteligenceA() {
		return inteligenceA;
	}

	public void setInteligenceA(int inteligenceA) {
		this.inteligenceA = inteligenceA;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}

	public Image getPicture() {
		return picture;
	}
	
	
}
