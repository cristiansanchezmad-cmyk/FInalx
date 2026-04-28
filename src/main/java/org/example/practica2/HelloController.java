package org.example.practica2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.time.LocalDate;

public class HelloController {
    static Connection conexion;

    public TableView<Estudiante> estudiantesTableView;
    public TableColumn<Estudiante,Integer> niaTextColumn;
    public TableColumn<Estudiante, String> nombreTextColumn;
    public TableColumn<Estudiante,LocalDate> fechaTextColumn;
    public Button editarButton;
    public Button eliminarButton;
    public TextField niaTextFiel;
    public TextField nombreTextField;
    public DatePicker fechaNacimientoDatePicker;
    public Label mensajeOKLabel;
    public Button insertarButton;
    public Button guardarButton;


    @FXML
    public void initialize(){

        conexion = Datos.conexion();

        niaTextColumn.setCellValueFactory(datos->new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        nombreTextColumn.setCellValueFactory(datos->new SimpleStringProperty(datos.getValue().getNombre()));
        fechaTextColumn.setCellValueFactory(datos->new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));
        estudiantesTableView.setItems(Datos.consulta(conexion));



    }

    public void guardarButtonClick(){

        Integer nia = Integer.parseInt(niaTextFiel.getText());
        niaTextFiel.setDisable(true);
        String nombre = nombreTextField.getText();
        LocalDate fecha_nacimiento = fechaNacimientoDatePicker.getValue();
        Datos.modificar(conexion, new Estudiante(nia,nombre,fecha_nacimiento));

        insertarButton.setDisable(false);
        guardarButton.setDisable(true);
        niaTextFiel.clear();
        nombreTextField.clear();
        niaTextFiel.setDisable(false);
        fechaNacimientoDatePicker.setValue(null);
        estudiantesTableView.setItems(Datos.consulta(conexion));


    }

    public void insertarButtonClick(){

        Integer nia = Integer.parseInt(niaTextFiel.getText());
        niaTextFiel.setDisable(true);
        String nombre = nombreTextField.getText();
        LocalDate fecha_nacimiento = fechaNacimientoDatePicker.getValue();
        Datos.insertar(conexion, new Estudiante(nia,nombre,fecha_nacimiento));
        niaTextFiel.clear();
        nombreTextField.clear();
        fechaNacimientoDatePicker.setValue(null);



    }

    public void editarClickButton(){
        Estudiante seleccionado = estudiantesTableView.getSelectionModel().getSelectedItem();

        if (seleccionado == null){

            mensajeOKLabel.setText("No hay nada seleccionado");

        }else{

            insertarButton.setDisable(true);
            guardarButton.setDisable(false);
            niaTextFiel.setText(Integer.toString(seleccionado.getNia()));
            niaTextFiel.setDisable(true);
            nombreTextField.setText(seleccionado.getNombre());
            fechaNacimientoDatePicker.setValue(seleccionado.getFecha_nacimiento());

            mensajeOKLabel.setText("Estudiante editado.");

        }

        estudiantesTableView.setItems(Datos.consulta(conexion));

    }
    public void eliminarClickButton(){

        Estudiante seleccionado = estudiantesTableView.getSelectionModel().getSelectedItem();

        if (seleccionado == null){

        mensajeOKLabel.setText("No hay nada seleccionado");

        }else{

            Datos.eliminar(conexion,seleccionado);
            mensajeOKLabel.setText("Estudiante borrado.");

        }

        estudiantesTableView.setItems(Datos.consulta(conexion));

    }


}