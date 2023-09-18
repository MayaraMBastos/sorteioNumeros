$(document).ready(function () {
  $("#btnSortear").click(function () {
    var podeEnviar = true;
    var quantidade = $("#quantidade").val();
    var inicio = $("#inicio").val();
    var fim = $("#fim").val();
    var ordemCres = $("#ordemCres").is(":checked");
    var repeticao = $("#repeticao").is(":checked");

    $("#errorMessage").hide();

    var faixa = fim - inicio;
    if (quantidade >= faixa && repeticao == false) {
      $("#errorMessage").show();
      $("#errorMessage").append("A quantidade de números não pode ser maior que o limite para o sorteio sem repetição de números");
      podeEnviar = false;

    } else {
      $("#errorMessage").text("");
      podeEnviar = true;
    }

    if (podeEnviar) {
      $.ajax({
        type: "POST", // Tipo da requisição
        url: "/", // Caminho para envio da requisição
        data: {
          quantidade: quantidade,
          inicio: inicio,
          fim: fim,
          ordemCres: ordemCres,
          repeticao: repeticao,
        },
        success: function (data) {
          if (data.sucesso) {
            window.location.href = "/resultado";
          } else {
            $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
          }
        },
        error: function () {
          $("#errorMessage").append("Ops! Ocorreu um erro no servidor.");
        },
      });
    }
  });
});
