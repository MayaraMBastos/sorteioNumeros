package avaliacao.sorteio.mayara.sorteioNumeros.Controller;


import avaliacao.sorteio.mayara.sorteioNumeros.Service.S_Sortear;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;

@Controller
public class C_Resultado {

    @GetMapping("/resultado")
    public String pagResultado() {
        return "/resultado";
    }


    @PostMapping("/")
    public String listaNumeros(@RequestParam("quantidade") int quantidade, @RequestParam("inicio") int inicio, @RequestParam("fim") int fim, @RequestParam(name = "ordemCres", required = false, defaultValue = "false") boolean ordemCres, @RequestParam(name = "repeticao", required = false, defaultValue = "false") boolean repeticao, Model model) {

        model.addAttribute("quantidade", quantidade);
        model.addAttribute("dataHora", new Date().toLocaleString());
        model.addAttribute("faixaNumeros", inicio + " e " + fim);

        if (repeticao == false && quantidade <= fim) {
            int[] vetorNumerosRep = S_Sortear.sortearNumerosSemRepetir(quantidade, inicio, fim, ordemCres);
            model.addAttribute("numeros", vetorNumerosRep);
            // model para mensagem de tipo de sorteio
            return "/resultado";

        } else if (repeticao == false && quantidade >= fim) {
            int[] vetorNumeros = S_Sortear.sortearNumerosRepetidos(quantidade, inicio, fim, ordemCres);
            model.addAttribute("numeros", vetorNumeros);
            return "/resultado";
        } else {
            int[] vetorNumeros = S_Sortear.sortearNumerosRepetidos(quantidade, inicio, fim, ordemCres);
            model.addAttribute("numeros", vetorNumeros);
            return "/resultado";
        }

    }

}
