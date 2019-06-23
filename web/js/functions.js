var agregarCampo = function()
{
	var respuestas = document.getElementsByClassName("respuestas");
	var longitud=respuestas.length+1;
	var linea="<tr class=\"row respuestas\"><td class=\"id\">"+longitud+"</td><td class=\"ans\"><input type=\"text\" class=\"respuesta\" name=\"respuesta"+longitud+"\"></td><td class=\"val\"><input type=\"number\" step=\"any\" class=\"valor\" name=\"valor"+longitud+"\"></td><td class=\"val\"><input type=\"number\" step=\"any\" class=\"valor\" name=\"nega"+longitud+"\"></td></tr>";

	respuestas[respuestas.length-1].insertAdjacentHTML("afterend",linea);
};
