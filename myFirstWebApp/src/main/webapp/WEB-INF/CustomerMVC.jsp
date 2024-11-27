<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 27/11/2024
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>${user.name}</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/da971305a9.js" crossorigin="anonymous"></script>
        <link href="${pageContext.request.contextPath}/custom.css" type="text/css" rel="stylesheet">
    </head>
<body>
    <div class="card text-bg-info mb-3" style="max-width: 18rem;">
        <div class="card-header">JAVABANK - Customer #1</div>
        <div class="card-body">
            <h5 class="card-title">${user.name}</h5>
            <p class="card-text">
                <i class="fa-solid fa-envelope"></i> ${user.email}<br><i class="fa-solid fa-square-phone-flip"></i> ${user.phone}
            </p>
        </div>
    </div>


</body>
</html>
