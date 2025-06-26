package model.resources.championsPane;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.entities.Champion;

public class ChampionPanel extends Application{
	
	List<ChampionButton> championButtons = new ArrayList<>();
	public static List<Champion> champions;
	
	public ChampionPanel(List<Champion> champions) {
		this.champions = champions;
	}
	
	@Override
	public void start(Stage secondaryStage) throws Exception {
		
		Group root = new Group();
		ScrollPane scrollPane = new ScrollPane(root);
		Scene scene = new Scene(scrollPane, 300,200);
		secondaryStage.setScene(scene);
		
		championButtons.add(new LoretoButton(root));
		championButtons.add(new ShonButton(root));
		championButtons.add(new HikireiButton(root));
		championButtons.add(new FelixButton(root));
		championButtons.add(new LukeButton(root));
		championButtons.add(new RubensButton(root));
		championButtons.add(new SalazarButton(root));
		championButtons.add(new MarlockButton(root));
		championButtons.add(new GuardaAnaoButton(root));
		
		championButtons.get(1).getButton().setTranslateX(50);
		championButtons.get(2).getButton().setTranslateX(101);
		championButtons.get(3).getButton().setTranslateX(152);
		championButtons.get(4).getButton().setTranslateX(203);
		championButtons.get(5).getButton().setTranslateX(254);
		
		championButtons.get(6).getButton().setTranslateX(0);
		championButtons.get(6).getButton().setTranslateY(100);
		
		championButtons.get(7).getButton().setTranslateX(50);
		championButtons.get(7).getButton().setTranslateY(100);
		
		championButtons.get(8).getButton().setTranslateX(101);
		championButtons.get(8).getButton().setTranslateY(100);
		
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				for(ChampionButton cb : championButtons) {
					cb.update(e);
				}
				
			}
			
		});
		
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				for(ChampionButton cb : championButtons) {
					cb.clickEvent(e);
				}			
			}
			
		});
		
		
		
		
		
		secondaryStage.setTitle("Champions Panel");
		secondaryStage.show();
		
	}

	
}
