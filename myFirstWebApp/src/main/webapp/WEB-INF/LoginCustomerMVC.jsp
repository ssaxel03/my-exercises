<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 27/11/2024
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/da971305a9.js" crossorigin="anonymous"></script>
</head>
<body>

<form action="/cenas/customermvc" method="post">

    <div class="row g-3 align-items-center">

        <div class="col-auto">
            <label for="name" class="col-form-label">Name</label>
        </div>
        <div class="col-auto">
            <input type="text" id="name" name="name" class="form-control">
        </div>

        <div class="col-auto">
            <label for="email" class="col-form-label">Email</label>
        </div>
        <div class="col-auto">
            <input type="email" id="email" name="email" class="form-control">
        </div>

        <div class="col-auto">
            <label for="phone" class="col-form-label">Phone number</label>
        </div>
        <div class="col-auto">
            <input type="number" id="phone" name="phone" class="form-control" aria-describedby="passwordHelpInline">
        </div>

        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Login</button>
        </div>

    </div>

</form>

</body>
</html>
