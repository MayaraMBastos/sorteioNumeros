package avaliacao.sorteio.mayara.sorteioNumeros.Controller;

import avaliacao.sorteio.mayara.sorteioNumeros.Service.S_Sortear;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class C_Resultado {

    @GetMapping("/resultado")
    public String pagResultado() {
        return "/resultado";
    }

    @PostMapping("/")
    public String listaNumeros(@RequestParam("quantidade") int quantidade,
            @RequestParam("inicio") int inicio,
            @RequestParam("fim") int fim,
            @RequestParam(name = "ordemCres", required = false, defaultValue = "false") boolean ordemCres,
            @RequestParam(name = "repeticao", required = false, defaultValue = "false") boolean repeticao,
            Model model, RedirectAttributes redirectAttributes, HttpSession session) {

        int[] vResultado = S_Sortear.sortearNumeros(quantidade, inicio, fim, ordemCres, repeticao);
        model.addAttribute("numeros", vResultado);
        model.addAttribute("quantidade", quantidade);
        model.addAttribute("dataHora", new Date().toLocaleString());
        model.addAttribute("faixaNumeros", inicio + " e " + fim);
        return "/resultado";

    }

}
