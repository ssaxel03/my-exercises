<html>
    <head>
        <title>JavaBank</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <div class="card text-white bg-info mb-3" style="max-width: 20rem; margin:auto;">
            <div class="card-header text-center">JAVABANK - Customer #${customer.id}</div>
                <div class="card-body">
                    <h5 class="card-title text-center">${customer.firstName} ${customer.lastName}</h5>
                    <div class="card-text">
                        <p><i class="fas fa-envelope"></i> ${customer.email}</p>
                        <p><i class="fas fa-phone-square"></i> ${customer.phone}</p>
                    </div>
                </div>
            </div>
    </body>
</html>
