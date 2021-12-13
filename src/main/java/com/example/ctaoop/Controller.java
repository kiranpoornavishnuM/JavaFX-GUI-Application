package com.example.ctaoop;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;


public class Controller {
    int s = 0, a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
    @FXML
    private TextField nameField, usnField, courseField, codeField, ctaField, ia1Field, ia2Field, ia3Field;
    @FXML
     private Label print, courseCodeLabel, gradeLabel, courseNameLabel, ctaLabel, ia1Label, ia2Label,
            ia3Label, best2, totalMarkLabel, reportDetails;
    @FXML
    private PieChart chart;
    @FXML
    private ComboBox acdYear, department;

    @FXML
    public void initialize(){
        acdYear.getItems().add("2017-2018");
        acdYear.getItems().add("2018-2019");
        acdYear.getItems().add("2019-2020");
        acdYear.getItems().add("2020-2021");
        acdYear.getItems().add("2021-2022");
        department.getItems().add("Computer Science And Engineering");
        department.getItems().add("Information Science And Engineering");
        department.getItems().add("Electronics And Communications Engineering");
        department.getItems().add("Electrical And Electronic Engineering");
        department.getItems().add("Mechanical Engineering");


    }

    @FXML
    public void onAddStudent(){
        String studentName = nameField.getText();
        String studentUsn = usnField.getText();


        if(studentName.isEmpty()){
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setTitle("Error");
            a1.setHeaderText("Name field cannot be empty");
            a1.setContentText("Please enter the Student's name");
            a1.showAndWait();
        }
        if(studentUsn.isEmpty()){
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setTitle("Error");
            a1.setHeaderText("USN field cannot be empty");
            a1.setContentText("Please enter the Student's USN");
            a1.showAndWait();
        }
        if(studentName.length() > 0 && studentUsn.length() > 0) {
            print.setText(studentName + " Added!");
        }
    }

    @FXML
    public void  onCalculate(){
        String StdDetailStatus = print.getText();
        if(StdDetailStatus.isEmpty()){
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setTitle("Error");
            a1.setHeaderText("CIE cannot be calculated without adding the Student Details");
            a1.setContentText("Please complete the Student Detail form");
            a1.showAndWait();
        }
        else {
            String courseName = courseField.getText();
            courseNameLabel.setText(courseName);

            String courseCode = codeField.getText();
            courseCodeLabel.setText(courseCode);

            String cta = ctaField.getText();
            ctaLabel.setText(cta);

            String ia1 = ia1Field.getText();
            ia1Label.setText(ia1);

            String ia2 = ia2Field.getText();
            ia2Label.setText(ia2);

            String ia3 = ia3Field.getText();
            ia3Label.setText(ia3);

            double ia1Mark = Double.parseDouble(ia1);
            double ia2Mark = Double.parseDouble(ia2);
            double ia3Mark = Double.parseDouble(ia3);
            double ctaMark = Double.parseDouble(cta);


            double max = Math.max(ia3Mark, (Math.max(ia1Mark, ia2Mark)));
            double max2 = ia1Mark+ia2Mark+ia3Mark-max-Math.min(ia3Mark, (Math.min(ia1Mark, ia2Mark)));
            String TotalIaMark = String.valueOf(max+max2);
            best2.setText(TotalIaMark);
            double total = max + max2;
            //Total CIE Mark
            double TotalCie = total+ctaMark;
            if(TotalCie > 50){
                Alert a1 = new Alert(Alert.AlertType.ERROR);
                a1.setTitle("Error");
                a1.setHeaderText("Invalid Marks entered");
                a1.setContentText("Please enter the Correct Marks. CIE cannot be greater than 50");
                a1.showAndWait();
                courseNameLabel.setText("0");
                courseCodeLabel.setText("0");
                ctaLabel.setText("0");
                ia1Label.setText("0");
                ia2Label.setText("0");
                ia3Label.setText("0");
                best2.setText("0");
                totalMarkLabel.setText("");
                gradeLabel.setText("");


            }
            else {

                totalMarkLabel.setText(String.valueOf(TotalCie));

                if (TotalCie >= 45 && TotalCie <= 50) {
                    s++;
                    gradeLabel.setText("S");
                } else if (TotalCie >= 37.5 && TotalCie < 45) {
                    gradeLabel.setText("A");
                    a++;
                } else if (TotalCie >= 30 && TotalCie < 37.5) {
                    gradeLabel.setText("B");
                    b++;
                } else if (TotalCie >= 25 && TotalCie < 30) {
                    gradeLabel.setText("C");
                    c++;
                } else if (TotalCie >= 22.5 && TotalCie < 25) {
                    gradeLabel.setText("D");
                    d++;
                } else if (TotalCie >= 20 && TotalCie < 22.5) {
                    gradeLabel.setText("E");
                    e++;
                } else {
                    gradeLabel.setText("F");
                    f++;
                }
            }
        }
    }
    @FXML
    public void onNewSubject(){
        courseField.setText("");
        codeField.setText("");
        ctaField.setText("");
        ia1Field.setText("");
        ia2Field.setText("");
        ia3Field.setText("");
        totalMarkLabel.setText("");
        gradeLabel.setText("");
        courseNameLabel.setText("");
        courseCodeLabel.setText("");
        ia1Label.setText("");
        ia2Label.setText("");
        ia3Label.setText("");
        best2.setText("");
        ctaLabel.setText("");

    }
    @FXML
    public void onGenerate(){
        String mark = gradeLabel.getText();
        if(mark.length() > 0){
            PieChart.Data sliceS = new PieChart.Data(s + " - S Grade ||", s);
            PieChart.Data sliceA = new PieChart.Data(a + " - A Grade ||", a);
            PieChart.Data sliceB = new PieChart.Data(b + " - B Grade ||", b);
            PieChart.Data sliceC = new PieChart.Data(c + " - C Grade ||", c);
            PieChart.Data sliceD = new PieChart.Data(d + " - D Grade ||", d);
            PieChart.Data sliceE = new PieChart.Data(e + " - E Grade ||", e);
            PieChart.Data sliceF = new PieChart.Data(f + " - F Grade ||", f);
            chart.getData().add(sliceS);
            chart.getData().add(sliceA);
            chart.getData().add(sliceB);
            chart.getData().add(sliceC);
            chart.getData().add(sliceD);
            chart.getData().add(sliceE);
            chart.getData().add(sliceF);

            String studentName = nameField.getText();
            String usn = usnField.getText();

            reportDetails.setText("\n Name : " + studentName +
                    "\n USN : " + usn +
                    "\n Number of S grade's : "+s);
            if(s>0){
                Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                a1.setTitle("Congratulations");
                a1.setContentText("Well done! you've got "+s+" S Grade");
                a1.showAndWait();
            }
            if(f>0){
                Alert a1 = new Alert(Alert.AlertType.INFORMATION);
                a1.setTitle("Better Luck next Time");
                a1.setContentText("You've got "+f+" F Grade. Prepare Well for your next Exam");
                a1.showAndWait();
            }

        }
        else {
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setTitle("Error");
            a1.setHeaderText("Subject Marks not entered");
            a1.setContentText("Please Enter the Subject Details ");
            a1.showAndWait();
        }
    }

}