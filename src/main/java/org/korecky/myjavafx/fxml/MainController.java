package org.korecky.myjavafx.fxml;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.korecky.myjavafx.*;

public class MainController implements Initializable {

    @FXML
    private TextField txttitle;
    @FXML
    private TextField txtauthor;
    @FXML
    private TextField txtgenre;
    @FXML
    private TextField txtpublisher;
    @FXML
    private TextField txtnumber;
    @FXML
    private ComboBox cmbyear;
    @FXML
    private ComboBox cmbmonth;
    @FXML
    private Button btnregistrar;
    @FXML
    private Button btnregedicion;
    @FXML
    private Button btnactualizar;
    @FXML
    private TableView<Revista> tblvw;
    @FXML
    private TableColumn<Revista,String> titlecolumn;
    @FXML
    private TableColumn<Revista,String> authorcolumn;
    @FXML
    private TableColumn<Revista,String> genrecolumn;
    @FXML
    private TableColumn<Revista,String> publishercolumn;
    @FXML
    private TableColumn<Edicion,ObservableList> numbercolumn;
   // @FXML
   // private TableColumn<Edicion,Integer> yearcolumn;
   // @FXML
   // private TableColumn<Edicion,String> monthcolumn;
    @FXML
    private ComboBox cmbyeara;
    @FXML
    private ComboBox cmbmontha;
    @FXML
    private Button btnliterala;
    @FXML
    private TableView<Revista> tblvwa;
    @FXML
    private TableColumn<Revista,String> titleacolumn;
    @FXML
    private TableColumn<Revista,String> authoracolumn;
    @FXML
    private TableColumn<Revista,String> genreacolumn;
    @FXML
    private TableColumn<Revista,String> publisheracolumn;
    @FXML
    private TableColumn<Edicion,ObservableList> numberacolumn;
    //@FXML
    //private TableColumn<Edicion,Integer> yearacolumn;
    //@FXML
    //private TableColumn<Edicion,String> monthacolumn;
    @FXML
    private ComboBox cmbyearb;
    @FXML
    private TableView<String> tblvwb;
    @FXML
    private TableColumn<String,String> monthbcolumn;
    @FXML
    private Button btnliteralb;
    @FXML
    private ComboBox cmbyearc;
    @FXML
    private Button btnliteralc;
    @FXML
    private TextArea txtliteralc;
    @FXML
    private Button btnliterald;
    @FXML
    private TextArea txtliterald;
    @FXML
    private ComboBox cmbyeare;
    @FXML
    private Button btnliterale;
    @FXML
    private TableView<Revistasolo> tblvwe;
    @FXML
    private TableColumn<Revistasolo,String> titleecolumn;
    @FXML
    private TableColumn<Revistasolo,String> authorecolumn;
    @FXML
    private TableColumn<Revistasolo,String> genreecolumn;
    @FXML
    private TableColumn<Revistasolo,String> publisherecolumn;
    @FXML
    private TableColumn<Revistasolo,Integer> numberecolumn;
    @FXML
    private TableColumn<Revistasolo,Integer> yearecolumn;
    @FXML
    private TableColumn<Revistasolo,String> monthecolumn;





    ObservableList<Revista> revistalist = FXCollections.observableArrayList();
    ObservableList<Integer> yearlist = FXCollections.observableArrayList(2010,2011,2012,2013,2014,2015,2016,2017,2018);
    ObservableList<String> monthlist = FXCollections.observableArrayList("January","February","March","April","May","June","July","August","September","October","November","December");
    ObservableList<Revista> literala = FXCollections.observableArrayList();
    ObservableList<String> literalb = FXCollections.observableArrayList();
    ObservableList<Revista> literalc = FXCollections.observableArrayList();
    ObservableList<Revista> literald = FXCollections.observableArrayList();
    ObservableList<Revistasolo> literale = FXCollections.observableArrayList();
    ObservableList<Edicion> ediciongene = FXCollections.observableArrayList();

    // Handler for Button[id="btnHello"] onAction
    //public void btnHelloOnAction(ActionEvent event) {
        //lblHello.setText("Hello");}

    public void registraredicion() {

        Edicion edc = new Edicion(Integer.parseInt(txtnumber.getText()),Integer.parseInt(cmbyear.getSelectionModel().getSelectedItem().toString()),cmbmonth.getSelectionModel().getSelectedItem().toString());
        ediciongene.add(edc);
        cmbyear.setPromptText("");
        cmbmonth.setPromptText("");

    }




    public void registrarrevista() {
        if (validateField()) {

            Comparator<Edicion> comparator = Comparator.comparingInt(Edicion::getNumero);
            FXCollections.sort(ediciongene, comparator);
            Revista revista = new Revista(txttitle.getText(),txtauthor.getText(),txtgenre.getText(),txtpublisher.getText(),ediciongene);
            revistalist.add(revista);
            System.out.println(revistalist.toString());
            ediciongene.removeAll();
            txttitle.clear();
            txtpublisher.clear();
            txtgenre.clear();
            txtnumber.clear();
            txtauthor.clear();

        }

    }

    public void actualizarrevistas(){

        tblvw.setItems(revistalist);

    }
//________________________________________________________literal a_____________________________________________________
    public void fliterala(){
        literala.clear();
        for (int i = 0; i < revistalist.size(); i++) {
            for (int k = 0; k < revistalist.get(i).getEdicion().size(); k++) {

                if (revistalist.get(i).getEdicion().get(k).getMes() == cmbmontha.getSelectionModel().getSelectedItem().toString() && revistalist.get(i).getEdicion().get(k).getAno() == Integer.parseInt(cmbyeara.getSelectionModel().getSelectedItem().toString())) {
                    literala.add(revistalist.get(i));
                }
            }
        }

        tblvwa.setItems(literala);
    }
    //________________________________________________________literal b_____________________________________________________
    public void fliteralb(){
        literalb.clear();
        literalb.addAll(monthlist);
        for (int i = 0; i < revistalist.size(); i++) {
            for (int k = 0; k < revistalist.get(i).getEdicion().size(); k++) {
                if (revistalist.get(i).getEdicion().get(k).getAno() == Integer.parseInt(cmbyearb.getSelectionModel().getSelectedItem().toString())) {
                    for (int j = 0; j < literalb.size(); j++) {
                        if (literalb.get(j) == revistalist.get(i).getEdicion().get(k).getMes()) {
                            literalb.remove(j);
                        }
                    }

                }
               // System.out.println("lista resvistas " + i + revistalist.get(i).getEdicion().get(k).getMes());
            }
        }

        tblvwb.setItems(literalb);
    }
    //________________________________________________________literal c_____________________________________________________
    public void fliteralc(){
        double primTrim=0;
        double segTrim=0;
        double terTrim=0;
        double cuartTrim=0;

        for (int i = 0; i < revistalist.size(); i++) {
            for (int j=0;j < revistalist.get(i).getEdicion().size();j++) {
            if (revistalist.get(i).getEdicion().get(j).getAno() == Integer.parseInt(cmbyearc.getSelectionModel().getSelectedItem().toString())) {

                    if (revistalist.get(i).getEdicion().get(j).getMes() == "January" || revistalist.get(i).getEdicion().get(j).getMes() == "February" || revistalist.get(i).getEdicion().get(j).getMes() == "March") {
                        primTrim++;
                    }
                    if (revistalist.get(i).getEdicion().get(j).getMes() == "April" || revistalist.get(i).getEdicion().get(j).getMes() == "May" || revistalist.get(i).getEdicion().get(j).getMes() == "June") {
                        segTrim++;
                    }
                    if (revistalist.get(i).getEdicion().get(j).getMes() == "July" || revistalist.get(i).getEdicion().get(j).getMes() == "August" || revistalist.get(i).getEdicion().get(j).getMes() == "September") {
                        terTrim++;
                    }
                    if (revistalist.get(i).getEdicion().get(j).getMes() == "October" || revistalist.get(i).getEdicion().get(j).getMes() == "November" || revistalist.get(i).getEdicion().get(j).getMes() == "December") {
                        cuartTrim++;
                    }
                }
            }
        }

            txtliteralc.appendText("Promedio de Revistas Recibidas en el ano de " + cmbyearc.getSelectionModel().getSelectedItem().toString()+ "\n"+
                                    "Primer Trimestre = " + primTrim/3 + "\n"+
                                    "Segundo Trimestre = " + segTrim/3 + "\n"+
                                    "Tercer Trimestre = " + terTrim/3 + "\n"+
                                    "Cuarto Trimestre = " + cuartTrim/3 + "\n"+"\n");

    }

    //________________________________________________________literal d_____________________________________________________
    public void fliterald(){
        int indice = 0;
        int mayor = 0;
        ObservableList<Revista> revistamayor = FXCollections.observableArrayList();


        for (int i = 0; i < revistalist.size(); i++) {
            if (revistalist.get(i).getEdicion().size() > mayor)
            {
                mayor += revistalist.get(i).getEdicion().size();
                indice = i;
            }
        }
        //revistamayor.add(revistalist.get(indice));
        for (int i = 0; i < revistalist.size(); i++) {
            if (revistalist.get(i).getEdicion().size() == mayor)
            {
                revistamayor.add(revistalist.get(i));
            }
        }

            txtliterald.setText("La/Las Revistas mas completas del ano: " +"\n" + "\n" );
        for (int i = 0; i < revistamayor.size(); i++) {
            txtliterald.appendText(revistamayor.get(i).toString());
        }


            System.out.println(revistamayor.toString());

    }
    //________________________________________________________literal e_____________________________________________________
    public void fliterale(){
    literale.clear();
        for (int i = 0; i < revistalist.size(); i++) {
            for (int k = 0; k < revistalist.get(i).getEdicion().size(); k++) {
                if (revistalist.get(i).getEdicion().get(k).getAno() == Integer.parseInt(cmbyeare.getSelectionModel().getSelectedItem().toString())) {
                    Revistasolo rvs = new Revistasolo(revistalist.get(i).getTitle(),revistalist.get(i).getAuthor(),revistalist.get(i).getGenre(),revistalist.get(i).getPublisher(),revistalist.get(i).getEdicion().get(k).getNumero(),revistalist.get(i).getEdicion().get(k).getAno(),revistalist.get(i).getEdicion().get(k).getMes());
                    literale.add(rvs);
                }
            }
        }

        tblvwe.setItems(literale);
    }

    public void checkletter()
    {
        txtauthor.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                txtauthor.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });

        txtgenre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                txtgenre.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });

        txtpublisher.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                txtpublisher.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });

    }

    public void checknumber()
    {
        txtnumber.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtnumber.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

    }







    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkletter();
        checknumber();

        ObservableList<Edicion> lrevista1 = FXCollections.observableArrayList(new Edicion(1,2010,"January"),new Edicion(2,2011,"February"),new Edicion(3,2010,"March"));
        ObservableList<Edicion> lrevista2 = FXCollections.observableArrayList(new Edicion(4,2011,"February"));
        ObservableList<Edicion> lrevista3 = FXCollections.observableArrayList(new Edicion(5,2010,"March"));
        ObservableList<Edicion> lrevista4 = FXCollections.observableArrayList(new Edicion(8,2010,"December"));
        ObservableList<Edicion> lrevista5 = FXCollections.observableArrayList(new Edicion(9,2010,"February"),new Edicion(2,2010,"March"),new Edicion(3,2011,"January"));

        Comparator<Edicion> comparator = Comparator.comparingInt(Edicion::getNumero);
        FXCollections.sort(lrevista5, comparator);

        Revista revista = new Revista("Title","Author","Genre","Publisher",lrevista1);
        Revista revista2 = new Revista("Title2","Author","Genre","Publisher",lrevista2);
        Revista revista3 = new Revista("Title3","Author","Genre","Publisher",lrevista3);
        Revista revista4 = new Revista("Title4","Author","Genre","Publisher",lrevista4);
        Revista revista5 = new Revista("Title5","Author","Genre","Publisher",lrevista5);

        revistalist.add(revista);
        revistalist.add(revista2);
        revistalist.add(revista3);
        revistalist.add(revista4);
        revistalist.add(revista5);


//________________________________________________________lista principal_______________________________________________

        cmbyear.setItems(yearlist);
        cmbmonth.setItems(monthlist);
        titlecolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Title"));
        authorcolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Author"));
        genrecolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Genre"));
        publishercolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Publisher"));
        numbercolumn.setCellValueFactory(new PropertyValueFactory<Edicion, ObservableList>("edicion"));
        //yearcolumn.setCellValueFactory(new PropertyValueFactory<Edicion, Integer>("ano"));
        //monthcolumn.setCellValueFactory(new PropertyValueFactory<Edicion, String>("mes"));
        tblvw.setItems(revistalist);

//________________________________________________________lista literal a_______________________________________________


        cmbyeara.setItems(yearlist);
        cmbmontha.setItems(monthlist);
        titleacolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Title"));
        authoracolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Author"));
        genreacolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Genre"));
        publisheracolumn.setCellValueFactory(new PropertyValueFactory<Revista, String>("Publisher"));
        numberacolumn.setCellValueFactory(new PropertyValueFactory<Edicion, ObservableList>("edicion"));
        //yearacolumn.setCellValueFactory(new PropertyValueFactory<Edicion, Integer>("ano"));
        //monthacolumn.setCellValueFactory(new PropertyValueFactory<Edicion, String>("mes"));
//________________________________________________________lista literal b_______________________________________________


        cmbyearb.setItems(yearlist);
        //monthbcolumn.setCellValueFactory(new PropertyValueFactory<String, String>("mes"));
        monthbcolumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));

        //________________________________________________________lista literal e_______________________________________________


        cmbyeare.setItems(yearlist);
        titleecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, String>("Title"));
        authorecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, String>("Author"));
        genreecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, String>("Genre"));
        publisherecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, String>("Publisher"));
        numberecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, Integer>("numero"));
        yearecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, Integer>("ano"));
        monthecolumn.setCellValueFactory(new PropertyValueFactory<Revistasolo, String>("mes"));





        cmbyearc.setItems(yearlist);


        btnregistrar.setOnAction((event) -> {
            registrarrevista();
        });
        btnregedicion.setOnAction((event) -> {
            registraredicion();
        });

        btnactualizar.setOnAction((event) -> {
            actualizarrevistas();
        });
        btnliterala.setOnAction((event) -> {
            fliterala();
        });
        btnliteralb.setOnAction((event) -> {
            fliteralb();
        });
        btnliteralc.setOnAction((event) -> {
            fliteralc();
        });
        btnliterald.setOnAction((event) -> {
            fliterald();
        });
        btnliterale.setOnAction((event) -> {
            fliterale();
        });
    }


    private boolean validateField()
    {
        if(txtauthor.getText().isEmpty()||txtgenre.getText().isEmpty()||txtpublisher.getText().isEmpty()||txttitle.getText().isEmpty() || ediciongene.size()==0 || txtnumber.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Existen datos en blanco cuando se intento crear una Revista Nueva");
            alert.showAndWait();
            return false;
        }
        return true;
    }



}
