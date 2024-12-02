package com.letseat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecomendacionController {
    
    @RequestMapping("/recomendaciones")
    
    public String paginaNostros(Model model){
        return "recomendaciones";
    }
    
}
