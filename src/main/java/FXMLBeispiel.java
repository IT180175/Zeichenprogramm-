
//Ana Bikic
//3BHITM


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLBeispiel extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane();

        grid.setVgap(15);
        grid.setHgap(15);

        //VBoxen um die fertigen Figuren anzeigen zu können
        VBox rectDone = new VBox();
        VBox textDone = new VBox();
        VBox circleDone = new VBox();

        grid.add(rectDone,0,1);
        grid.add(textDone,1,1);
        grid.add(circleDone,2,1);

        //-----------------------------------------------------------Variablen die benötgt werden zum Zeichnen von einem Rechteck werden hier angelegt
        VBox rectPane = new VBox();
        TextField rectX = new TextField();
        rectX.setPromptText("RectX");
        TextField rectY = new TextField();
        rectY.setPromptText("RectY");
        TextField rectWidth = new TextField();
        rectWidth.setPromptText("RectWidth");
        TextField rectHeight = new TextField();
        rectHeight.setPromptText("RectHeight");
        TextField arcWidth = new TextField();
        arcWidth.setPromptText("ArcWidth");
        TextField arcHeight = new TextField();
        arcHeight.setPromptText("ArcHeight");
        ColorPicker colorPickerRect = new ColorPicker();
        Button drawRect = new Button("Draw your Rectangle");
        Button startAnimationRectangle = new Button("Try out your Animation");
        Rectangle rectangle = new Rectangle();

        //Elemente vom Rechteck werden zur VBOX hinzugefügt
        rectPane.getChildren().add(rectX);
        rectPane.getChildren().add(rectY);
        rectPane.getChildren().add(rectWidth);
        rectPane.getChildren().add(rectHeight);
        rectPane.getChildren().add(arcWidth);
        rectPane.getChildren().add(arcHeight);
        rectPane.getChildren().add(colorPickerRect);
        rectPane.getChildren().add(drawRect);
        rectPane.getChildren().add(startAnimationRectangle);

        //VBox wird zum GridPane hinzugefügt
        grid.add(rectPane,0,0);

        //Button onAction zum Zeichnen von dem Rechteck
        drawRect.setOnAction(actionEvent-> {

            rectangle.setX( Double.parseDouble(rectX.getText()));
            rectangle.setY(Double.parseDouble(rectY.getText()));
            rectangle.setWidth(Double.parseDouble(rectWidth.getText()));
            rectangle.setHeight(Double.parseDouble(rectHeight.getText()));
            rectangle.setArcWidth(Double.parseDouble((arcWidth.getText())));
            rectangle.setArcHeight(Double.parseDouble(arcHeight.getText()));
            rectangle.setFill(colorPickerRect.getValue());

            rectDone.getChildren().add(rectangle);

        });

        //Button onAction um die Transition des Rechtecks zu starten
        startAnimationRectangle.setOnAction(actionEvent-> {

            VBox rectangleAnimationDone = new VBox();
            grid.add(rectangleAnimationDone,0,2);

            //Transition für das Rechteck
            FadeTransition trans = new FadeTransition(Duration.seconds(2), rectangle);
            trans.setFromValue(1.0);
            trans.setToValue(.20);
            trans.setCycleCount(FadeTransition.INDEFINITE);
            trans.setAutoReverse(true);
            trans.play();

            rectangleAnimationDone.getChildren().add(rectangle);
        });



        //-----------------------------------------------------------Variablen die benötigt werden um einen Text schreiben zu können werden hier angelegt
        VBox textPane = new VBox();
        TextField textInput = new TextField();
        textInput.setPromptText("Text");
        TextField xPos = new TextField();
        xPos.setPromptText("X-Position");
        TextField yPos = new TextField();
        yPos.setPromptText("Y-Position");
        TextField fontSize= new TextField();
        fontSize.setPromptText("Font-Size");
        TextField fontFamily = new TextField();
        fontFamily.setPromptText("Font-Family");
        Button writeText = new Button("Write your Text");
        Button startAnimationText = new Button("Try out your Effect");
        Text text = new Text();

        //Elemente vom Text werden zur VBox hinzugefügt
        textPane.getChildren().add(textInput);
        textPane.getChildren().add(xPos);
        textPane.getChildren().add(yPos);
        textPane.getChildren().add(fontSize);
        textPane.getChildren().add(fontFamily);
            textPane.getChildren().add(writeText);
        textPane.getChildren().add(startAnimationText);

        //VBox wird zum GridPane hinzugefügt
        grid.add(textPane,1,0);

        //Button onAction um den Text zu schreiben
        writeText.setOnAction(actionEvent-> {

            Font font = new Font( fontFamily.getText(), Double.parseDouble(fontSize.getText()) );

            text.setX( Double.parseDouble(xPos.getText()) );
            text.setY( Double.parseDouble(yPos.getText()) );
            text.setText(textInput.getText());
            text.setFont(font);

            textDone.getChildren().add(text);
        });

        //Button onAction um den Effekt für den Text zu starten
        startAnimationText.setOnAction(actionEvent-> {

            VBox textAnimationDone = new VBox();
            grid.add(textAnimationDone,1,3);

            //Effect for the Text
            MotionBlur mb = new MotionBlur();
            mb.setRadius(15.0f);
            mb.setAngle(45.0f);
            text.setEffect(mb);
            text.setTranslateX(300);
            text.setTranslateY(150);

            textAnimationDone.getChildren().add(text);
        });

        //-----------------------------------------------------------Variablen die benötigt werden um einen Kreis zeichnen zu können werden hier angelegt
        VBox circlePane = new VBox();
        TextField centerX = new TextField();
        centerX.setPromptText("CenterX");
        TextField centerY = new TextField();
        centerY.setPromptText("CenterY");
        TextField radius = new TextField();
        radius.setPromptText("Radius");
        TextField width = new TextField();
        width.setPromptText("Width");
        ColorPicker colorPickerCircle = new ColorPicker();
        Button drawCircle = new Button("Draw your Circle");
        Button startAnimationCircle = new Button("Try out your Animation");
        Circle c = new Circle();

        //Elemente vom Kreis werden zum GridPane hinzugefügt
        circlePane.getChildren().add(centerX);
        circlePane.getChildren().add(centerY);
        circlePane.getChildren().add(radius);
        circlePane.getChildren().add(width);
        circlePane.getChildren().add(colorPickerCircle);
        circlePane.getChildren().add(drawCircle);
        circlePane.getChildren().add(startAnimationCircle);

        //VBox wird zum GridPane hinzugefügt
        grid.add(circlePane,2,0);

        //Button onAction um den Kreis zu zeichnen
        drawCircle.setOnAction(actionEvent-> {

            c.setFill(colorPickerCircle.getValue());
            c.setCenterX( Double.parseDouble (centerX.getText()));
            c.setCenterY( Double.parseDouble(centerY.getText()));
            c.setRadius( Double.parseDouble(radius.getText()));
            c.setStrokeWidth( Double.parseDouble(width.getText()));


            circleDone.getChildren().add(c);
        });


        //Button onAction um die Timeline für den Kreis zu starten
        startAnimationCircle.setOnAction(actionEvent-> {

            VBox circleAnimationDone = new VBox();
            grid.add(circleAnimationDone,2,2);

            EventHandler eventhandler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    FadeTransition fd = new FadeTransition(Duration.millis(2000), c);
                    fd.setFromValue(0);
                    fd.setToValue(1);
                    fd.setCycleCount(Timeline.INDEFINITE);
                    fd.setAutoReverse(true);
                    fd.play();
                }
            };
            Timeline timeline = new Timeline();
            timeline.setCycleCount(2);
            timeline.setAutoReverse(true);
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(2000),eventhandler));
            timeline.play();

            circleAnimationDone.getChildren().add(text);
        });


        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.setTitle("Zeichenprogramm v3");
        stage.show();

        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        launch();
    }
}