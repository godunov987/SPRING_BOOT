package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.servise.CarServiseImpl;


@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarServiseImpl carServise;

    public CarController(CarServiseImpl carServise) {
        this.carServise = carServise;
    }

    @GetMapping
    public String index(Model model,
                        @RequestParam(value = "count", required = false) Integer count) {
        model.addAttribute("cars", carServise.getCarList(count));
        return "/cars";
    }


}
