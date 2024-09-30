function delay(time) {
  return new Promise(resolve => setTimeout(resolve, time));
}

function Message(mensagem) {
	for(let i = 0;i<10000;i++) {
		setTimeout(() => {
   			 console.log(mensagem);
		}, 500);
	}
}

Message("O Diogo é totó");
