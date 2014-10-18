
function valida(form) {

	//Valida senha 

	if (form.senha.value=="" || form.senha.value.length < 4) {
	document.getElementById("password").style.display="inline"; 
	form.senha.style.backgroundColor="#767bff";
    form.senha.style.color="#ffffff";
	form.senha.focus();
	return false;

}

	//Valida se o campo de confirmação de senha está correto

	if (form.conf_senha.value=="" || form.conf_senha.value.length < 4) {
	document.getElementById("confPass").style.display="inline"; 
	form.conf_senha.style.backgroundColor="#767bff";
    form.conf_senha.style.color="#ffffff";
	form.conf_senha.focus();
	return false;
}

// Valida se as senhas conferem

	if (form.password.value!=form.confPass.value) {
	document.getElementById("confPass").style.display="inline"; 
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
	document.getElementById("name").style.display="inline"; 
	form.nome.style.backgroundColor="#767bff";
    form.nome.style.color="#ffffff";
	form.nome.focus();
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

}