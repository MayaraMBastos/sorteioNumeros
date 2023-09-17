$(document).ready(function () {
  $("#btnSortear").click(function () {
    var podeEnviar = true;
    var quantidade = $("#quantidade").val();
    var inicio = $("#inicio").val();
    var fim = $("#fim").val();
    var ordemCres = $("#ordemCres").is(":checked");
    var repeticao = $("#repeticao").is(":checked");

    if (quantidade >= fim) {
    $("#errorMessage").text("");
      $("#errorMessage").append(
        "A quantida não pode ser maior que o fim para o sorteio sem repetiçao de numeros"
      );
      podeEnviar = false;
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
          $("#errorMessage").text("");
          if (data.sucesso) {
            window.location.href = "/resultado";
          } else {
            $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
          }
        },
        error: function () {
          $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
        },
      });
    } //
  });
});
