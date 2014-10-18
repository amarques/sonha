
function valida(form) {

	//Valida username

	if (form.user.value=="") {
	document.getElementById("user").style.display="inline"; 
	form.user.style.backgroundColor="#767bff";
    form.user.style.color="#ffffff";
	form.user.focus();
	return false;
}

	//Valida senha 

	if (form.senha.value=="" || form.senha.value.length < 4) {
	document.getElementById("senha").style.display="inline"; 
	form.senha.style.backgroundColor="#767bff";
    form.senha.style.color="#ffffff";
	form.senha.focus();
	return false;

}

	//Valida se o campo de confirmação de senha está correto

	if (form.conf_senha.value=="" || form.conf_senha.value.length < 4) {
	document.getElementById("conf_senha").style.display="inline"; 
	form.conf_senha.style.backgroundColor="#767bff";
    form.conf_senha.style.color="#ffffff";
	form.conf_senha.focus();
	return false;
}

// Valida se as senhas conferem

	if (form.senha.value!=form.conf_senha.value) {
	document.getElementById("valida_senha").style.display="inline"; 
	form.conf_senha.style.backgroundColor="#767bff";
    form.conf_senha.style.color="#ffffff";
	form.conf_senha.focus();
	return false;
}

  if (form.sexo[0].checked == false 
    && form.sexo[1].checked == false) {
   	alert('Selecione o sexo');
	form.sexo.style.backgroundColor="#767bff";
    form.sexo.style.color="#ffffff";
	form.sexo.focus();
 	return false;
} 

//Valida o nome

if (form.nome.value=="") {
	document.getElementById("nome").style.display="inline"; 
	form.nome.style.backgroundColor="#767bff";
    form.nome.style.color="#ffffff";
	form.nome.focus();
return false;
}

//Valida o sobrenome

if (form.sobrenome.value=="") {
	document.getElementById("sobrenome").style.display="inline"; 
	form.sobrenome.style.backgroundColor="#767bff";
    form.sobrenome.style.color="#ffffff";
	form.sobrenome.focus();
return false;
}

//Valida o e-mail

var filtro_mail = /^.+@.+\..{2,3}$/
	if (!filtro_mail.test(form.email.value) || form.email.value=="") {
	document.getElementById("email").style.display="inline"; 
	form.email.style.backgroundColor="#767bff";
    form.email.style.color="#ffffff";
	form.email.focus();
return false;
}

//Valida a data de nascimento 

var patternData = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/; 
	if (form.idade.value=="" || !patternData.test(form.idade.value)){ 
 	document.getElementById("idade").style.display="inline"; 
	form.idade.style.backgroundColor="#767bff ";
    form.idade.style.color="#ffffff";
	form.idade.focus();
	return false;
}  
    
// Valida o País

if (form.pais.value=="") {
	document.getElementById("pais").style.display="inline"; 
	form.pais.style.backgroundColor="#767bff";
    form.pais.style.color="#ffffff";
	form.pais.focus();
return false;
}

//Valida o Estado

if (form.estado.value=="") {
	document.getElementById("estado").style.display="inline"; 
	form.estado.style.backgroundColor="#767bff";
    form.estado.style.color="#ffffff";
	form.estado.focus();
return false;
}

//Valida a cidade

if (form.cidade.value=="") {
	document.getElementById("cidade").style.display="inline"; 
	form.cidade.style.backgroundColor="#767bff";
    form.cidade.style.color="#ffffff";
	form.cidade.focus();
return false;
} 

}