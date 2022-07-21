package com.ifsc.tds.artur.andre.felipe.menu;

import com.ifsc.tds.artur.andre.felipe.controller.ContatoListaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Menu extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			// carregando o loader
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/com/ifsc/tds/artur/andre/felipe/view/ContatoLista.fxml"));
			Parent contatoListaXML = loader.load();

			// carregando o controller e a scene
			ContatoListaController contatoListaController = loader.getController();
			Scene contatoListaLayout = new Scene(contatoListaXML);
			Stage contatoListaJanela = new Stage();
			contatoListaJanela.initModality(Modality.APPLICATION_MODAL);
			contatoListaJanela.resizableProperty().setValue(Boolean.FALSE);
			contatoListaJanela.setScene(contatoListaLayout);
			contatoListaJanela.setTitle("ContatoLista.fxml");

			// atribuindo evento para fechar janela
			contatoListaJanela.setOnCloseRequest(e -> {
				if (contatoListaController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});

			contatoListaJanela.show();

			// posicionando a janela no centro da tela do computador
			Rectangle2D posicaoJanela = Screen.getPrimary().getVisualBounds();
			contatoListaJanela.setX((posicaoJanela.getWidth() - contatoListaJanela.getWidth()) / 2);
			contatoListaJanela.setY((posicaoJanela.getHeight() - contatoListaJanela.getHeight()) / 2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
