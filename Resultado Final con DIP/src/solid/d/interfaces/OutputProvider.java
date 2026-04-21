package solid.d.interfaces;

public interface OutputProvider {
    void displayMenu();
    void displayResult(String operationName, double result);
    void displayError(String message);
    void displayMessage(String message);
}
