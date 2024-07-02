<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar Estudiante</title>
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
        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: left; /* Alinea el texto a la izquierda dentro del formulario */
        }
        input[type="text"], input[type="number"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            text-align: center; /* Centra el texto dentro de los campos de entrada */
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Modificar Estudiante</h1>
    <form action="modificar" method="post">
        <input type="hidden" name="id" value="${estudiante.id}">
        Nombre: <input type="text" name="nombre" value="${estudiante.nombre}" required><br>
        Teléfono: <input type="text" name="telefono" value="${estudiante.telefono}" required><br>
        Edad: <input type="number" name="edad" value="${estudiante.edad}" required><br>
        Dirección: <input type="text" name="direccion" value="${estudiante.direccion}" required><br>
        Calificaciones: <input type="number" step="0.01" name="calificaciones" value="${estudiante.calificaciones}" required><br>
        <input type="submit" value="Modificar">
    </form>
</body>
</html>


