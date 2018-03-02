package ticket;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Marco
 */
public class TicketView extends GridPane
{    
    private int currentTicket = 0;
    //Creating the entry or display grid pane elements
    private Label numberLabel = new Label("Ticket number");
    private TextField numberTF = new TextField();
    private Label licenseLabel = new Label("License number   ");
    private TextField licenseTF = new TextField();
    private Label stateLabel = new Label("State");
    private TextField stateTF = new TextField();
    private Label permitLabel = new Label("Permit number");
    private TextField permitTF = new TextField();
    private Label modelLabel = new Label("Model");
    private TextField modelTF = new TextField();
    private Label colorLabel = new Label("Color");
    private TextField colorTF = new TextField();
    private Label reasonLabel = new Label("Reason");
    private Label dateLabel = new Label("Date");
    private TextField dateTF = new TextField();
    private Label timeLabel = new Label("Time");
    private TextField timeTF = new TextField();
    private Label locationLabel = new Label("Location");
    private TextField locationTF = new TextField();
    private Label issuedLabel = new Label("Issued by");
    private TextField issuedTF = new TextField();
    
    //for the allowed options
    private Button btn1 = new Button();
    private Button btn2 = new Button();
    private Button btn3 = new Button();
    private Button btn4 = new Button();
    private Button btn5 = new Button();
    
    //for the payment info
    private TextArea paymentTA = new TextArea();
    
    //for the feedback
    private Label feedbackLabel = new Label("Feedback information:\nNot supported yet");
    
    //creating the vertical boxes for the gridpane
    private VBox io1VBox = new VBox();
    private VBox io2VBox = new VBox();
    private VBox allowedVBox = new VBox();
    
    private ComboBox comboBox;
    
    public TicketView()
    {
        //setting the maximum value for the payment text area
        paymentTA.setMaxSize(300, 400);
        paymentTA.setText("PAYMENTS\n"
                + "Payments can be made at the following office:\n"
                + "Business Office, Tandy 107\n"
                + "Monday thru Friday 8:00 am - 5:00 pm\n"
                + "$25 per citation, other fees may apply\n"
                + "$100 for boot removal\n"
                + "Payment can be mailed to the following address:\n"
                + "TSC C/O Finance Dept\n"
                + "Attn: Parking Enforcement\n"
                + "80 Fort Brown\n"
                + "Brownsville, TX 78520\n"
                + "DO NOT MAIL IN CASH!\n"
                + "For More Information on parking citations please visit:\n"
                + "www.tsc.edu/parking\n");
        
        //adding the labels and textfields into the vertical boxes
        io1VBox.getChildren().addAll(numberLabel, licenseLabel, stateLabel,permitLabel,modelLabel,colorLabel,reasonLabel,
                dateLabel,timeLabel,locationLabel,issuedLabel);
        io1VBox.setSpacing(9);
        io1VBox.setAlignment(Pos.CENTER);
        
        //creating a ComboBox
        comboBox = new ComboBox();
        comboBox.getItems().addAll("Vehicle has no parking permit","Parked in no parking area/space","Parked in fire lane");
        comboBox.getItems().addAll("Parked in handicap space","Parked in reserver or assigned space");
        comboBox.getItems().addAll("Blocking driveway, access or other vehicle", "Parked in 2 spaces");
        comboBox.getItems().addAll("Expired meter", "Other reason");
                
        io2VBox.getChildren().addAll(numberTF,licenseTF,stateTF,permitTF,modelTF,colorTF,comboBox,dateTF,timeTF,
                locationTF,issuedTF);
        io2VBox.setAlignment(Pos.CENTER);
        
        //adding the buttons to the vbox
        allowedVBox.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        
        //creating the actions for the buttons
        btn1.setText("Create ticket");
        btn2.setText("<<");
        btn3.setText(">>");
        btn4.setText("Change status");
        btn5.setText("Exit");
        
        //adding the final components into the grid pane
        this.add(allowedVBox, 0, 1, 1,1);
        this.add(io1VBox, 1,1,1,1);
        this.add(io2VBox, 2,1,1,1);
        this.add(paymentTA,3,1,1,1);
        this.add(feedbackLabel,2,2,2,1);
        //vertical and horizontal separation
        this.setHgap(15);
        this.setVgap(50);
        this.setAlignment(Pos.CENTER);
    }

    public int getCurrentTicket()
    {
        return currentTicket;
    }

    public void setCurrentTicket(int currentTicket)
    {
        this.currentTicket = currentTicket;
    }

    public Label getNumberLabel()
    {
        return numberLabel;
    }

    public void setNumberLabel(Label numberLabel)
    {
        this.numberLabel = numberLabel;
    }

    public TextField getNumberTF()
    {
        return numberTF;
    }

    public void setNumberTF(TextField numberTF)
    {
        this.numberTF = numberTF;
    }

    public Label getLicenseLabel()
    {
        return licenseLabel;
    }

    public void setLicenseLabel(Label licenseLabel)
    {
        this.licenseLabel = licenseLabel;
    }

    public TextField getLicenseTF()
    {
        return licenseTF;
    }

    public void setLicenseTF(TextField licenseTF)
    {
        this.licenseTF = licenseTF;
    }

    public Label getStateLabel()
    {
        return stateLabel;
    }

    public void setStateLabel(Label stateLabel)
    {
        this.stateLabel = stateLabel;
    }

    public TextField getStateTF()
    {
        return stateTF;
    }

    public void setStateTF(TextField stateTF)
    {
        this.stateTF = stateTF;
    }

    public Label getPermitLabel()
    {
        return permitLabel;
    }

    public void setPermitLabel(Label permitLabel)
    {
        this.permitLabel = permitLabel;
    }

    public TextField getPermitTF()
    {
        return permitTF;
    }

    public void setPermitTF(TextField permitTF)
    {
        this.permitTF = permitTF;
    }

    public Label getModelLabel()
    {
        return modelLabel;
    }

    public void setModelLabel(Label modelLabel)
    {
        this.modelLabel = modelLabel;
    }

    public TextField getModelTF()
    {
        return modelTF;
    }

    public void setModelTF(TextField modelTF)
    {
        this.modelTF = modelTF;
    }

    public Label getColorLabel()
    {
        return colorLabel;
    }

    public void setColorLabel(Label colorLabel)
    {
        this.colorLabel = colorLabel;
    }

    public TextField getColorTF()
    {
        return colorTF;
    }

    public void setColorTF(TextField colorTF)
    {
        this.colorTF = colorTF;
    }

    public Label getReasonLabel()
    {
        return reasonLabel;
    }

    public void setReasonLabel(Label reasonLabel)
    {
        this.reasonLabel = reasonLabel;
    }

    public Label getDateLabel()
    {
        return dateLabel;
    }

    public void setDateLabel(Label dateLabel)
    {
        this.dateLabel = dateLabel;
    }

    public TextField getDateTF()
    {
        return dateTF;
    }

    public void setDateTF(TextField dateTF)
    {
        this.dateTF = dateTF;
    }

    public Label getTimeLabel()
    {
        return timeLabel;
    }

    public void setTimeLabel(Label timeLabel)
    {
        this.timeLabel = timeLabel;
    }

    public TextField getTimeTF()
    {
        return timeTF;
    }

    public void setTimeTF(TextField timeTF)
    {
        this.timeTF = timeTF;
    }

    public Label getLocationLabel()
    {
        return locationLabel;
    }

    public void setLocationLabel(Label locationLabel)
    {
        this.locationLabel = locationLabel;
    }

    public TextField getLocationTF()
    {
        return locationTF;
    }

    public void setLocationTF(TextField locationTF)
    {
        this.locationTF = locationTF;
    }

    public Label getIssuedLabel()
    {
        return issuedLabel;
    }

    public void setIssuedLabel(Label issuedLabel)
    {
        this.issuedLabel = issuedLabel;
    }

    public TextField getIssuedTF()
    {
        return issuedTF;
    }

    public void setIssuedTF(TextField issuedTF)
    {
        this.issuedTF = issuedTF;
    }

    public Button getBtn1()
    {
        return btn1;
    }

    public void setBtn1(Button btn1)
    {
        this.btn1 = btn1;
    }

    public Button getBtn2()
    {
        return btn2;
    }

    public void setBtn2(Button btn2)
    {
        this.btn2 = btn2;
    }

    public Button getBtn3()
    {
        return btn3;
    }

    public void setBtn3(Button btn3)
    {
        this.btn3 = btn3;
    }

    public Button getBtn4()
    {
        return btn4;
    }

    public void setBtn4(Button btn4)
    {
        this.btn4 = btn4;
    }

    public Button getBtn5()
    {
        return btn5;
    }

    public void setBtn5(Button btn5)
    {
        this.btn5 = btn5;
    }

    public TextArea getPaymentTA()
    {
        return paymentTA;
    }

    public void setPaymentTA(TextArea paymentTA)
    {
        this.paymentTA = paymentTA;
    }

    public Label getFeedbackLabel()
    {
        return feedbackLabel;
    }

    public void setFeedbackLabel(Label feedbackLabel)
    {
        this.feedbackLabel = feedbackLabel;
    }

    public ComboBox getCurrentReason()
    {
        return comboBox;
        //return comboBox.getValue().toString();
    }

    public void setCurrentReason(String reason)
    {
        comboBox.setValue(reason);
    }   
}