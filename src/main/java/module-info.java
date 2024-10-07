module lk.ijse.gdse.Super.Super{
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.graphics;
        requires lombok;
        requires java.sql;

        opens lk.ijse.gdse.Super.dto.tm to javafx.base;
        opens lk.ijse.gdse.Super.controller to javafx.fxml;
        exports lk.ijse.gdse.Super;
        }