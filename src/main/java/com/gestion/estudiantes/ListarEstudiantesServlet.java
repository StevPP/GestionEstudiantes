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

@WebServlet("/listarEstudiantes")
public class ListarEstudiantesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            String query = "SELECT * FROM Estudiantes";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            List<Estudiante> estudiantes = new ArrayList<>();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setDireccion(rs.getString("direccion"));
                estudiante.setCalificaciones(rs.getFloat("calificaciones"));

                estudiantes.add(estudiante);
            }

            request.setAttribute("estudiantes", estudiantes);
            request.getRequestDispatcher("listado.jsp").forward(request, response);

            rs.close();
            pst.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

