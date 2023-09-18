$(document).ready(function () {
  $("#btnSortear").click(function () {
    var podeEnviar = true;
    var quantidade = $("#quantidade").val();
    var inicio = $("#inicio").val();
    var fim = $("#fim").val();
    var ordemCres = $("#ordemCres").is(":checked");
    var repeticao = $("#repeticao").is(":checked");

    $("#errorMessage").text("");

    if (quantidade >= fim) {
      $("#errorMessage").append(
        "A quantidade de números não pode ser maior que o limite para o sorteio sem repetição de números"
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
          if (data.sucesso) {
          $("#errorMessage").text("");
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
