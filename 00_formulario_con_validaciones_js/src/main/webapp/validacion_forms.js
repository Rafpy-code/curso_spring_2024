/*
const btn_registrar = document.getElementById('btn_registrar').addEventListener('click', (e) => {
	e.preventDefault();
	// VARIAS FORMAS DE ACCEDER A LOS ELEMENTPS DEL FORMULARIO.
	const usuario = document.querySelector('#formulario_registro [name="usuario"]');
	console.log(usuario.value);
	
	const formulario = document.forms['formulario_registro'];
	
	const password = formulario['password'];
	console.log(password.value);
	const password1 = formulario['password1'];
	console.log(password1.value);
	
	const email = formulario.email;
	console.log(email.value);
	
	const telefono = formulario.telefono;
	console.log(telefono.value);
}); */

// EVENTO SUBMIT
const formulario = document.forms['formulario_registro'];
formulario.addEventListener('submit', (e)=>{
	e.preventDefault();
	
	const datos = {
		usuario: formulario.usuario.value,
		password: formulario.password.value,
		password1: formulario.password1.value,
		email : formulario.email.value,
		telefono: formulario.telefono.value
	}
	
	const expresionRegular = /[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+/;
	if (!expresionRegular.test(correo)) {
		console.log('El correo es invalido');
		return;
	}
	
		
	console.log('Enviando datos...' + datos);
});


