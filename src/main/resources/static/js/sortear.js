$(document).ready(function () { //$('html').html(data)
  $("#btnSortear").click(function () {
    var quantidade = $("#quantidade").val();
    var inicio = $("#inicio").val();
    var fim = $("#fim").val();

    
    var ordemCres = $("#ordemCres").is(":checked");
    var repeticao = $("#repeticao").is(":checked");
    ;
  
    $.ajax({
      type: "POST", // Tipo da requisição
      url: "/", // Caminho para envio da requisição
      data: { quantidade: quantidade, inicio: inicio, fim: fim, ordemCres: ordemCres, repeticao: repeticao},
      success: function (data) {
        $("#errorMessage").text("");
        if (data.sucesso) {
          $("#resultado").text(data);
          window.location.href = "/resultado";
        } else {
          $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
        }
      },
      error: function () {
        $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
      },
    });
  });
});
