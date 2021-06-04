var mensaje = '';

function ini(){
    mensaje = '<?xml version="1.0" encoding="utf-8"?>' +
    '<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">' +
    '<Body>' +
    '<PesosDivRequest xmlns="http://www.example.org/conversor">' +
    '<a>'+ document.getElementById('importe').value +'</a>' +
    '<b>'+ document.getElementById('valor').value +'</b>' +
    '</PesosDivRequest>' +
    '</Body>' +
    '</Envelope>';
}
function pesos() {
    ini();
    axios.post('http://localhost:8080/ws/conversor', mensaje,{
        headers:{
            'Content-Type' : 'text/xml'
        }
    })
    .then(function(response){
        //console.log(response.data)
        /* Para obtener el texto */
        var combo = document.getElementById("menu");
        var selected = combo.options[combo.selectedIndex].text;
        var tipo= '';
        if(selected == "EUR - Euro"){
            tipo = 'EUR';
        }else if(selected == "JPY - Yen japonés"){
            tipo = 'JPY';
        }else if(selected == "GBP - Libra esterlina"){
            tipo = 'GBP';
        }else if(selected =="USD - Dólar estadounidense"){
            tipo = 'USD';
        }
        var valor = resultado(response.data)+'   '+tipo;
        document.getElementById('r').value = valor;
    })
    .catch(err => console.log(err));
}

function resultado(rXml){
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(rXml, "text/xml");
    var resul = xmlDoc.getElementsByTagName("ns2:resultado")[0].childNodes[0].nodeValue;
    return resul;
}