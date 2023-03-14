/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import context.DBContext;
import entity.FlashCard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class FlashCard_DAO extends DBContext {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<FlashCard> getFlashCard() {
        List<FlashCard> list = new ArrayList<>();
        String query = "Select*from Flashcard";
        try {

            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FlashCard(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));

            }
        } catch (Exception e) {
        }
        return list;

    }

    public void deleteID(String id) {
        String query = "Delete from Flashcard\n"
                + "where flash_id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void insertFlashCard(String id, String question, String answer, String lid) {
        String query = "insert into Flashcard values (?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, question);
            ps.setString(3, answer);
            ps.setString(4, lid);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {

        }

    }

    public FlashCard getFlashCarbID(String id) {
        String query = "select * from Flashcard\n"
                + "where flash_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new FlashCard(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }

        } catch (Exception e) {

        }
        return null;
    }

    public void updateFlashCard(String id, String question, String answer, String lid) {
        String query = "update Flashcard\n"
                + "set flash_question = ?,\n"
                + "flash_answer = ?,\n"
                + "lesson_id = ?\n"
                + "where flash_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, question);
            ps.setString(2, answer);
            ps.setString(3, lid);
            ps.setString(4, id);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        FlashCard_DAO dao = new FlashCard_DAO();
        FlashCard f = dao.getFlashCarbID("12");
        System.out.println(f);
    }
}
