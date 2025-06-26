package model.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.resources.Effects;
import model.resources.TypeAttacked;

public class Champion {

	private Integer[] life = { null, null };
	private Integer[] resilience = { null, null };

	private Integer strength;
	private Integer defense;
	private Integer vdm;
	private Integer idm;
	private Integer inteligence;

	private Integer bubble;

	private TypeAttacked type;

	private Character character;

	private Integer[] positionX = { null, 200 };
	private Integer[] positionY = { null, 200 };

	private List<Effects> effects0 = new ArrayList<>();
	private List<Effects> effects1 = new ArrayList<>();

	private Boolean IA;

	private Integer[] damageReceived = { null, 0 };
	private Integer[] damageDone = { null, 0 };
	private Integer[] defended = { null, 0 };

	// ----------------Monitores-----------------
	// Recursos necessários para exibição do personagem
	private Group champion;
	private Group root;
	
	private Canvas monitor;
	private GraphicsContext gcMonitor;

	private Canvas monitorEffects;
	private GraphicsContext gcMonitorEffects;
	
	private Canvas lifeMonitor;
	private GraphicsContext gcLifeMonitor;

	private Canvas resilienceMonitor;
	private GraphicsContext gcResilienceMonitor;

	private Canvas bubbleMonitor;
	private GraphicsContext gcBubbleMonitor;

	private Canvas atributesMonitor;
	private GraphicsContext gcAtributesMonitor;
	private boolean atributesMonitorExhibition;

	private Canvas campMonitor;
	private GraphicsContext gcCampMonitor;
	private boolean campMonitorActivity = false;
	private Integer large = 500;
	
	// ------------------------------------------
	private Rectangle target;
	private boolean selected;

	public Champion(Character character) {

		this.life[1] = character.getLife();
		this.resilience[1] = character.getResilience();
		
		this.life[0] = this.life[1];
		this.resilience[0] = this.resilience[1];
		
		this.strength = character.getStrength();
		this.defense = character.getDefense();
		this.vdm = character.getVdm();
		this.idm = character.getIdm();
		this.inteligence = character.getInteligence();

		bubble = 0;

		this.type = character.getType();

		this.character = character;

		champion = new Group();

		positionX[1] = (int)(100 + 1700*Math.random());
		positionY[1] = (int)(100 + 500*Math.random());
		
		monitor = new Canvas(135, 225);
		gcMonitor = monitor.getGraphicsContext2D();
		
		monitorEffects = new Canvas(220, 325);
		gcMonitorEffects = monitorEffects.getGraphicsContext2D();

		lifeMonitor = new Canvas(220, 40);
		gcLifeMonitor = lifeMonitor.getGraphicsContext2D();
		resilienceMonitor = new Canvas(220, 40);
		gcResilienceMonitor = resilienceMonitor.getGraphicsContext2D();

		bubbleMonitor = new Canvas(40, 40);
		gcBubbleMonitor = bubbleMonitor.getGraphicsContext2D();

		atributesMonitor = new Canvas(180, monitor.getHeight());
		gcAtributesMonitor = atributesMonitor.getGraphicsContext2D();
		
		campMonitor = new Canvas(1920,1080);
		gcCampMonitor = campMonitor.getGraphicsContext2D();

		champion.getChildren().add(campMonitor);
		
		champion.getChildren().add(monitor);
		
		champion.getChildren().add(monitorEffects);

		champion.getChildren().add(lifeMonitor);
		champion.getChildren().add(resilienceMonitor);

		champion.getChildren().add(bubbleMonitor);

		champion.getChildren().add(atributesMonitor);

		monitor.setTranslateX(0);
		monitor.setTranslateY(0);
		
		monitorEffects.setTranslateX(-42);
		monitorEffects.setTranslateY(0);
		
		lifeMonitor.setTranslateX(-42);
		lifeMonitor.setTranslateY(240);
		resilienceMonitor.setTranslateX(-42);
		resilienceMonitor.setTranslateY(295);

		bubbleMonitor.setTranslateX(178 - bubbleMonitor.getWidth());
		bubbleMonitor.setTranslateY(224 - bubbleMonitor.getHeight());
		
		atributesMonitor.setTranslateX(monitor.getWidth());

		target = new Rectangle((this.positionX[1] - 42), (this.positionY[1]), 220, 325);
		
	}

	public Group getChampion() {
		return champion;
	}

	public void setChampion(Group champion) {
		this.champion = champion;
	}

	public Integer[] getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life[1] = life;
	}

	public Integer[] getResilience() {
		return resilience;
	}

	public void setResilience(Integer resilience) {
		this.resilience[1] = resilience;
	}

	public Integer getMainStrength() {
		return strength;
	}
	
	public Integer getStrength() {
		int sumAffected = 0;
		for(Effects ef : effects1) {
			sumAffected += ef.getStrengthA();
		}

		return strength + sumAffected;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getMainDefense() {
		return defense;
	}
	
	public Integer getDefense() {
		int sumAffected = 0;
		for(Effects ef : effects1) {
			sumAffected += ef.getDefenseA();
		}
	
		return defense + sumAffected;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getMainVdm() {
		return vdm;
	}
	
	public Integer getVdm() {
		int sumAffected = 0;
		for(Effects ef : effects1) {
			sumAffected += ef.getVdmA();
		}

		return vdm + sumAffected;
	}

	public void setVdm(Integer vdm) {
		this.vdm = vdm;
	}
	
	public Integer getMainIdm() {
		return idm;
	}

	public Integer getIdm() {
		int sumAffected = 0;
		for(Effects ef : effects1) {
			sumAffected += ef.getIdmA();
		}

		
		return idm + sumAffected;
	}

	public void setIdm(Integer idm) {
		this.idm = idm;
	}
	
	public Integer getMainInteligence() {
		return inteligence;
	}
	
	public Integer getInteligence() {
		int sumAffected = 0;
		for(Effects ef : effects1) {
			sumAffected += ef.getInteligenceA();
		}
		
		return inteligence + sumAffected;
	}

	public void setInteligence(Integer inteligence) {
		this.inteligence = inteligence;
	}

	public Integer getBubble() {
		return bubble;
	}

	public void setBubble(Integer bubble) {
		this.bubble = bubble;
	}
	
	public TypeAttacked getType() {
		return type;
	}

	public void setType(TypeAttacked type) {
		this.type = type;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Integer[] getPositionX() {
		return positionX;
	}

	public void setPositionX(Integer positionX) {
		this.positionX[1] = positionX;
	}

	public Integer[] getPositionY() {
		return positionY;
	}

	public void setPositionY(Integer positionY) {
		this.positionY[1] = positionY;
	}

	public List<Effects> getEffects() {
		return effects1;
	}
	
	public List<Effects> getEffects0() {
		return effects0;
	}
	
	public void setEffects(List<Effects> effects) {
		
		this.effects1 = effects;
		
	}
	
	public void addEffect(Effects effect) {
		effects1.add(effect);
	}

	public void removeEffect(Effects effect) {
		effects1.remove(effect);
	}

	public Boolean getIA() {
		return IA;
	}

	public void setIA(Boolean iA) {
		IA = iA;
	}

	public Integer[] getDamageReceived() {
		return damageReceived;
	}

	public void setDamageReceived(Integer damageReceived) {
		this.damageReceived[1] = damageReceived;
	}

	public Integer[] getDamageDone() {
		return damageDone;
	}

	public void setDamageDone(Integer damageDone) {
		this.damageDone[1] = damageDone;
	}

	public Integer[] getDefended() {
		return defended;
	}

	public void setDefended(Integer defended) {
		this.defended[1] = defended;
	}

	public Rectangle getTarget() {
		return target;
	}

	public void updateTarget() {
		target = new Rectangle((this.positionX[1] - 42), (this.positionY[1]), 220, 325);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public Canvas getMonitor() {
		return monitor;
	}
	
	public boolean isCampMonitorActivity() {
		return campMonitorActivity;
	}

	public void setCampMonitorActivity(boolean campMonitorActivity) {
		this.campMonitorActivity = campMonitorActivity;
	}
	
	
	// ------------------------------------MONITORES------------------------------------------
	// ------------------------------------MONITORES------------------------------------------
	// ------------------------------------MONITORES------------------------------------------

	private boolean beingAttacked;
	private double timeBeingAttacked;

	public void updateMonitor(double t) {
		gcMonitor.clearRect(0, 0, 135, 225);

		// -----------INDICAR SELEÇÃO DO PERSONAGEM-------------
		if (selected) {
			gcMonitor.setFill(Color.GRAY);
			gcMonitor.setGlobalAlpha(0.5);
			gcMonitor.fillRect(0, 0, 135, 225);
			gcMonitor.setGlobalAlpha(1);
		}

		gcMonitor.drawImage(character.getPicture(), character.getPicturePositionX(), character.getPicturePositionY(),
				character.getPictureWidth(), character.getPictureHeight());

		// -----------AVERMELHAR O PERSONAGEM--------------
		if (beingAttacked && timeBeingAttacked < 1) {
			timeBeingAttacked += t;

			gcMonitor.setFill(Color.RED);
			gcMonitor.setGlobalAlpha(0.5);
			gcMonitor.fillRect(0, 0, 135, 225);
			gcMonitor.setGlobalAlpha(1);

		} else {
			timeBeingAttacked = 0;
			beingAttacked = false;
		}

		// ----------Adicionando a borda do monitor-----------
		gcMonitor.setStroke(Color.BLACK);
		gcMonitor.setLineWidth(5);
		gcMonitor.strokeRect(0, 0, monitor.getWidth(), monitor.getHeight());

	}

	public void updateMonitorEffects() {
		gcMonitorEffects.clearRect(0, 0, monitorEffects.getWidth(), monitorEffects.getHeight());
		if(effects1.size() > 0) {
			gcMonitorEffects.drawImage(effects1.get(0).getPicture(), 0, 0, 50,50);
		}
		if(effects1.size() > 1) {
			gcMonitorEffects.drawImage(effects1.get(1).getPicture(), 0, 50, 50,50);
		}
		if(effects1.size() > 2) {
			gcMonitorEffects.drawImage(effects1.get(2).getPicture(), 0, 100, 50,50);
		}
		int corr = 0;
		for(Effects ef : effects1) {
			if(corr < 5) {
				gcMonitorEffects.drawImage(ef.getPicture(), 0, corr * 50, 50,50);
				corr++;
			}
		}
	}
	
	public void updateLifeMonitor() {
		gcLifeMonitor.clearRect(0, 0, lifeMonitor.getWidth(), lifeMonitor.getHeight());

		gcLifeMonitor.setFill(Color.GREEN);
		gcLifeMonitor.fillRect(0, 0, (int)(lifeMonitor.getWidth() * (getLife()[1] * 1.0/ character.getLife() * 1.0)), lifeMonitor.getHeight());
		
		gcLifeMonitor.setFill(Color.BLACK);
		gcLifeMonitor.setFont(Font.font("Calibri", FontWeight.BOLD, 24));
		gcLifeMonitor.fillText(getLife()[1] + "/" + character.getLife(), lifeMonitor.getWidth() / 2 - 40,
				lifeMonitor.getHeight() / 2 + 6);

		gcLifeMonitor.setLineWidth(3);
		gcLifeMonitor.strokeRect(0, 0, lifeMonitor.getWidth(), lifeMonitor.getHeight());
	}
	
	public void updateResilienceMonitor() {
		gcResilienceMonitor.clearRect(0, 0, resilienceMonitor.getWidth(), resilienceMonitor.getHeight());

		if(type == TypeAttacked.MAGICAL)
			gcResilienceMonitor.setFill(Color.BLUE);
		else
			gcResilienceMonitor.setFill(Color.RED);
		
		gcResilienceMonitor.fillRect(0, 0, (int) (resilienceMonitor.getWidth() * (getResilience()[1] * 1.0 / character.getResilience() * 1.0)), resilienceMonitor.getHeight());

		gcResilienceMonitor.setFill(Color.BLACK);
		gcResilienceMonitor.setFont(Font.font("Calibri", FontWeight.BOLD, 24));
		gcResilienceMonitor.fillText(getResilience()[1] + "/" + character.getResilience(),
				resilienceMonitor.getWidth() / 2 - 40, resilienceMonitor.getHeight() / 2 + 6);

		gcResilienceMonitor.setStroke(Color.BLACK);
		gcResilienceMonitor.setLineWidth(3);
		gcResilienceMonitor.strokeRect(0, 0,resilienceMonitor.getWidth(),resilienceMonitor.getHeight());
	}

	public void updateBubbleMonitor() {
		gcBubbleMonitor.clearRect(0, 0, bubbleMonitor.getWidth(), bubbleMonitor.getHeight());

		gcBubbleMonitor.setFill(Color.AQUA);
		gcBubbleMonitor.setGlobalAlpha(0.8);
		gcBubbleMonitor.fillOval(0, 0, bubbleMonitor.getWidth(), bubbleMonitor.getHeight());
		gcBubbleMonitor.setGlobalAlpha(1);

		gcBubbleMonitor.setStroke(Color.BLACK);
		gcBubbleMonitor.setLineWidth(3);
		gcBubbleMonitor.strokeOval(0, 0, bubbleMonitor.getWidth(), bubbleMonitor.getHeight());

		gcBubbleMonitor.setFill(Color.BLACK);
		gcBubbleMonitor.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
		gcBubbleMonitor.fillText(getBubble().toString(), bubbleMonitor.getWidth() / 2 - 5,
				bubbleMonitor.getHeight() / 2 + 6);
	}

	public void updateAtributesMonitor() {
		gcAtributesMonitor.clearRect(0, 0, atributesMonitor.getWidth(), atributesMonitor.getHeight());

		if (isAtributesMonitorExhibition()) {

			gcAtributesMonitor.setFill(Color.WHITE);
			gcAtributesMonitor.fillRect(0, 0, atributesMonitor.getWidth(), atributesMonitor.getHeight());

			gcAtributesMonitor.setStroke(Color.BLACK);
			gcAtributesMonitor.setLineWidth(3);
			gcAtributesMonitor.strokeRect(0, 0, atributesMonitor.getWidth(), atributesMonitor.getHeight());

			gcAtributesMonitor.setFill(Color.BLACK);
			gcAtributesMonitor.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
			gcAtributesMonitor.fillText(character.getName(), 2, 20);

			gcAtributesMonitor.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));

			gcAtributesMonitor.fillText("Força: " + getStrength() + ".", 2, 70);
			gcAtributesMonitor.fillText("Defesa: " + getDefense() + ".", 2, 90);
			gcAtributesMonitor.fillText("VDM: " + getVdm() + ".", 2, 110);
			gcAtributesMonitor.fillText("IDM: " + getIdm() + ".", 2, 130);
			gcAtributesMonitor.fillText("Inteligência: " + getInteligence() + ".", 2, 150);
			gcAtributesMonitor.fillText("Dano Recebido: " + getDamageReceived()[1] + ".", 2, 180);
			gcAtributesMonitor.fillText("Dano Dado: " + getDamageDone()[1] + ".", 2, 200);
			gcAtributesMonitor.fillText("Defendido: " + getDefended()[1] + ".", 2, 220);
		}
		
	}
	
	public void updateCampMonitor(Integer large) {
		this.large = large;
		
		campMonitor.setWidth(large);
		campMonitor.setHeight(large);
		
		campMonitor.setTranslateX(-campMonitor.getWidth()/4 + 67);
		campMonitor.setTranslateY(-campMonitor.getHeight()/4 + 112);
		
		gcCampMonitor.clearRect(0, 0, campMonitor.getWidth(), campMonitor.getHeight());
		
		if(campMonitorActivity) {
			gcCampMonitor.setFill(Color.RED);
			gcCampMonitor.setStroke(Color.WHITE);
			
			gcCampMonitor.setGlobalAlpha(0.5);
			gcCampMonitor.fillOval(0, 0, campMonitor.getWidth()/2, campMonitor.getHeight()/2);
			gcCampMonitor.strokeOval(0, 0, campMonitor.getWidth()/2, campMonitor.getHeight()/2);
			gcCampMonitor.setGlobalAlpha(1);
		}
	}
	
	public boolean isAtributesMonitorExhibition() {
		return atributesMonitorExhibition;
	}

	public void setAtributesMonitorExhibition(boolean atributesMonitorExhibition) {
		this.atributesMonitorExhibition = atributesMonitorExhibition;
	}

	public void updateImage(double t) {
	
		updateMonitor(t);
		
		updateLifeMonitor();
		updateResilienceMonitor();

		updateMonitorEffects();
		
		updateBubbleMonitor();

		updateAtributesMonitor();
		
		updateCampMonitor(large);
	}

	// ------------------------------------MONITORES------------------------------------------
	// ------------------------------------MONITORES------------------------------------------
	// ------------------------------------MONITORES------------------------------------------

	private boolean movement = false;
	
	public boolean isMovement() {
		return movement;
	}

	public void setMovement(boolean movement) {
		this.movement = movement;
	}

	private Integer objectiveX;
	private Integer objectiveY;

	private double journey;

	public void startMovement(Integer positionX, Integer positionY) {

		if (movement == false) {

			movement = true;

			this.positionX[0] = this.positionX[1];
			this.positionY[0] = this.positionY[1];

			objectiveX = positionX;
			objectiveY = positionY;

			journey = 0;

		}

	}

	public void clearMovement() {
		movement = false;

		objectiveX = null;
		objectiveY = null;

		journey = 0;
	}

	public void updateMovement(double t) {

		if (movement == true) {

			double intensity = journey / Math.sqrt(
					Math.pow((objectiveX - this.positionX[0]), 2) + Math.pow((objectiveY - this.positionY[0]), 2));

			if (journey < Math.sqrt(
					Math.pow((objectiveX - this.positionX[0]), 2) + Math.pow((objectiveY - this.positionY[0]), 2))) {
				journey += getVdm() * t;
			} else {
				movement = false;

			}

			this.positionX[1] = (int) (((objectiveX - this.positionX[0]) - monitor.getWidth() / 2) * intensity)
					+ this.getPositionX()[0];
			this.positionY[1] = (int) ((objectiveY - this.positionY[0] - monitor.getHeight() / 2) * intensity)
					+ this.getPositionY()[0];

		}

		champion.setTranslateX(this.positionX[1]);
		champion.setTranslateY(this.positionY[1]);
	}

	public void updateEffects() {
		effects1.removeIf(ef -> ef.getDuration() <= 0);
	}
	
	public void update(double t) {
		updateMovement(t);
		updateImage(t);
		updateTarget();
		updateEffects();
	}

	public void insertInScene(Group root) {
		if(this.root == null) {
			root.getChildren().add(champion);
			this.root = root;
		}

	}
	
	public void save() {
		life[0] = life[1];
		resilience[0] = resilience[1];
		
		positionX[0] = positionX[1];
		positionY[0] = positionY[1];

		effects0.clear();
		
		for(Effects ef : effects1) {
			effects0.add(ef);
		}

		damageReceived[0] = damageReceived[1];
		damageDone[0] = damageDone[1];
		defended[0] = defended[1];
		
		System.out.println("Save: " + character.getName() );
	}

	public void load() {
		
		if(damageReceived[0] != null) {
			setLife(life[0]);
			setResilience(resilience[0]);
			
			setPositionX(positionX[0]);
			setPositionY(positionY[0]);
			
			effects1.clear();
			
			for(Effects ef : effects0) {
				effects1.add(ef);
			}
			
			setDamageReceived(damageReceived[0]);
			setDamageDone(damageDone[0]);
			setDefended(defended[0]);
		}
		
	}
	
	public void beingAttacked(Integer life, Integer resilience, List<Effects> effects) {
		beingAttacked = true;
		
		setLife(this.life[1] + life);
		setResilience(this.resilience[1] + resilience);

		if(life < 0)
			setDamageReceived(this.damageReceived[1] + life);
		
		if(effects != null) {
			for (Effects ef : effects) {
				addEffect(ef);
			}
		}
		
	}

}
