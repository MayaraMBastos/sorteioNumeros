package avaliacao.sorteio.mayara.sorteioNumeros.Controller;


import avaliacao.sorteio.mayara.sorteioNumeros.Service.S_Sortear;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Resultado {

    @GetMapping("/resultado") // tirar o get para aparecer so quando clica no botao
    public String pagResultado() {
        return "/resultado.html";
    }


    @PostMapping("/")
    public String listaNumeros(@RequestParam("quantidade") int quantidade, @RequestParam("inicio") int inicio, @RequestParam("fim") int fim, @RequestParam("ordemCres") boolean ordemCres, @RequestParam("repeticao") boolean repeticao, Model model) {

        if (repeticao == true) { // enviar os booleans como parametros para o service
            int[] vetorNumeros = S_Sortear.sortearNumeros(quantidade, inicio, fim);
            model.addAttribute("numeros", vetorNumeros);
        } else {
            int[] vetorNumerosRep = S_Sortear.sortearNumerosSemRepetir(quantidade,inicio, fim);
            model.addAttribute("numeros", vetorNumerosRep);
        }
        return "/resultado";
    }

}
