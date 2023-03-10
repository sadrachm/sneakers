package Controller;

import Model.Sneaker;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import Service.SneakerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.javalin.http.Context;


public class SneakerController {
    SneakerService sneakerService;
    public SneakerController(){
        sneakerService = new SneakerService();
    }

    public Javalin startAPI(){
        Javalin app = Javalin.create();
        app.get("/sneakers", this::getAllSneakers);
        app.get("/sneakers/{brand_name}", this::getSneakersByBrand);
        app.get("/sneakers/color/{color}", this::getSneakersByColor);
        app.post("/sneakers", this::addNewSneaker);
        app.patch("sneakers", this::updateSneaker);
        return app;
    }

    private void getAllSneakers(Context ctx) throws JsonProcessingException {
        ctx.json(sneakerService.getAllSneakers());
    }

    private void getSneakersByBrand(Context ctx) throws JsonProcessingException {
        ctx.json(sneakerService.getSneakersByBrand(ctx.pathParam("brand_name")));
    }

    private void getSneakersByColor(Context ctx) throws JsonProcessingException {
        ctx.json(sneakerService.getSneakersByColor(ctx.pathParam("color")));
    }

    private void addNewSneaker(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Sneaker sneaker = mapper.readValue(ctx.body(), Sneaker.class);
        Sneaker addedSneaker = sneakerService.addNewSneaker(sneaker);
        if(addedSneaker == null){
            ctx.status(404);
        } else {
            ctx.status(200);
        }
    }

    private void updateAmount(Context ctx) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Sneaker sneaker = mapper.readValue(ctx.body(), Sneaker.class);


    }

}
