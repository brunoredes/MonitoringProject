﻿function getRandom() {
    return Math.floor(Math.random() * 100);
}

setInterval(() => {//30 seg


       pegarLaboratoriosQueMaisConsomem();

}, 5000);

setInterval(() => {//30 seg


//    pegarLaboratoriosQueMaisConsomem();
    pegarQuantidadeDeLaboratorios();

}, 5000);

setInterval(() => {//30 seg
    
    
    pegarConsumoDownloadUploadLaboratorios();


},5000);

setInterval(() => {//30 seg

    pegarProcessosQueMaisConsumemHardware();
    
    

}, 5000);

setInterval(() => {
    pegarProcessosQueMaisConsumemInternet();

}, 5000);

setInterval(() => {
    
    pegarMediaPorcetagemUsoComputador();

    console.log("internet");
},5000);

setInterval(() => {//um minuto
    console.log("aqui tiowww");
    pegarConsumoDownloadLaboratorios();
}, 5000);

setInterval(() => {//dez minutos
    //  pegarQuantidadeDeLaboratorios($("#txtQuantidadeLaboratorio"), idUsuarioLogado);
}, 100000);


