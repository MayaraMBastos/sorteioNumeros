package avaliacao.sorteio.mayara.sorteioNumeros.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {

    @GetMapping("/")
    public String pagHome() {
        return "/index";
    }
}
