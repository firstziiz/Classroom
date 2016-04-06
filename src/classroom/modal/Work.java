/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom.modal;

import classroom.database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KS
 */
public class Work {
    int id;
    String name;
    String desc;
    int status;
    int score;
    int std;
    int tch;
    String path;
    
    
    public Work(int id) throws SQLException{
        Connection conn = ConnectionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from Work where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.desc = rs.getString("description");
            this.status = rs.getInt("status");
            this.score = rs.getInt("score");
            this.tch = rs.getInt("tch");
            this.std = rs.getInt("std");
            this.path = rs.getString("path");
        }

    }
    // [STATIC] Get All Student on Arraylist
    public static ArrayList<Work> getAllStudent() throws SQLException {
        Connection conn = ConnectionDB.getConnection();
        ArrayList<Work> listWrk = new ArrayList<Work>();
        PreparedStatement ck = conn.prepareStatement("select * from Work");
        ResultSet result = ck.executeQuery();
        while (result.next()) {
            listWrk.add(new Work(result.getInt("id")));
        }
        return listWrk;
    }

    @Override
    public String toString() {
        return "Work{" + "id=" + id + ", name=" + name + ", desc=" + desc + ", status=" + status + ", score=" + score + ", std=" + std + ", tch=" + tch + ", path=" + path + '}';
    }
    
    
    
}
