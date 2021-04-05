function valida(campo) {
  var nomeServico = form.nomeServico.value,
      valorHoraServico = form.valorHoraServico.value;

  if (campo == "nomeServico") {
    if (nomeServico.length == " ") {
      form.nomeServico.style.border = "2px solid red";

    } else {
      form.nomeServico.style.border = "2px solid green";
    }
  }

  if (campo == "valorHoraServico") {
    if (valorHoraServico.length == " " ) {
      form.valorHoraServico.style.border = "2px solid red";

    } else {
      form.valorHoraServico.style.border = "2px solid green";
    }
  }
};