/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author hp
 */
public class FlashCard {
    private int  flash_id;
    private String flash_question;
    private String flash_answer;
    private int lesson_id;

    public FlashCard() {
    }

    public FlashCard(int flash_id, String flash_question, String flash_answer, int lesson_id) {
        this.flash_id = flash_id;
        this.flash_question = flash_question;
        this.flash_answer = flash_answer;
        this.lesson_id = lesson_id;
    }

    public int getFlash_id() {
        return flash_id;
    }

    public void setFlash_id(int flash_id) {
        this.flash_id = flash_id;
    }

    public String getFlash_question() {
        return flash_question;
    }

    public void setFlash_question(String flash_question) {
        this.flash_question = flash_question;
    }

    public String getFlash_answer() {
        return flash_answer;
    }

    public void setFlash_answer(String flash_answer) {
        this.flash_answer = flash_answer;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    @Override
    public String toString() {
        return "flashcard{" + "flash_id=" + flash_id + ", flash_question=" + flash_question + ", flash_answer=" + flash_answer + ", lesson_id=" + lesson_id + '}';
    }
    
}
