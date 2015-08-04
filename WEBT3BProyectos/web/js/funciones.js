/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargaPagina(url, contenedor){
    $("#"+contenedor).load(url);
}

function muestraDivMenuPrin(contenedor, hijo){
    var hijos = document.getElementById(contenedor).childNodes;
    var tam = hijos.length;
    for(var i =0; i<tam; i++){
        var elem = hijos[i];
        if(elem.nodeType===1){
            document.getElementById(elem.id).style.visibility = hijo===elem.id?"visible":"hidden";
            document.getElementById(elem.id).style.height = hijo===elem.id?"auto":"0px";
        }
    }
}