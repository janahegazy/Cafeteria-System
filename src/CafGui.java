import javafx.animation.ScaleTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

public class CafGui extends Application {

    private Stage primaryStage;
    private Stage studentStage;
    private Stage managerStage;
    private Stage registerStage;
    private Stage loginStage;

    private ObservableList<MenuItemModel> menuItems = FXCollections.observableArrayList();
    private VBox studentRightMenu;
    private VBox managerRightPane;
    private VBox studentCenterBox;
    private Random rng = new Random();

    public void start(Stage stage) {
        primaryStage = stage;
        seedItems();
        Scene s = new Scene(buildMain(), 1000, 700);
        stage.setScene(s);
        stage.setTitle("Cafeteria");
        stage.getIcons().add(new Image("file:C:/Users/zizo/Documents/GitHub/Cafeteria-System/Coffe.png"));
        stage.show();

        studentStage = new Stage();
        studentStage.setTitle("Student");
        studentStage.getIcons().add(new Image("file:C:/Users/zizo/Documents/GitHub/Cafeteria-System/Coffe.png"));
        studentStage.setScene(createStudentScene(studentStage));
        studentStage.show();

        managerStage = new Stage();
        managerStage.setTitle("Manager");
        managerStage.getIcons().add(new Image("file:C:/Users/zizo/Documents/GitHub/Cafeteria-System/Coffe.png"));
        managerStage.setScene(createManagerScene(managerStage));
        managerStage.show();

        registerStage = new Stage();
        registerStage.setTitle("Register");
        registerStage.getIcons().add(new Image("file:C:/Users/zizo/Documents/GitHub/Cafeteria-System/Coffe.png"));
        registerStage.setScene(createRegisterScene(registerStage));

        loginStage = new Stage();
        loginStage.setTitle("Login");
        loginStage.getIcons().add(new Image("file:C:/Users/zizo/Documents/GitHub/Cafeteria-System/Coffe.png"));
        loginStage.setScene(createLoginScene(loginStage));
    }

    private void seedItems() {
        menuItems.addAll(
                new MenuItemModel("testitem1", 0, 5),
                new MenuItemModel("testitem2", 0, 5),
                new MenuItemModel("testitem3", 0, 5),
                new MenuItemModel("testitem4", 0, 5),
                new MenuItemModel("testitem5", 0, 5)
        );
    }

    private StackPane buildMain() {
        StackPane bg = createStripBg();

        Button register = styledButton("Register");
        Button login = styledButton("Login");
        Button exit = smallBackButton();
        exit.setText("Exit");
        exit.setOnAction(e -> Platform.exit());

        register.setOnAction(e -> registerStage.show());
        login.setOnAction(e -> loginStage.show());

        HBox topRow = new HBox(20, register, login);
        topRow.setAlignment(Pos.CENTER);
        VBox stackButtons = new VBox(12, topRow, exit);
        stackButtons.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(bg, stackButtons);
        return root;
    }

    private Scene createRegisterScene(Stage owner) {
        StackPane bg = createStripBg();
        BorderPane content = new BorderPane();
        content.setPrefSize(600, 300);

        VBox form = new VBox(10);
        form.setPadding(new Insets(20));
        TextField nameFld = new TextField();
        nameFld.setPromptText("Full name");
        TextField idFld = new TextField();
        idFld.setPromptText("ID");
        Button enter = formButton("Enter");
        enter.setOnAction(e -> {
            String n = nameFld.getText().trim();
            String id = idFld.getText().trim();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Registered: " + n + " (" + id + ")");
            a.showAndWait();
            owner.close();
        });
        form.getChildren().addAll(nameFld, idFld, enter);
        form.setAlignment(Pos.CENTER);
        content.setCenter(form);

        Button back = smallBackButton();
        back.setOnAction(e -> owner.close());
        HBox bottom = new HBox(8, back);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10));
        content.setBottom(bottom);

        StackPane root = new StackPane(bg, content);
        return new Scene(root, 600, 300);
    }

    private Scene createLoginScene(Stage owner) {
        StackPane bg = createStripBg();
        BorderPane content = new BorderPane();
        content.setPrefSize(400, 200);

        VBox form = new VBox(10);
        form.setPadding(new Insets(20));
        TextField idFld = new TextField();
        idFld.setPromptText("ID");
        Button enter = formButton("Enter");
        enter.setOnAction(e -> {
            String id = idFld.getText().trim();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Logged in: " + id);
            a.showAndWait();
            owner.close();
            studentStage.show();
            studentStage.toFront();
        });
        form.getChildren().addAll(idFld, enter);
        form.setAlignment(Pos.CENTER);
        content.setCenter(form);

        Button back = smallBackButton();
        back.setOnAction(e -> owner.close());
        HBox bottom = new HBox(8, back);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10));
        content.setBottom(bottom);

        StackPane root = new StackPane(bg, content);
        return new Scene(root, 400, 200);
    }

    public Scene createStudentScene(Stage owner) {
        StackPane bg = createStripBg();

        BorderPane content = new BorderPane();
        content.setPrefSize(1000, 700);

        HBox top = new HBox();
        Label nameLabel = new Label("testname");
        nameLabel.setFont(Font.font(20));
        Label loyalty = new Label("Loyalty points: 0");
        loyalty.setFont(Font.font(20));
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        top.getChildren().addAll(nameLabel, spacer, loyalty);
        top.setPadding(new Insets(12, 18, 12, 18));
        content.setTop(top);

        studentCenterBox = new VBox();
        studentCenterBox.setAlignment(Pos.CENTER);
        studentCenterBox.setPadding(new Insets(20));
        content.setCenter(studentCenterBox);

        studentRightMenu = new VBox(6);
        studentRightMenu.setPadding(new Insets(10));
        studentRightMenu.setPrefWidth(300);
        refreshStudentMenu();
        ScrollPane sp = new ScrollPane(studentRightMenu);
        sp.setFitToWidth(true);
        sp.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        content.setRight(sp);

        HBox bottom = new HBox(8);
        Button back = smallBackButton();
        back.setOnAction(e -> owner.close());
        Button exit = smallBackButton();
        exit.setText("Exit");
        exit.setOnAction(e -> owner.close());
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(back, exit);
        bottom.setPadding(new Insets(12));
        content.setBottom(bottom);

        StackPane root = new StackPane(bg, content);
        return new Scene(root, 1000, 700);
    }

    private void refreshStudentMenu() {
        studentRightMenu.getChildren().clear();
        Label menuTitle = new Label("Menu");
        menuTitle.setFont(Font.font(18));
        studentRightMenu.getChildren().add(menuTitle);
        for (MenuItemModel m : menuItems) {
            Button item = menuButton(m.getName() + "\n$" + (int)m.getPrice() + "    Stock: " + m.getStock());
            item.setOnAction(e -> showOrderConfirm(m));
            studentRightMenu.getChildren().add(item);
        }
    }

    private void showOrderConfirm(MenuItemModel m) {
        StackPane rootPane = (StackPane) studentStage.getScene().getRoot();
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0,0,0,0.12);");
        VBox card = new VBox(12);
        card.setPadding(new Insets(16));
        card.setStyle("-fx-background-color: transparent; -fx-border-color: rgba(255,255,255,0.65); -fx-border-width: 2; -fx-border-radius: 8; -fx-background-radius:8;");
        card.setAlignment(Pos.CENTER);
        Label msg = new Label("Are you sure you want to order " + m.getName() + "?");
        msg.setFont(Font.font(22));
        msg.setTextFill(Color.WHITE);
        msg.setWrapText(true);
        msg.setMaxWidth(360);
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        Button yes = formButton("Yes");
        Button no = smallBackButton();
        no.setOnAction(e -> rootPane.getChildren().remove(overlay));
        buttons.getChildren().addAll(yes, no);
        card.getChildren().addAll(msg, buttons);
        overlay.getChildren().add(card);
        overlay.setPickOnBounds(true);
        rootPane.getChildren().add(overlay);
        yes.setOnAction(e -> {
            rootPane.getChildren().remove(overlay);
            if (m.getStock() <= 0) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("Out of stock");
                a.showAndWait();
                return;
            }
            m.decrementStock();
            int minutes = 1 + rng.nextInt(3);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Estimated time of arrival: " + minutes + " minutes");
            a.showAndWait();
            refreshStudentMenu();
            refreshManagerMenu();
        });
    }

    public Scene createManagerScene(Stage owner) {
        StackPane bg = createStripBg();

        BorderPane content = new BorderPane();
        content.setPrefSize(1000, 700);

        HBox top = new HBox();
        Label title = new Label("Manager");
        title.setFont(Font.font(20));
        HBox.setHgrow(title, Priority.ALWAYS);
        Button report = styledButton("Report");
        report.setOnAction(e -> {});
        top.getChildren().addAll(title, report);
        top.setPadding(new Insets(12, 18, 12, 18));
        content.setTop(top);

        managerRightPane = new VBox(6);
        managerRightPane.setPadding(new Insets(10));
        managerRightPane.setPrefWidth(300);
        refreshManagerMenu();
        ScrollPane sp = new ScrollPane(managerRightPane);
        sp.setFitToWidth(true);
        sp.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        content.setRight(sp);

        HBox bottom = new HBox(8);
        Button back = smallBackButton();
        back.setOnAction(e -> owner.close());
        Button exit = smallBackButton();
        exit.setText("Exit");
        exit.setOnAction(e -> owner.close());
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(back, exit);
        bottom.setPadding(new Insets(12));
        content.setBottom(bottom);

        StackPane root = new StackPane(bg, content);
        return new Scene(root, 1000, 700);
    }

    private void refreshManagerMenu() {
        managerRightPane.getChildren().clear();
        Label t = new Label("Items");
        t.setFont(Font.font(18));
        managerRightPane.getChildren().add(t);
        for (MenuItemModel m : menuItems) {
            HBox row = new HBox(6);
            row.setAlignment(Pos.CENTER_LEFT);
            Button item = menuButton(m.getName() + "\n$" + (int)m.getPrice() + "    Stock: " + m.getStock());

            Button rest = formButton("Restock");
            rest.setOnAction(e -> showRestockConfirm(m, rest));
            row.getChildren().addAll(item, rest);
            managerRightPane.getChildren().add(row);
        }
    }

    private void showRestockConfirm(MenuItemModel m, Button restButton) {
        StackPane rootPane = (StackPane) managerStage.getScene().getRoot();
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0,0,0,0.12);");
        VBox card = new VBox(12);
        card.setPadding(new Insets(16));
        card.setStyle("-fx-background-color: transparent; -fx-border-color: rgba(255,255,255,0.65); -fx-border-width: 2; -fx-border-radius: 8; -fx-background-radius:8;");
        card.setAlignment(Pos.CENTER);
        Label msg = new Label("Restock " + m.getName() + " to 10? This will take 10 seconds.");
        msg.setFont(Font.font(22));
        msg.setTextFill(Color.WHITE);
        msg.setWrapText(true);
        msg.setMaxWidth(360);
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        Button yes = formButton("Yes");
        Button no = smallBackButton();
        no.setOnAction(e -> rootPane.getChildren().remove(overlay));
        buttons.getChildren().addAll(yes, no);
        card.getChildren().addAll(msg, buttons);
        overlay.getChildren().add(card);
        overlay.setPickOnBounds(true);
        rootPane.getChildren().add(overlay);
        yes.setOnAction(e -> {
            rootPane.getChildren().remove(overlay);
            restButton.setDisable(true);
            Timeline t = new Timeline(new KeyFrame(Duration.seconds(10), ev -> {
                m.setStock(10);
                restButton.setDisable(false);
                refreshManagerMenu();
                refreshStudentMenu();
            }));
            t.play();
        });
    }

    private StackPane createStripBg() {
        HBox bg = new HBox();
        Region left = new Region();
        Region mid = new Region();
        Region right = new Region();
        left.setStyle("-fx-background-color: #8B5A2B;");
        mid.setStyle("-fx-background-color: #3B3B3B;");
        right.setStyle("-fx-background-color: #D2B48C;");
        HBox.setHgrow(left, Priority.ALWAYS);
        HBox.setHgrow(mid, Priority.ALWAYS);
        HBox.setHgrow(right, Priority.ALWAYS);
        bg.getChildren().addAll(left, mid, right);
        StackPane holder = new StackPane(bg);
        holder.setPrefSize(1000, 700);
        return holder;
    }

    private Button styledButton(String text) {
        Button b = new Button(text);
        b.setFont(Font.font(18));
        b.setPadding(new Insets(10, 20, 10, 20));
        b.setStyle("-fx-background-radius: 12; -fx-background-color: linear-gradient(#f0c27b, #4b2e1e); -fx-text-fill: white;");
        b.setEffect(new DropShadow(8, Color.color(0, 0, 0, 0.45)));
        addHoverAnimation(b);
        return b;
    }

    private Button menuButton(String text) {
        Button b = new Button(text);
        b.setFont(Font.font(14));
        b.setPadding(new Insets(8, 12, 8, 12));
        b.setStyle("-fx-background-radius: 10; -fx-background-color: linear-gradient(#8b5a2b, #6b4226); -fx-text-fill: white;");
        b.setMaxWidth(Double.MAX_VALUE);
        b.setAlignment(Pos.CENTER_LEFT);
        addHoverAnimation(b);
        return b;
    }

    private Button formButton(String text) {
        Button b = new Button(text);
        b.setFont(Font.font(15));
        b.setPadding(new Insets(8, 20, 8, 20));
        b.setStyle("-fx-background-radius: 10; -fx-background-color: linear-gradient(#6B4226, #A57C55); -fx-text-fill: white;");
        b.setEffect(new DropShadow(6, Color.color(0, 0, 0, 0.35)));
        addHoverAnimation(b);
        return b;
    }

    private Button smallBackButton() {
        Button b = new Button("Back");
        b.setFont(Font.font(13));
        b.setPadding(new Insets(6, 14, 6, 14));
        b.setStyle("-fx-background-radius: 8; -fx-background-color: #777777; -fx-text-fill: white;");
        addHoverAnimation(b);
        return b;
    }

    private void addHoverAnimation(Button b) {
        ScaleTransition stIn = new ScaleTransition(Duration.millis(140), b);
        stIn.setToX(1.06);
        stIn.setToY(1.06);
        ScaleTransition stOut = new ScaleTransition(Duration.millis(140), b);
        stOut.setToX(1.0);
        stOut.setToY(1.0);
        b.setOnMouseEntered(e -> stIn.playFromStart());
        b.setOnMouseExited(e -> stOut.playFromStart());
    }

    private static class MenuItemModel {
        private String name;
        private double price;
        private int stock;
        MenuItemModel(String n, double p, int s) { name = n; price = p; stock = s; }
        String getName() { return name; }
        double getPrice() { return price; }
        int getStock() { return stock; }
        void setStock(int v) { stock = v; }
        void decrementStock() { if (stock>0) stock--; }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
