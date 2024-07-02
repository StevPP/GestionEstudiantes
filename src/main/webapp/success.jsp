<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Éxito</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        .links {
            margin-top: 20px;
        }
        .links a {
            display: inline-block;
            margin: 10px;
            padding: 8px 16px;
            text-decoration: none;
            color: #007bff;
            border: 1px solid #007bff;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }
        .links a:hover {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
    <h1>Estudiante registrado con éxito!!</h1>
    <div class="links">
        <a href="registro.jsp">Registrar otro estudiante</a>
        <a href="listarEstudiantes">Listar estudiantes</a>
    </div>
</body>
</html>

