package com.gestion.estudiantes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modificar")
public class ModificarEstudianteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del estudiante a modificar desde los parámetros de la solicitud
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            // Conexión a la base de datos
            Connection con = DatabaseConnection.initializeDatabase();
            String query = "SELECT * FROM Estudiantes WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            // Verificar si se encontró el estudiante con el ID dado
            if (rs.next()) {
                // Crear un objeto Estudiante con los datos obtenidos de la base de datos
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setDireccion(rs.getString("direccion"));
                estudiante.setCalificaciones(rs.getFloat("calificaciones"));

                // Guardar el objeto Estudiante en el atributo request para mostrar en el formulario JSP
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("modificar.jsp").forward(request, response);
            } else {
                // Si no se encuentra el estudiante, redirigir a una página de error o mostrar un mensaje adecuado
                response.sendRedirect("error.jsp");
            }

            // Cerrar recursos
            rs.close();
            pst.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener datos del formulario de modificación
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String direccion = request.getParameter("direccion");
        float calificaciones = Float.parseFloat(request.getParameter("calificaciones"));

        try {
            // Conexión a la base de datos
            Connection con = DatabaseConnection.initializeDatabase();
            String query = "UPDATE Estudiantes SET nombre = ?, telefono = ?, edad = ?, direccion = ?, calificaciones = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, telefono);
            pst.setInt(3, edad);
            pst.setString(4, direccion);
            pst.setFloat(5, calificaciones);
            pst.setInt(6, id);

            // Ejecutar la actualización
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                // Redirigir a la página de listado después de la modificación exitosa
                response.sendRedirect("listarEstudiantes");
            } else {
                // Manejo de errores en caso de que no se actualice ningún registro
                response.sendRedirect("error.jsp");
            }

            // Cerrar recursos
            pst.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
