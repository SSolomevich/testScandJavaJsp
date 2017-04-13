package ru.testScandJavaJsp.model;

import java.time.LocalDate;

/**
 * Created by Sergey Solomevich on 08.04.2017.
 */
// Создаем модель для комбо бокса
public class ComboBoxDate {

    private String comboBoxDate;

    public ComboBoxDate() {
    }

    public ComboBoxDate(String comboBoxDate) {
        this.comboBoxDate = comboBoxDate;
    }

    public String getComboBoxDate() {
        return comboBoxDate;
    }

    public void setComboBoxDate(String comboBoxDate) {
        this.comboBoxDate = comboBoxDate;
    }
}
