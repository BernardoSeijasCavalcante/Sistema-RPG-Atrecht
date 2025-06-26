package model.resources.soundsPane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.resources.Scenery;

public class SoundPane extends Application{

	private Button musicaBatalha = new Button("Música de Batalha");
	private Button musicaBatalha2 = new Button("Música de Batalha2");
	private Button musicaSuspense = new Button("Música de Suspense");
	private Button musicaMisterio = new Button("Música de Mistério");
	private Button musicaDramatica = new Button("Música Dramática");
	private Button musicaBatalhaN = new Button("Música Batalha Normal");
	private Button stop = new Button("PARAR");
	
	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		root.getChildren().add(musicaBatalha);
		root.getChildren().add(musicaBatalha2);
		root.getChildren().add(musicaSuspense);
		root.getChildren().add(musicaMisterio);
		root.getChildren().add(musicaDramatica);
		root.getChildren().add(musicaBatalhaN);
		root.getChildren().add(stop);
		
		musicaBatalha2.setTranslateY(50);
		musicaSuspense.setTranslateY(100);
		musicaMisterio.setTranslateY(150);
		musicaDramatica.setTranslateY(200);
		musicaBatalhaN.setTranslateY(200);
		stop.setTranslateY(500);
		
		stage.show();
		
		musicaBatalha.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.playClip("src\\resources\\sounds\\musics\\MusicaBatalha.wav");
			}
			
		});
		musicaBatalha2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.playClip("src\\resources\\sounds\\musics\\MusicaBatalha2.wav");
			}
			
		});
		musicaSuspense.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.playClip("src\\resources\\sounds\\musics\\MusicaSuspense.wav");
			}
			
		});
		musicaMisterio.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.playClip("src\\resources\\sounds\\musics\\Mistério.wav");
			}
			
		});
		
		musicaDramatica.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.playClip("src\\resources\\sounds\\musics\\MusicaDramatica.wav");
			}
			
		});
		
		musicaBatalhaN.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.playClip("src\\resources\\sounds\\musics\\MusicaBatalhaNormal.wav");
			}
			
		});
		
		stop.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Scenery.stopClip();
			}
			
		});
		
		
	}
	
	public SoundPane() {
		
	}
	
}
