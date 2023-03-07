package Controller;

//import io.javalin.Javalin;
import Service.SneakerService;


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

    private void getAllSneakers(context ctx) throws JsonProcessingException {
        ctx.json(sneakerService.getAllSneakers());
    }

    private void getSneakersByBrand(context ctx) throws JsonProcessingException {
        ctx.json(sneakerService.getSneakersByBrand());
    }

    private void getSneakersByColor(context ctx) throws JsonProcessingException {
        ctx.json(sneakerService.getSneakersByColor());
    }

}
