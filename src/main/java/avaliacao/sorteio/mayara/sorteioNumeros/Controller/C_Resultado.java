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
    public String listaNumeros(@RequestParam("quantidade") Integer quantidade, @RequestParam("inicio") Integer inicio, @RequestParam("fim") Integer fim, Model model) {

        //retornar vetor
        Integer[] vetorNumeros = S_Sortear.sortearNumeros(quantidade, inicio, fim);
        model.addAttribute("numeros", vetorNumeros);

        return "/resultado";
    }

}
