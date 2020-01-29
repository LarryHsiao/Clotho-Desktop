package com.larryhsiao.atropos;

import com.silverhetch.clotho.file.FileText;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Learning test for WebView
 */
@ExtendWith(ApplicationExtension.class)
public class WebViewTest {
    private AnchorPane root;

    @Start
    private void start(Stage stage) {
        stage.setScene(new Scene(root = new AnchorPane(), 500, 500));
        stage.show();
    }

    /**
     * Simple
     */
    @Test
    void simple() throws Exception {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    var webView = new WebView();
                    webView.getEngine().load(
                        getClass().getResource("/map.html").toURI()
                            .toASCIIString());
                    webView.getEngine().setJavaScriptEnabled(true);
//                    webView.getEngine().executeScript()
                    root.getChildren().add(webView);
                    AnchorPane.setTopAnchor(webView, 0.0);
                    AnchorPane.setLeftAnchor(webView, 0.0);
                    AnchorPane.setRightAnchor(webView, 0.0);
                    AnchorPane.setBottomAnchor(webView, 0.0);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(1000000);
    }
}
