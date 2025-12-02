package com.carlos.crudestudiantesws.dao;

import com.carlos.crudestudiantesws.model.Conexion;
import com.carlos.crudestudiantesws.model.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EstudianteDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Estudiante> obternerListaPorId(List<Integer> ids) {

        List<Estudiante> lista = new ArrayList<>();

        if (ids.isEmpty()) {
            return lista;
        }

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT * FROM estudiantes WHERE id IN (" + ids.stream().map(x -> "?").collect(Collectors.joining(",")) + ")";
            ps = cn.prepareStatement(sql);

            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(i + 1, ids.get(i));
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setPais_codigo(rs.getString("pais_codigo"));
                e.setCorreo(rs.getString("correo"));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
