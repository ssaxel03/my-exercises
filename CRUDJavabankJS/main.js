let url = "http://localhost:8080/javabank5/api/customer/";

window.addEventListener("load", () => {
    populateTable();

    document.querySelector("#reset").addEventListener("click", () => {

        document.querySelector("#idForm").setAttribute("value", null);
        document.querySelector("#firstNameTA").value = "";
        document.querySelector("#lastNameTA").value = "";
        document.querySelector("#emailTA").value = "";
        document.querySelector("#phoneTA").value = "";
    })

    document.querySelector("#add").addEventListener("click", async () => {

        let customer = {
            id: null,
            firstName: document.querySelector("#firstNameTA").value,
            lastName: document.querySelector("#lastNameTA").value,
            email: document.querySelector("#emailTA").value,
            phone: document.querySelector("#phoneTA").value,
        }

            await fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(customer),
            }).catch((error) => console.log(error));

            document.querySelector("#firstNameTA").value = "";
            document.querySelector("#lastNameTA").value = "";
            document.querySelector("#emailTA").value = "";
            document.querySelector("#phoneTA").value = "";

            populateTable();

    })

    document.querySelector("#update").addEventListener("click", async () => {

        let customer = {
            id: document.querySelector("#idForm").value,
            firstName: document.querySelector("#firstNameTA").value,
            lastName: document.querySelector("#lastNameTA").value,
            email: document.querySelector("#emailTA").value,
            phone: document.querySelector("#phoneTA").value,
        }

        console.log(customer);

        console.log(url + document.querySelector("#idForm").value);

            await fetch(url + document.querySelector("#idForm").value, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(customer),
            }).catch((error) => console.log(error));

            document.querySelector("#idForm").setAttribute("value", null);
            document.querySelector("#firstNameTA").value = "";
            document.querySelector("#lastNameTA").value = "";
            document.querySelector("#emailTA").value = "";
            document.querySelector("#phoneTA").value = ""

            populateTable();

    })

})

async function populateTable() {

    let users;

    try {
        users = await (await fetch(url)).json();
    } catch {
        console.log("caquinha");
    }
    
    let main = document.querySelector("#customerListMain");
    while(main.firstChild) {
        main.removeChild(main.lastChild);
    }
    let title = document.createElement("h4");
    title.innerHTML = "List of customers";
    let table = document.createElement("table");
    main.appendChild(title);
    main.appendChild(table);

    users.map(user => {
        let row = table.insertRow();

        let firstName = row.insertCell(0);
        firstName.setAttribute("class", "cell");
        firstName.innerHTML = user.firstName;

        let lastName = row.insertCell(1);
        lastName.setAttribute("class", "cell");
        lastName.innerHTML = user.lastName;

        let email = row.insertCell(2);
        email.setAttribute("class", "cell");
        email.innerHTML = user.email;

        let phone = row.insertCell(3);
        phone.setAttribute("class", "cell");
        phone.innerHTML = user.phone;

        let editCell = row.insertCell(4);
        editCell.setAttribute("class", "cell button-cell");
        let editBtn = document.createElement("button");
        editBtn.setAttribute("class", "btn btn-success");
        editBtn.innerHTML = "EDIT";
        editBtn.addEventListener("click", () => {
            document.querySelector("#idForm").setAttribute("value", user.id);
            document.querySelector("#firstNameTA").value = user.firstName;
            document.querySelector("#lastNameTA").value = user.lastName;
            document.querySelector("#emailTA").value = user.email;
            document.querySelector("#phoneTA").value = user.phone;
        })

        editCell.appendChild(editBtn);

        let deleteCell = row.insertCell(5);
        deleteCell.setAttribute("class", "cell button-cell");
        let deleteBtn = document.createElement("button");
        deleteBtn.setAttribute("class", "btn btn-danger");
        deleteBtn.innerHTML = "DELETE";
        deleteBtn.addEventListener("click", async () =>  {
             await fetch(url + user.id + "/", {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                },
            }).catch((error) => console.log(error));

            populateTable();
        })



        deleteCell.appendChild(deleteBtn);


    });

}

