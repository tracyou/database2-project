package nl.hva.ict.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nl.hva.ict.MainApplication;
import nl.hva.ict.models.Lodge;
import nl.hva.ict.models.Reiziger;
import nl.hva.ict.views.LodgeView;
import nl.hva.ict.views.View;

public class LodgeController extends Controller {

    private LodgeView lodgeView;
    private ObservableList<Lodge> lodges;

    public LodgeController(){
        lodgeView = new LodgeView();
        lodgeView.getLodgeViewListView().getSelectionModel().selectedItemProperty()
                .addListener(e -> getItemsInFields());
        lodgeView.getComboReistSamenMet().getSelectionModel().selectedItemProperty()
                .addListener(e -> getItemsComboBox());
        lodgeView.getBtSave().setOnAction(e-> save());
        lodgeView.getBtUpdateData().setOnAction(e-> refreshData());
        lodgeView.getBtNew().setOnAction(e-> insert());
        lodgeView.getBtDelete().setOnAction(e-> delete());
        loadData();
    }

    private void loadData(){
        //haal de waardes op uit de database
        lodges = FXCollections.observableArrayList(MainApplication.getMySQLLogdes().getAll());
        lodgeView.getLodgeViewListView().setItems(lodges);
        lodgeView.getComboReistSamenMet().getSelectionModel().select(null);
    }

    private void refreshData(){
        MainApplication.getMySQLReizigers().reload();
    }

    private void save(){
        // bewaar (update) record
    }

    private void delete(){
        // delete dit record
    }

    private void insert(){
        //Voeg toe
    }

    private void getItemsInFields(){
        Reiziger currentReiziger = lodgeView.getReizigersViewListView().getSelectionModel().getSelectedItem();
        lodgeView.getTxtReizigersCode().setText(currentReiziger.getReizigersCode());
        lodgeView.getTxtVoornaam().setText(currentReiziger.getVoornaam());
        lodgeView.getTxtAchternaam().setText(currentReiziger.getAchternaam());
        lodgeView.getTxtAdres().setText(currentReiziger.getAdres());
        lodgeView.getTxtPostcode().setText(currentReiziger.getPostcode());
        lodgeView.getTxtPlaats().setText(currentReiziger.getPlaats());
        lodgeView.getTxtLand().setText(currentReiziger.getLand());
    }

    private void getItemsComboBox(){

    }

    @Override
    public View getView() {
        return lodgeView;
    }
}
