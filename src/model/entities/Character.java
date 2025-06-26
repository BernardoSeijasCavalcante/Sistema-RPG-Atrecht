package model.entities;

import javafx.scene.image.Image;
import model.resources.TypeAttacked;

public class Character {
	
	private Integer life;
	private Integer resilience;
	
	private Integer strength;
	private Integer defense;
	private Integer vdm;
	private Integer idm;
	private Integer inteligence;

	private TypeAttacked type;
	
	private String name;
	
	private Image picture;
	private Integer picturePositionX;
	private Integer picturePositionY;
	private Double pictureWidth;
	private Double pictureHeight;
	
	public Character(Integer life, Integer resilience, Integer strength, Integer defense, Integer vdm, Integer idm, Integer inteligence, 
			TypeAttacked type,String name, Image picture) {
		this.life = life;
		this.resilience = resilience;
		this.strength = strength;
		this.defense = defense;
		this.vdm = vdm;
		this.idm = idm;
		this.inteligence = inteligence;
		
		this.type = type;
		
		this.name = name;
		
		this.picture = picture;
		picturePositionX = -100;
		picturePositionY = 0;
		pictureWidth = picture.getWidth();
		pictureHeight = picture.getHeight();
		
	}
		
	public Character(Integer life, Integer resilience, Integer strength, Integer defense, Integer vdm, Integer idm,
			Integer inteligence, TypeAttacked type, String name, Image picture, Integer picturePositionX,
			Integer picturePositionY, Double pictureWidth, Double pictureHeight) {
		
		this.life = life;
		this.resilience = resilience;
		this.strength = strength;
		this.defense = defense;
		this.vdm = vdm;
		this.idm = idm;
		this.inteligence = inteligence;
		this.type = type;
		this.name = name;
		this.picture = picture;
		this.picturePositionX = picturePositionX;
		this.picturePositionY = picturePositionY;
		this.pictureWidth = pictureWidth;
		this.pictureHeight = pictureHeight;
	}

	public Integer getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life = life;
	}

	public Integer getResilience() {
		return resilience;
	}

	public void setResilience(Integer resilience) {
		this.resilience = resilience;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getVdm() {
		return vdm;
	}

	public void setVdm(Integer vdm) {
		this.vdm = vdm;
	}

	public Integer getIdm() {
		return idm;
	}

	public void setIdm(Integer idm) {
		this.idm = idm;
	}
	
	public Integer getInteligence() {
		return inteligence;
	}

	public void setInteligence(Integer inteligence) {
		this.inteligence = inteligence;
	}

	public TypeAttacked getType() {
		return type;
	}

	public void setType(TypeAttacked type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image picture) {
		this.picture = picture;
	}

	public Integer getPicturePositionX() {
		return picturePositionX;
	}

	public void setPicturePositionX(Integer picturePositionX) {
		this.picturePositionX = picturePositionX;
	}

	public Integer getPicturePositionY() {
		return picturePositionY;
	}

	public void setPicturePositionY(Integer picturePositionY) {
		this.picturePositionY = picturePositionY;
	}

	public Double getPictureWidth() {
		return pictureWidth;
	}

	public void setPictureWidth(Double pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	public Double getPictureHeight() {
		return pictureHeight;
	}

	public void setPictureHeight(Double pictureHeight) {
		this.pictureHeight = pictureHeight;
	}
	
	
}
