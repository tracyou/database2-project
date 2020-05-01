package nl.hva.ict.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nl.hva.ict.MainApplication;
import nl.hva.ict.models.Hotel;
import nl.hva.ict.models.Lodge;
import nl.hva.ict.views.HotelView;
import nl.hva.ict.views.LodgeView;
import nl.hva.ict.views.View;

public class HotelController extends Controller {

    private HotelView hotelView;
    private ObservableList<Hotel> hotels;

    public HotelController(){
        hotelView = new HotelView();
        hotelView.getHotelsViewListView().getSelectionModel().selectedItemProperty()
                .addListener(e -> getItemsInFields());
        hotelView.getBtSave().setOnAction(e-> save());
        hotelView.getBtUpdateData().setOnAction(e-> refreshData());
        hotelView.getBtNew().setOnAction(e-> insert());
        hotelView.getBtDelete().setOnAction(e-> delete());
        loadData();
    }

    private void loadData() {
        hotels = FXCollections.observableArrayList(MainApplication.getMySQLHotels().getAll());
        hotelView.getHotelsViewListView().setItems(hotels);
    }

    private void refreshData(){
        MainApplication.getMySQLHotels().reload();
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
        Hotel currentHotel = hotelView.getHotelsViewListView().getSelectionModel().getSelectedItem();
        hotelView.getTxtAccommodatieCode().setText(currentHotel.getAccommodatieCode());
        hotelView.getTxtNaam().setText(currentHotel.getNaam());
        hotelView.getTxtStad().setText(currentHotel.getStad());
        hotelView.getTxtKamertype().setText(currentHotel.getKamer());
        hotelView.getTxtPrijsPerNacht().setText(currentHotel.getPrijsPerNacht());
        hotelView.getTxtAantalPersonen().setText(currentHotel.getPersonen());
        hotelView.getCheckOntbijt().setText(currentHotel.getOntbijt());
    }

    @Override
    public View getView() {
        return null;
    }
}
