package controller;

import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import model.BMI;
import model.Gender;

public class BMIController {

    private static final Locale ID = Locale.forLanguageTag("id-ID");

    private static final double GAUGE_MIN = 10.0;
    private static final double GAUGE_MAX = 40.0;
    private static final double GAUGE_WIDTH = 270.0;

    @FXML private VBox root;
    @FXML private ToggleGroup genderGroup;
    @FXML private ToggleButton btnCowok;
    @FXML private ToggleButton btnCewek;
    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private Label lblError;

    @FXML private Label lblPlaceholder;
    @FXML private VBox resultBox;
    @FXML private Label lblBmi;
    @FXML private Label lblKategori;
    @FXML private Label lblSaran;
    @FXML private Circle marker;

    @FXML
    public void initialize() {
        genderGroup.selectedToggleProperty().addListener((obs, lama, baru) -> {
            if (baru == null) {
                if (lama != null) {
                    lama.setSelected(true);
                }
                return;
            }
            terapkanTema();
            if (resultBox.isVisible()) {
                handleHitungBMI();
            }
        });
        terapkanTema();

        txtBerat.setOnAction(e -> handleHitungBMI());
        txtTinggi.setOnAction(e -> handleHitungBMI());
    }

    @FXML
    public void handleHitungBMI() {
        sembunyikanError();
        try {
            double berat = bacaAngka(txtBerat, "Berat badan");
            double tinggi = bacaAngka(txtTinggi, "Tinggi badan");

            BMI bmi = new BMI(tinggi, berat, getGender());
            tampilkanHasil(bmi);
        } catch (IllegalArgumentException e) {
            tampilkanError(e.getMessage());
        }
    }

    @FXML
    public void handleReset() {
        txtBerat.clear();
        txtTinggi.clear();
        sembunyikanError();
        tampilkan(resultBox, false);
        tampilkan(lblPlaceholder, true);
        txtBerat.requestFocus();
    }

    private Gender getGender() {
        return btnCewek.isSelected() ? Gender.CEWEK : Gender.COWOK;
    }

    private void terapkanTema() {
        root.getStyleClass().removeAll("theme-male", "theme-female");
        root.getStyleClass().add(btnCewek.isSelected() ? "theme-female" : "theme-male");
    }

    private double bacaAngka(TextField field, String nama) {
        String teks = field.getText() == null ? "" : field.getText().trim();
        if (teks.isEmpty()) {
            throw new IllegalArgumentException(nama + " tidak boleh kosong.");
        }
        try {
            return Double.parseDouble(teks.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nama + " harus berupa angka.");
        }
    }

    private void tampilkanHasil(BMI bmi) {
        double skor = bmi.hitungSkor();
        String warna = bmi.getWarna();

        lblBmi.setText(String.format(ID, "%.1f", skor));
        lblKategori.setText(bmi.getKategori());
        lblKategori.setStyle("-fx-text-fill: " + warna + ";");
        lblSaran.setText(bmi.getSaran());
        double nilai = Math.max(GAUGE_MIN, Math.min(GAUGE_MAX, skor));
        marker.setCenterX((nilai - GAUGE_MIN) / (GAUGE_MAX - GAUGE_MIN) * GAUGE_WIDTH);
        marker.setStyle("-fx-stroke: " + warna + ";");

        tampilkan(lblPlaceholder, false);
        tampilkan(resultBox, true);
    }

    private void tampilkanError(String pesan) {
        lblError.setText(pesan);
        tampilkan(lblError, true);
    }

    private void sembunyikanError() {
        tampilkan(lblError, false);
    }

    private void tampilkan(Node node, boolean tampil) {
        node.setVisible(tampil);
        node.setManaged(tampil);
    }
}
