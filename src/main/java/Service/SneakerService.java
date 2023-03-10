package Service;

import DAO.SneakerDAO;
import Model.Sneaker;

import java.util.List;

public class SneakerService {
    SneakerDAO sneakerDAO;

    public SneakerService() {
        sneakerDAO = new SneakerDAO();
    }
    public List<Sneaker> getAllSneakers() {
        return sneakerDAO.getAllSneakers();
    }
    public List<Sneaker> getSneakersByBrand(String brand) {
        return sneakerDAO.getSneakersByBrand(brand);
    }
    public List<Sneaker> getSneakersByColor(String color) {
        return sneakerDAO.getSneakersByColor(color);
    }

    public Sneaker addNewSneaker(Sneaker sneaker) {
        return sneakerDAO.addNewSneaker(sneaker);
    }

    public void deleteSneaker(String name) {
        sneakerDAO.deleteSneaker(name);
    }

}
