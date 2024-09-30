function crash(num) {
	console.log(num);
	num++;
	return crash(num); 
}

let i = 0;

crash(i);
