module openfxtest {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens openfxtest to javafx.graphics;
}
