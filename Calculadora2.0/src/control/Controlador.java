package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ModelCalc;
import model.Operacao;
import java.text.DecimalFormat;

public class Controlador {

    @FXML
    private TextField txtResultado;

    @FXML
    private TextField txtHistory;

    @FXML
    private Pane paneParent;
    private double n1;
    private double n2;
    private Double resultado;
    private Operacao operation;
    private boolean isFirstNumber = true;
    DecimalFormat df = new DecimalFormat("#.#######");

    @FXML
    public void initialize() {
        setTxtResultado("0");
        setTxtHistory("⌛");
    }

    @FXML
    private void clickBtn(ActionEvent event) {
        checkNull();
        String value = ((Button) event.getSource()).getText();
        setTxtResultado(getTxtResultado() + value);
    }

    @FXML
    private void clickOperation(ActionEvent event) {
        setTxtHistory(((Button) event.getSource()).getText());
        if (!getTxtResultado().equals("")) {
            if (isFirstNumber) {
                Button btn = (Button) event.getSource();
                operation = Operacao.valueOf(btn.getId().substring(2));
                n1 = Double.parseDouble(getTxtResultado());
                isFirstNumber = false;
                setTxtResultado("");
            } else {
                n2 = Double.parseDouble(getTxtResultado());
                resultado = ModelCalc.calculate(n1, n2, operation);
                if (ModelCalc.checkInteiro(resultado)) { //tirar .0
                    Integer value = resultado.intValue();
                    setTxtResultado(String.valueOf(value));
                } else {
                    setTxtResultado(String.valueOf(resultado));
                }
                setTxtHistory(String.valueOf(n1) + " " + String.valueOf(operation.getValue()) + " " + String.valueOf(n2));
                isFirstNumber = true;
            }
        }
    }

    @FXML
    private void btnVirg() {
        String value = getTxtResultado();
        if (ModelCalc.checkDecimal(value)) {
            setTxtResultado(value + ".");
        }
    }

    @FXML
    private void btnNeg(ActionEvent event) {
        setTxtHistory(((Button) event.getSource()).getText());
        if(!getTxtResultado().equals("")) {
            Double value = Double.parseDouble(getTxtResultado());
            value = value * (-1);
            if (ModelCalc.checkInteiro(value)) {
                Integer re = value.intValue();
                setTxtResultado(String.valueOf(re));
            } else {
                setTxtResultado(String.valueOf(value));
            }
        }
        else
            setTxtResultado("");
    }

    @FXML
    private void btnApag() {
        String resultString = getTxtResultado();
        if ((resultString.length() > 0)) {
            resultString = resultString.substring(0, resultString.length() - 1);
            setTxtResultado(resultString);
        }
    }

    @FXML
    private void resetNumbers() {
        setTxtResultado("");
        n1 = 0;
        n2 = 0;
    }

    @FXML
    private void checkNull() {
        if (getTxtResultado().equals("0")) {
            setTxtResultado("");
        }
    }

    @FXML
    private String getTxtResultado() {
        return txtResultado.getText();
    }

    @FXML
    private void setTxtResultado(String result) {
        txtResultado.setText(result);
    }

    @FXML
    private void setTxtHistory(String result) {
        txtHistory.setText(result);
    }


    @FXML
    public void btnQuad(ActionEvent actionEvent) {
        setTxtHistory(((Button) actionEvent.getSource()).getText());
        if(!getTxtResultado().equals("")) {
            Double value = Double.parseDouble(getTxtResultado());
            value = value * value;
            if (ModelCalc.checkInteiro(value)) {
                Integer re = value.intValue();
                setTxtResultado(String.valueOf(re));
            } else {
                setTxtResultado(String.valueOf(value));
            }
        }
        else
            setTxtResultado("");

    }


    @FXML
    public void btnPerc(ActionEvent actionEvent) {
        setTxtHistory(((Button) actionEvent.getSource()).getText());
        if(!getTxtResultado().equals("")) {
            Double value = Double.parseDouble(getTxtResultado());
            value = value / 100;
            if (ModelCalc.checkInteiro(value)) {
                Integer re = value.intValue();
                setTxtResultado(String.valueOf(re));
            } else {
                setTxtResultado(String.valueOf(value));
            }
        }
        else
            setTxtResultado("");
    }

    @FXML
    public void clickBtnClose(ActionEvent actionEvent) {
        Stage stage = (Stage)paneParent.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void ClickBtnMinimize(ActionEvent actionEvent) {
        Stage stage = (Stage)paneParent.getScene().getWindow();
        stage.setIconified(true);
    }
}
