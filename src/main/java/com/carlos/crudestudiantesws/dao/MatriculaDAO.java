package com.carlos.crudestudiantesws.dao;

import com.carlos.crudestudiantesws.model.Conexion;
import com.carlos.crudestudiantesws.model.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Materia> listarMatriculas(int idEstudiante) {
        ArrayList<Materia> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT m.id, m.codigo, m.nombre, m.descripcion FROM matricula mat INNER JOIN materia m ON mat.id_materia = m.id WHERE mat.id_estudiante = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idEstudiante);
            rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setId(rs.getInt("id"));
                m.setCodigo(rs.getString("codigo"));
                m.setNombre(rs.getString("nombre"));
                m.setDescripcion(rs.getString("descripcion"));
                lista.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lista;
    }

    public List<Integer> obtenerEstudiantesPorMateria(int idMateria) {

        List<Integer> lista = new ArrayList<>();

        try {
            cn = Conexion.getConnection();
            String sql = "SELECT id_estudiante FROM matricula WHERE id_materia = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, idMateria);

            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

}
