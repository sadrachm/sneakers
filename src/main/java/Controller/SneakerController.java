package Controller;

//import io.javalin.Javalin;
import Service.SneakerService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.javalin.http.Context;


public class SneakerController {
    SneakerService sneakerService;
    public SneakerController(){
        sneakerService = new SneakerService();
    }

    public Javalin StartAPI(){
        Javalin app = Javalin.create();
        app.get("/sneakers", this::getAllSneakers);
        app.get("/sneakers/{brand_name}", this::getSneakersByBrand);
        app.get("/sneakers/color/{color}", this::getSneakersByColor);
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

}
