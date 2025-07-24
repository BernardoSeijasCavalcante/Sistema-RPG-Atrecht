package model.resources;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import model.resources.buttons.BlindnessEffectButton;
import model.resources.buttons.BloodEffectButton;
import model.resources.buttons.BloquedEffectButton;
import model.resources.buttons.BrokenBonesEffectButton;
import model.resources.buttons.ConfusionEffectButton;
import model.resources.buttons.CureEffectButton;
import model.resources.buttons.CureResilienceEffectButton;
import model.resources.buttons.DefenseAEffectButton;
import model.resources.buttons.DesarmedEffectButton;
import model.resources.buttons.EffectsButtons;
import model.resources.buttons.ElectrocutingEffectButton;
import model.resources.buttons.EruditionEffectButton;
import model.resources.buttons.FearEffectButton;
import model.resources.buttons.FireEffectButton;
import model.resources.buttons.InvisibilityEffectButton;
import model.resources.buttons.PoisonEffectButton;
import model.resources.buttons.SlownessEffectButton;
import model.resources.buttons.SpeedEffectButton;
import model.resources.buttons.StrengthEffectButton;
import model.resources.buttons.VulnerabilityEffectButton;
import model.resources.buttons.WeeknessEffectButton;
import model.resources.effects.Blindness;
import model.resources.effects.Blood;
import model.resources.effects.Bloqued;
import model.resources.effects.BrokenBones;
import model.resources.effects.Confusion;
import model.resources.effects.Cure;
import model.resources.effects.CureResilience;
import model.resources.effects.Desarmed;
import model.resources.effects.Electrocuting;
import model.resources.effects.Fire;
import model.resources.effects.Poison;

public class Table {
	private Integer strengthAffected = 0;
	private Integer defenseAffected = 0;
	private Integer vdmAffected = 0;
	private Integer idmAffected = 0;
	private Integer inteligenceAffected = 0;
	
	private Integer chance = 100;
	
	private Integer resilienceCust = 0;
	
	private Boolean isAttack;
	
	private TypeAttacked typeAttacked;
	
	private List<Effects> effects = new ArrayList<>();
	
	private static boolean activity = false;
	
	private static Group table = new Group();
	private static Group root;
	
	private Canvas canvas = new Canvas(610,1080);
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	
	private TextField strengthTF = new TextField();
	private TextField defenseTF = new TextField();
	private TextField vdmTF = new TextField();
	private TextField idmTF = new TextField();
	private TextField inteligenceTF = new TextField();
	
	private TextField chanceTF = new TextField();
	
	private TextField resilienceCustTF = new TextField();
	
	private CheckBox isAttackedBox = new CheckBox();

	private ChoiceBox<String> typeAttackedBox	= new ChoiceBox<>();

	public static List<EffectsButtons> effectsButtons = new ArrayList<>();
	
	private static Rectangle target;
	
	public static Integer positionX = 1860;
	
	public Table(Group root) {
		
		this.root = root;
		
		gc.drawImage(new Image("resources/Table/TábuaDeControle.png"), 0, 0);
		
		strengthTF.setTranslateX(270);
		strengthTF.setTranslateY(40);
		
		defenseTF.setTranslateX(270);
		defenseTF.setTranslateY(80);
		
		vdmTF.setTranslateX(270);
		vdmTF.setTranslateY(120);
		
		idmTF.setTranslateX(270);
		idmTF.setTranslateY(160);
		
		inteligenceTF.setTranslateX(270);
		inteligenceTF.setTranslateY(200);
		
		chanceTF.setTranslateX(170);
		chanceTF.setTranslateY(300);
		
		resilienceCustTF.setTranslateX(350);
		resilienceCustTF.setTranslateY(300);
		
		isAttackedBox.setTranslateX(285);
		isAttackedBox.setTranslateY(270);
		
		typeAttackedBox.setTranslateX(315);
		typeAttackedBox.setTranslateY(270);
		
		typeAttackedBox.setItems(FXCollections.observableArrayList(TypeAttacked.ATTACKER.toString(), TypeAttacked.MAGICAL.toString(), TypeAttacked.SHOOTER.toString()));
		
		effectsButtons.add(new FireEffectButton());
		effectsButtons.add(new BloodEffectButton());
		effectsButtons.add(new BrokenBonesEffectButton());
		effectsButtons.add(new ConfusionEffectButton());
		effectsButtons.add(new BlindnessEffectButton());
		effectsButtons.add(new DesarmedEffectButton());
		effectsButtons.add(new BloquedEffectButton());
		effectsButtons.add(new CureEffectButton());
		effectsButtons.add(new CureResilienceEffectButton());
		effectsButtons.add(new ElectrocutingEffectButton());
		effectsButtons.add(new PoisonEffectButton());
		effectsButtons.add(new SlownessEffectButton());
		effectsButtons.add(new WeeknessEffectButton());
		effectsButtons.add(new VulnerabilityEffectButton());
		effectsButtons.add(new InvisibilityEffectButton());
		effectsButtons.add(new StrengthEffectButton());
		effectsButtons.add(new SpeedEffectButton());
		effectsButtons.add(new EruditionEffectButton());
		effectsButtons.add(new DefenseAEffectButton());
		effectsButtons.add(new FearEffectButton());
		
		table.getChildren().add(canvas);
		
		//------------------------------EFFECTSBUTTONS----------------------------
		for(EffectsButtons eb : effectsButtons) {
			table.getChildren().add(eb.getButton());
		}
		
		effectsButtons.get(0).getButton().setTranslateX(100);
		effectsButtons.get(0).getButton().setTranslateY(400);
		
		effectsButtons.get(1).getButton().setTranslateX(200);
		effectsButtons.get(1).getButton().setTranslateY(400);
		
		effectsButtons.get(2).getButton().setTranslateX(300);
		effectsButtons.get(2).getButton().setTranslateY(400);
		
		effectsButtons.get(3).getButton().setTranslateX(400);
		effectsButtons.get(3).getButton().setTranslateY(400);
		
		effectsButtons.get(4).getButton().setTranslateX(100);
		effectsButtons.get(4).getButton().setTranslateY(500);

		effectsButtons.get(5).getButton().setTranslateX(200);
		effectsButtons.get(5).getButton().setTranslateY(500);

		effectsButtons.get(6).getButton().setTranslateX(300);
		effectsButtons.get(6).getButton().setTranslateY(500);
		
		effectsButtons.get(7).getButton().setTranslateX(400);
		effectsButtons.get(7).getButton().setTranslateY(500);
		
		effectsButtons.get(8).getButton().setTranslateX(100);
		effectsButtons.get(8).getButton().setTranslateY(600);
		
		effectsButtons.get(9).getButton().setTranslateX(200);
		effectsButtons.get(9).getButton().setTranslateY(600);
		
		effectsButtons.get(10).getButton().setTranslateX(300);
		effectsButtons.get(10).getButton().setTranslateY(600);
		
		effectsButtons.get(11).getButton().setTranslateX(400);
		effectsButtons.get(11).getButton().setTranslateY(600);

		effectsButtons.get(12).getButton().setTranslateX(100);
		effectsButtons.get(12).getButton().setTranslateY(700);
		
		effectsButtons.get(13).getButton().setTranslateX(200);
		effectsButtons.get(13).getButton().setTranslateY(700);
		
		effectsButtons.get(14).getButton().setTranslateX(300);
		effectsButtons.get(14).getButton().setTranslateY(700);
		
		effectsButtons.get(15).getButton().setTranslateX(400);
		effectsButtons.get(15).getButton().setTranslateY(700);
		
		effectsButtons.get(16).getButton().setTranslateX(100);
		effectsButtons.get(16).getButton().setTranslateY(800);
		
		effectsButtons.get(17).getButton().setTranslateX(200);
		effectsButtons.get(17).getButton().setTranslateY(800);
		
		effectsButtons.get(18).getButton().setTranslateX(300);
		effectsButtons.get(18).getButton().setTranslateY(800);

		effectsButtons.get(19).getButton().setTranslateX(400);
		effectsButtons.get(19).getButton().setTranslateY(800);
		//------------------------------EFFECTSBUTTONS----------------------------
		
		table.getChildren().add(strengthTF);
		table.getChildren().add(defenseTF);
		table.getChildren().add(vdmTF);
		table.getChildren().add(idmTF);		
		table.getChildren().add(inteligenceTF);	
		
		table.getChildren().add(chanceTF);
		
		table.getChildren().add(resilienceCustTF);
		
		table.getChildren().add(isAttackedBox);
		
		table.getChildren().add(typeAttackedBox);
		
		strengthTF.setText("0");
		defenseTF.setText("0");
		vdmTF.setText("0");
		idmTF.setText("0");
		inteligenceTF.setText("0");
		
		chanceTF.setText("100");
		
		resilienceCustTF.setText("0");
		
		root.getChildren().add(table);
	}
	
	
	
	public Integer getStrengthAffected() {
		return strengthAffected;
	}



	public void setStrengthAffected(Integer strengthAffected) {
		this.strengthAffected = strengthAffected;
	}



	public Integer getDefenseAffected() {
		return defenseAffected;
	}



	public void setDefenseAffected(Integer defenseAffected) {
		this.defenseAffected = defenseAffected;
	}



	public Integer getVdmAffected() {
		return vdmAffected;
	}



	public void setVdmAffected(Integer vdmAffected) {
		this.vdmAffected = vdmAffected;
	}



	public Integer getIdmAffected() {
		return idmAffected;
	}

	public void setIdmAffected(Integer idmAffected) {
		this.idmAffected = idmAffected; 
	}

	public Integer getInteligenceAffected() {
		return inteligenceAffected;
	}



	public void setInteligenceAffected(Integer inteligenceAffected) {
		this.inteligenceAffected = inteligenceAffected;
	}



	public Integer getChance() {
		return chance;
	}



	public void setChance(Integer chance) {
		this.chance = chance;
	}



	public Integer getResilienceCust() {
		return resilienceCust;
	}



	public void setResilienceCust(Integer resilienceCust) {
		this.resilienceCust = resilienceCust;
	}



	public Boolean getIsAttack() {
		return isAttack;
	}



	public void setIsAttack(Boolean isAttack) {
		this.isAttack = isAttack;
	}



	public TypeAttacked getTypeAttacked() {
		return typeAttacked;
	}



	public void setTypeAttacked(TypeAttacked typeAttacked) {
		this.typeAttacked = typeAttacked;
	}

	public void addEffect(Effects ef) {
		effects.add(ef);
	}
	
	public void removeEffect(Effects ef) {
		effects.remove(ef);
	}
	
	public boolean isActivity() {
		return activity;
	}



	public void setActivity(boolean activity) {
		this.activity = activity;
	}



	public Group getTable() {
		return table;
	}



	public void setTable(Group table) {
		this.table = table;
	}



	public Rectangle getTarget() {
		return target;
	}



	public void setTarget(Rectangle target) {
		this.target = target;
	}



	public Integer getPositionX() {
		return positionX;
	}



	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	
	
	public void update(Double t) {
		table.setTranslateX(positionX);
		setTarget(new Rectangle(positionX,0,60,1080));
		
		//-------------------MOVIMENTO DA TÁBUA---------------------------------
		if(positionX > (1860 - 510) && isActivity()) {
			positionX -= (int)(300 * t);
		}else if(positionX < (1860) && !isActivity()) {
			positionX += (int)(300 * t);
		}
		
		//---------------CAMPOS E VARIÁVEIS---------------
		if(isActivity()) {
				try {
					if(!strengthTF.getText().equals("")) 
						strengthAffected = Integer.parseInt(strengthTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					strengthTF.setText("");
				}
				
				try {
					if(!defenseTF.getText().equals("")) 
						defenseAffected = Integer.parseInt(defenseTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					defenseTF.setText("");
				}
				
				try {
					if(!vdmTF.getText().equals("")) 
						vdmAffected = Integer.parseInt(vdmTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					vdmTF.setText("");
				}
				
				try {
					if(!idmTF.getText().equals("")) 
						idmAffected = Integer.parseInt(idmTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					idmTF.setText("");
				}
				
				try {
					if(!inteligenceTF.getText().equals("")) 
						inteligenceAffected = Integer.parseInt(inteligenceTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					inteligenceTF.setText("");
				}
				
				try {
					if(!chanceTF.getText().equals("")) 
						chance = Integer.parseInt(chanceTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					chanceTF.setText("");
				}
				
				try {
					if(!resilienceCustTF.getText().equals("")) 
						resilienceCust = Integer.parseInt(resilienceCustTF.getText());
				} catch(Exception e) {
					System.out.println("Os campos só aceitam números!");
					resilienceCustTF.setText("");
				}
		}else {
			if(!Scenery.tableTurn.isActivity())
				typeAttackedBox.requestFocus();
		}
	}
	
	public void download(Action action) {
		strengthTF.setText(action.getStrengthAffected().toString());
		defenseTF.setText(action.getDefenseAffected().toString());
		vdmTF.setText(action.getVdmAffected().toString());
		idmTF.setText(action.getIdmAffected().toString());
		inteligenceTF.setText(action.getInteligenceAffected().toString());
		
		chanceTF.setText(action.getChance().toString());
		resilienceCustTF.setText(action.getResilienceCust().toString());
		
		isAttackedBox.setSelected(action.getIsAttack());
		typeAttackedBox.setValue(action.getTypeAttack().toString());
		
		effects = action.getEffects();
		
		for(EffectsButtons eb : effectsButtons) {
			eb.setActivity(false);
			eb.setEffect(null);
			eb.setAction(action);
		}
		
		for(Effects ef : effects) {
			if(ef.getClass() == new Fire().getClass()) {
				effectsButtons.get(0).setEffect(ef);
				effectsButtons.get(0).setActivity(true);
			}
			if(ef.getClass() == new Blood().getClass()) {
				effectsButtons.get(1).setEffect(ef);
				effectsButtons.get(1).setActivity(true);
			}
			if(ef.getClass() == new BrokenBones().getClass()) {
				effectsButtons.get(2).setEffect(ef);
				effectsButtons.get(2).setActivity(true);
			}
			if(ef.getClass() == new Confusion().getClass()) {
				effectsButtons.get(3).setEffect(ef);
				effectsButtons.get(3).setActivity(true);
			}
			if(ef.getClass() == new Blindness().getClass()) {
				effectsButtons.get(4).setEffect(ef);
				effectsButtons.get(4).setActivity(true);
			}
			if(ef.getClass() == new Desarmed().getClass()) {
				effectsButtons.get(5).setEffect(ef);
				effectsButtons.get(5).setActivity(true);
			}
			if(ef.getClass() == new Bloqued().getClass()) {
				effectsButtons.get(6).setEffect(ef);
				effectsButtons.get(6).setActivity(true);
			}
			if(ef.getClass() == new Cure().getClass()) {
				effectsButtons.get(7).setEffect(ef);
				effectsButtons.get(7).setActivity(true);
			}
			if(ef.getClass() == new CureResilience().getClass()) {
				effectsButtons.get(8).setEffect(ef);
				effectsButtons.get(8).setActivity(true);
			}
			if(ef.getClass() == new Electrocuting().getClass()) {
				effectsButtons.get(9).setEffect(ef);
				effectsButtons.get(9).setActivity(true);
			}
			if(ef.getClass() == new Poison().getClass()) {
				effectsButtons.get(10).setEffect(ef);
				effectsButtons.get(10).setActivity(true);
			}
		}
		
	}
	
	public void upload(Action action) {
		
		action.setStrengthAffected(getStrengthAffected());
		action.setDefenseAffected(getDefenseAffected());
		action.setVdmAffected(getVdmAffected());
		action.setIdmAffected(getIdmAffected());
		action.setInteligenceAffected(getInteligenceAffected());
		
		action.setChance(getChance());
		action.setResilienceCust(getResilienceCust());
		
		action.setIsAttack(isAttackedBox.isSelected());
		action.setTypeAttack(TypeAttacked.valueOf(typeAttackedBox.getValue()));
		
		action.setEffects(effects);
	}
	
	public void reset() {
		setStrengthAffected(0);
		setDefenseAffected(0);
		setVdmAffected(0);
		setIdmAffected(0);
		setInteligenceAffected(0);
		setChance(100);
		setResilienceCust(0);
		
		isAttackedBox.setSelected(true);
		
		effects = null;
		
		strengthTF.setText("0");
		defenseTF.setText("0");
		vdmTF.setText("0");
		idmTF.setText("0");
		inteligenceTF.setText("0");
		
		chanceTF.setText("0");
		resilienceCustTF.setText("0");
		
		
	}
	public static void mouseOverEffectsButtons(MouseEvent e) {
		for(EffectsButtons eb : effectsButtons) {
			eb.update(e);
		}
	}
	
	public static void clickEffectsButtons(MouseEvent e) {
		for(EffectsButtons eb : effectsButtons) {
			eb.clickEvent(e);
		}
	}
	
	public static void activity(MouseEvent e) {
		if(target.contains(e.getX(), e.getY())) {
			activity = activity == true ? false : true;
			root.getChildren().remove(table);
			root.getChildren().add(table);
		}
	}
	
}
