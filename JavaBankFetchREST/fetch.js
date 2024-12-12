const url = "http://localhost:8080/javabank5/api/customer/";

let container = document.getElementById("table");
let buttonGet;

window.addEventListener("load", () => {
    buttonGet = document.querySelector("#get-users");


    buttonGet.addEventListener("click", buttonClick);
  });

function buttonClick () {

    console.log("olá");

    fetch(url)
        .then((response) => response.json())
        .then((data) => populateHTML(data))
        .catch((error) => errorFetching(error));

    if (container.hasChildNodes) {
        while(container.firstChild) {
            container.removeChild(container.lastChild);
        }
    }

    let loading = document.createElement("h4");
    loading.innerHTML = "LOADING";
    container.appendChild(loading);
}

function errorFetching(error) {

    if (container.hasChildNodes) {
        while(container.firstChild) {
            container.removeChild(container.lastChild);
        }
    }

    let errorMessage = document.createElement("h4");
    errorMessage.innerHTML = error;
    container.appendChild(errorMessage);
}

function populateHTML(json) {

    if (container.hasChildNodes) {
        while(container.firstChild) {
            container.removeChild(container.lastChild);
        }
    }

    let table = document.createElement("table");
    table.className = "table";
    container.appendChild(table);

    let header = table.createTHead();
    let headerRow = header.insertRow();
    let headerId = headerRow.insertCell(0);
    headerId.setAttribute("scope", "col");
    headerId.outerHTML = "<th>ID</th>";
    let headerFirstName = headerRow.insertCell(1);
    headerFirstName.setAttribute("scope", "col");
    headerFirstName.outerHTML = "<th>FIRST NAME</th>";
    let headerLastName = headerRow.insertCell(2);
    headerLastName.setAttribute("scope", "col");
    headerLastName.outerHTML = "<th>LAST NAME</th>";
    let headerEmail = headerRow.insertCell(3);
    headerEmail.setAttribute("scope", "col");
    headerEmail.outerHTML = "<th>EMAIL</th>";
    let headerPhone = headerRow.insertCell(4);
    headerPhone.setAttribute("scope", "col");
    headerPhone.outerHTML = "<th>PHONE</th>";

    let tbody = table.createTBody();


    json.map(single => {

        let row = tbody.insertRow();
        let id = row.insertCell(0);
        id.innerHTML = single.id;
        let firstName = row.insertCell(1);
        firstName.innerHTML = single.firstName;
        let lastName = row.insertCell(2);
        lastName.innerHTML = single.lastName;
        let email = row.insertCell(3);
        email.innerHTML = single.email;
        let phone = row.insertCell(4);
        phone.innerHTML = single.phone;
     });  

}