var mensaje = '';

function ini(){
    mensaje = '<?xml version="1.0" encoding="utf-8"?>' +
    '<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">' +
    '<Body>' +
    '<PesosMulRequest xmlns="http://www.example.org/conversor">' +
    '<a>'+ document.getElementById('importe2').value +'</a>' +
    '<b>'+ document.getElementById('valor2').value +'</b>' +
    '</PesosMulRequest>' +
    '</Body>' +
    '</Envelope>';
}
function moneda() {
    ini();
    axios.post('http://localhost:8080/ws/conversor', mensaje,{
        headers:{
            'Content-Type' : 'text/xml'
        }
    })
    .then(function(response){
        var valor = resultado(response.data)+'    MXN';
        document.getElementById('r2').value = valor;
    })
    .catch(err => console.log(err));
}

function resultado(rXml){
    var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(rXml, "text/xml");
    var resul = xmlDoc.getElementsByTagName("ns2:resultado")[0].childNodes[0].nodeValue;
    return resul;
}