var valor1 = document.getElementById("a").value;
var valor2 = document.getElementById("b").value;
var mensaje = '<?xml version="1.0" encoding="utf-8"?>' +
    '<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">' +
    '<Body>' +
    '<SumarRequest xmlns="http://www.example.org/calculadora">' +
    '<a>valor1</a>' +
    '<b>valor2</b>' +
    '</SumarRequest>' +
    '</Body>' +
    '</Envelope>';

function soap() {
    // alert('hola')
    axios.post('http://localhost:8081/ws/calculadora', mensaje,{
        headers:{
            'Content-Type' : 'text/xml'
        }
    })
    .then(response => console.log(response.data))
    .catch(err => console.log(err));
}