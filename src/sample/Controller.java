package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    public TextArea id_textarea;
    public TextField id_textfield;
    public Button butt_1;

    public void Click(ActionEvent actionEvent) {

        String text_message =id_textfield.getText();
        id_textarea.appendText("> "+text_message+"\n");
        id_textfield.clear();
    }


}
