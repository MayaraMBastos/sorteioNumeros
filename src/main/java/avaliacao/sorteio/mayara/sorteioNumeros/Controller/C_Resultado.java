package avaliacao.sorteio.mayara.sorteioNumeros.Controller;


import avaliacao.sorteio.mayara.sorteioNumeros.Service.S_Sortear;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class C_Resultado {

    @GetMapping("/resultado") // tirar o get para aparecer so quando clica no botao
    public String pagResultado() {
        return "/resultado.html";
    }


    @PostMapping("/")
    public String listaNumeros(@RequestParam("quantidade") int quantidade, @RequestParam("inicio") int inicio, @RequestParam("fim") int fim, @RequestParam(name = "ordemCres", required = false, defaultValue = "false") boolean ordemCres, @RequestParam(name = "repeticao", required = false, defaultValue = "false") boolean repeticao, Model model) {

        if (repeticao == false) {
            int[] vetorNumerosRep = S_Sortear.sortearNumerosSemRepetir(quantidade, inicio, fim, ordemCres);
            model.addAttribute("numeros", vetorNumerosRep);
            model.addAttribute("quantidade", quantidade);
            model.addAttribute("dataHora", new Date().toLocaleString());
            return "/resultado";
        } else {
            int[] vetorNumeros = S_Sortear.sortearNumeros(quantidade, inicio, fim, ordemCres);
            model.addAttribute("numeros", vetorNumeros);
            return "/resultado";
        }

    }

}
